  @Nullable
  public static IHCNode createLinkedWebsite (@Nullable final String sWebsite, @Nullable final HC_Target aTarget)
  {
    if (StringHelper.hasNoText (sWebsite))
      return null;

    if (!URLValidator.isValid (sWebsite))
      return new HCTextNode (sWebsite);

    return new HCA (new SimpleURL (sWebsite)).setTarget (aTarget).addChild (sWebsite);
  }