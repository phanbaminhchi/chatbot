package org.o7planning.tutorial.jdbc;
 
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
 
public class ConnectionUtils {
 
  public static Connection getMyConnection() throws SQLException,
          ClassNotFoundException {
      return SQLServerConnUtils_SQLJDBC.getSQLServerConnection();
  }
 
  public static void main(String[] args) throws SQLException,
          ClassNotFoundException {
 
      System.out.println("Get connection ... ");
 
      Connection conn = ConnectionUtils.getMyConnection();
 
      System.out.println("Get connection " + conn);
 
      Statement statement = conn.createStatement();
 	 
      String sql = "Select StudentId,Name from Student";
 
      ResultSet rs = statement.executeQuery(sql);
 
      while (rs.next()) {
          String empId = rs.getString("StudentId");
          String empName = rs.getString("Name");
          System.out.println("--------------------");
          System.out.println("StudentId:" + empId);
          System.out.println("Name:" + empName);
      System.out.println("Done!");
  }
  }
}