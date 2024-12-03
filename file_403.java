    public static void innerHtml(HTMLElement element, SafeHtml html) {
        if (element != null) {
            element.innerHTML = html.asString();
        }
    }