    public static Map<String, List<String>> extractHTMLheaders(String html) {
        Map<String, List<String>> hxtagsMap = new HashMap<>();
        for(int i=1;i<=6;++i) {
            hxtagsMap.put("H"+i, new ArrayList<>());
        }
                
        Matcher m = HX_PATTERN.matcher(html);
        while (m.find()) {
            if(m.groupCount()==2) {
                String tagType = m.group(1).toUpperCase(Locale.ENGLISH);
                String content = m.group(2);
                hxtagsMap.get(tagType).add(clear(content));
            }
        }
        return hxtagsMap;
    }