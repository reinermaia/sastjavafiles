  private java.sql.Connection connectToDB(String strJDBCDriver, String strJDBCURL, 
    String strUsername, String strPassword)
  {
      try
      {
          Class.forName(strJDBCDriver); // "com.informix.jdbc.IfxDriver"
          java.sql.Connection conn = 
            java.sql.DriverManager.getConnection(strJDBCURL, 
                strUsername, strPassword);  // "jdbc:informix-sqli://moon:1526/bci_test:INFORMIXSERVER=ol_bci", "informix", "informix"
          return conn;
      }
      catch (java.sql.SQLException sqlEx)
      {
          java.sql.SQLException currentSqlEx = sqlEx;
          System.out.println (sqlEx.getErrorCode() + ":" + sqlEx.getMessage());
          while (currentSqlEx.getNextException() != null)
          {
            currentSqlEx = currentSqlEx.getNextException();
            System.out.println (sqlEx.getErrorCode() + ":" + sqlEx.getMessage());
          }
          JOptionPane.showMessageDialog(mainFrame, "Error connecting to database:\n" + sqlEx.getMessage(), "SQL Error", JOptionPane.ERROR_MESSAGE);          
          return null;
      }
      catch (java.lang.ClassNotFoundException clNotFoundEx)
      {
          clNotFoundEx.printStackTrace();
          JOptionPane.showMessageDialog(mainFrame, "Cannot find driver class:\n" + clNotFoundEx.getMessage(), "Class Not Found", JOptionPane.ERROR_MESSAGE);
          return null;
      }
      catch (Throwable t)
      {
          t.printStackTrace();
          JOptionPane.showMessageDialog(mainFrame, "Unknown error:\n" + t.getMessage(), "Unknown Error", JOptionPane.ERROR_MESSAGE);
          return null;
      }              
  }  