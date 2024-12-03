  public String getFQTableName()
  {
    String strReturn = null;
    // Are table names supported in table definitions?
    if (aSchema.getDBCatalog().getDBMeta().getSupportsCatalogsInTableDefinitions ())
    {
      // Yes, include catalog name in fq table name
      // Now check, where we have to specify the catalog
      if (aSchema.getDBCatalog().getDBMeta().getIsCatalogAtStart ())
      {
        // At the beginning
        strReturn = aSchema.getDBCatalog().getCatalogName() 
          + aSchema.getDBCatalog().getDBMeta().getCatalogSeparator ()
          + aSchema.getSchemaName() + "." + this.getTableName();
      }
      else
      {
        // At the end
        strReturn = aSchema.getSchemaName() + "." + this.getTableName()
          + aSchema.getDBCatalog().getDBMeta().getCatalogSeparator ()
          + aSchema.getDBCatalog().getCatalogName();
      }
    }
    else
    {
      strReturn = aSchema.getSchemaName() + "." + this.getTableName();
    }
    return strReturn;
  }