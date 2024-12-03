    private List<RowProcessingConsumer> extractConsumers(AnalysisJob analysisJob,
            AnalyzerBeansConfiguration analyzerBeansConfiguration, Configuration configuration) {
        final InjectionManager injectionManager = analyzerBeansConfiguration.getInjectionManager(analysisJob);
        final ReferenceDataActivationManager referenceDataActivationManager = new ReferenceDataActivationManager();

        final LifeCycleHelper lifeCycleHelper = new LifeCycleHelper(injectionManager, referenceDataActivationManager,
                configuration.includeNonDistributedTasks);
        SourceColumnFinder sourceColumnFinder = new SourceColumnFinder();
        sourceColumnFinder.addSources(analysisJob);

        /**
         * Use a single threaded task runner since this handler is invoked in a
         * blocking way - the calling code may itself be multithreaded without
         * issues.
         */
        final SingleThreadedTaskRunner taskRunner = new SingleThreadedTaskRunner();

        final AnalysisListener analysisListener = configuration.analysisListener;
        final RowProcessingPublishers rowProcessingPublishers = new RowProcessingPublishers(analysisJob,
                analysisListener, taskRunner, lifeCycleHelper, sourceColumnFinder);

        final RowProcessingPublisher publisher;
        if (configuration.table != null) {
            publisher = rowProcessingPublishers.getRowProcessingPublisher(configuration.table);
            if (publisher == null) {
                throw new IllegalArgumentException("Job does not consume records from table: " + configuration.table);
            }
        } else {
            final Collection<RowProcessingPublisher> publisherCollection = rowProcessingPublishers
                    .getRowProcessingPublishers();
            if (publisherCollection.size() > 1) {
                throw new IllegalArgumentException(
                        "Job consumes multiple tables, but ConsumeRowHandler can only handle a single table's components. Please specify a Table constructor argument.");
            }
            publisher = publisherCollection.iterator().next();
        }

        final AtomicReference<Throwable> errorReference = new AtomicReference<Throwable>();

        publisher.initializeConsumers(new TaskListener() {
            @Override
            public void onError(Task task, Throwable throwable) {
                logger.error("Exception thrown while initializing consumers.", throwable);
                errorReference.compareAndSet(null, throwable);
            }

            @Override
            public void onComplete(Task task) {
                logger.info("Consumers initialized successfully.");
            }

            @Override
            public void onBegin(Task task) {
                logger.info("Beginning the process of initializing consumers.");
            }
        });

        final Throwable throwable = errorReference.get();
        if (throwable != null) {
            if (throwable instanceof RuntimeException) {

            }
        }

        List<RowProcessingConsumer> consumers = publisher.getConfigurableConsumers();
        if (!configuration.includeAnalyzers) {
            consumers = removeAnalyzers(consumers);
        }

        consumers = RowProcessingPublisher.sortConsumers(consumers);
        return consumers;
    }