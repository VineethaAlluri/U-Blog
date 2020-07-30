package com.upgrad.ublog.db;

/**
 * TODO 6.2: Implement the DatabaseConnection class using the Singleton Pattern (Hint. Should have the
 *  private no-arg constructor, a private static connection attribute of type Connection and a public
 *  static getConnection() method which return the connection attribute).
 * TODO 6.3: The getInstance() method should check if the connection attribute is null. If yes, then
 *  it should create a connection object which is connected with the local database and assign this
 *  connection object to the connection attribute. In the end, return this connection attribute.
 * TODO 6.4: You should handle the ClassNotFoundException and SQLException individually,
 *  and not using the Exception class.
 */

public class DatabaseConnection {

    /*public static void main(String[] args) throws SQLException{
        try {
        	DatabaseConnection.getConnection();
        	System.out.println("Connected");
        } catch (Exception e) {
        	System.out.println("Not Connected");
        }
    }*/
}
