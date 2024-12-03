    protected void selectCheckbox(PageElement element, String valueKeyOrKey, Map<String, Boolean> values) throws TechnicalException, FailureException {
        final String valueKey = Context.getValue(valueKeyOrKey) != null ? Context.getValue(valueKeyOrKey) : valueKeyOrKey;
        try {
            final WebElement webElement = Context.waitUntil(ExpectedConditions.elementToBeClickable(Utilities.getLocator(element)));
            Boolean checkboxValue = values.get(valueKey);
            if (checkboxValue == null) {
                checkboxValue = values.get("Default");
            }
            if (webElement.isSelected() != checkboxValue.booleanValue()) {
                webElement.click();
            }
        } catch (final Exception e) {
            new Result.Failure<>(e.getMessage(), Messages.format(Messages.getMessage(Messages.FAIL_MESSAGE_UNABLE_TO_CHECK_ELEMENT), element, element.getPage().getApplication()), true,
                    element.getPage().getCallBack());
        }
    }