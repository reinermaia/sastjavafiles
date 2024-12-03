	public Stream<String[]> lines() throws IOException {
		return Files.lines(path)
			.map(line -> line.contains("#") ? line.substring(0, line.indexOf('#')) : line)
			.map(line -> line.trim())
			.filter(line -> !line.isEmpty())
			.map(line -> {
				List<String> list = Arrays.stream(line.split("\t")).map(col -> col.trim()).collect(Collectors.toList());
				return list.toArray(new String[list.size()]);
			})
			.filter(line -> {
				if(line.length < 3) {
					LOGGER.warn("Ignoring line <{}>. Only {} columns", Joiner.on('t').join(line), line.length);
					return false;
				} else 
					return true;
			})
			.map(line -> {
				if(line.length > 3) { 
					LOGGER.warn("Line <{}> has {} columns (only three columns required). Ignoring additional columns.", Joiner.on('t').join(line), line.length);
					return new String[] {line[0], line[1], line[2]};
				} else
					return line;
			});
	}