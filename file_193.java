    private CmsSearchIndexSource createDummyIndexSource() {

        CmsSearchIndexSource result = new CmsSearchIndexSource();
        result.setName("default");
        result.setIndexerClassName("org.opencms.search.CmsVfsIndexer");
        result.addDocumentType("html");
        result.addDocumentType("generic");
        result.addDocumentType("pdf");
        // add search index source to config:
        m_searchManager.addSearchIndexSource(result);
        return result;
    }