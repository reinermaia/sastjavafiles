    public void createHiddenField(AbstractRenderAppender results)
            throws JspException
    {
        if (_repIdx == 0 && !_disabled) {

            ServletRequest req = pageContext.getRequest();

            //Create hidden field for state tracking
            String hiddenParamName = null;
            hiddenParamName = getQualifiedDataSourceName() + OLDVALUE_SUFFIX;
            _hiddenState.name = hiddenParamName;
            _hiddenState.value = "true";

            TagRenderingBase hiddenTag = TagRenderingBase.Factory.getRendering(TagRenderingBase.INPUT_HIDDEN_TAG, req);
            hiddenTag.doStartTag(results, _hiddenState);
            hiddenTag.doEndTag(results);
        }

    }