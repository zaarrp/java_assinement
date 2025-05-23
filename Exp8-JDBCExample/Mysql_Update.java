/*8b. Read all the existing records from the table coffee which is from the database test and update an
existing coffee product in the table with its id. [Create a table coffee with fields
( id,coffee_name,price)] using HTML and JSP to get the fields and display the results respectively*/

package com.mysql;
import java.sql.*;
import java.util.Properties;
public class Mysql_Update
{
 public static void main(String[] args)
 {
 try
 {

 Connection dbConnection = null;
 try { String url = "jdbc:mysql://localhost/test";
 Properties info = new Properties();
 info.put("user", "root");
 info.put("password", "");
 dbConnection = DriverManager.getConnection(url, info);
 if (dbConnection != null)
 {
 System.out.println("Successfully connected to MySQL database test");
 }
 }
 catch (SQLException ex)
 { System.out.println("An error occurred while connecting MySQL databse");
 ex.printStackTrace(); }


 // SQL SELECT query.
 // if you only need a few columns, specify them by name instead of using "*"
 String query = "SELECT * FROM coffee";
 // create the java statement
 Statement st = dbConnection.createStatement();

 // execute the query, and get a java resultset
 ResultSet rs = st.executeQuery(query);

 // iterate through the java resultset
 while (rs.next())
 {
 int id = rs.getInt("id");
 String coffee_name = rs.getString("coffee_name");
 int price= rs.getInt("price");

 // print the results
 System.out.format("\n%d %s %d", id,coffee_name,price);
 }

 rs.close();
 // updating records
 String query2 = "update coffee set price=950 where id=102";
 PreparedStatement preparedStmt1 = dbConnection.prepareStatement(query2);
 preparedStmt1.execute();

 preparedStmt1.close();
 }
 catch (Exception e)
 {
 System.err.println("Got an exception! ");
 System.err.println(e.getMessage());
 }
 }
}