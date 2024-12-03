    @ShellMethod(value = "Display or save the history of previously run commands")
    public List<String> history(@ShellOption(help = "A file to save history to.", defaultValue = ShellOption.NULL) File file) throws IOException {
        if (file == null) {
            List<String> result = new ArrayList<>(jLineHistory.size());
            jLineHistory.forEach(e -> result.add(e.line()));
            return result;
        } else {
            try (FileWriter w = new FileWriter(file)) {
                for (org.jline.reader.History.Entry entry : jLineHistory) {
                    w.append(entry.line()).append(System.lineSeparator());
                }
            }
            return Collections.singletonList(String.format("Wrote %d entries to %s", jLineHistory.size(), file));
        }
    }