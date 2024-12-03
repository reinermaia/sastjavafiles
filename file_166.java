	private String extractDocumentContent(String htmlContent){
		org.jsoup.nodes.Document doc = Jsoup.parse(htmlContent);
		
		String content = doc.body().text();
		
		return content;
	}