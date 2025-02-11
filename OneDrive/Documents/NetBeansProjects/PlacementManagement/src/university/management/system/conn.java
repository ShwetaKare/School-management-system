/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package university.management.system;

/**
 *
 * @author shwet
 */
import java.sql.*; // Java's SQL package

//register a driver class
//create connection string
//creating statement
//executing mysql queries
//closing the connection
public class conn {

    Connection c;
    Statement s;

    // Constructor
    conn() {
        try {
            // Load MySQL Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish the connection
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/universitymanagementsystem", "root",
                    "Shweta@29");

            // Create a Statement object
            s = c.createStatement();

            System.out.println("Connected successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Main Method
    public static void main(String[] args) {
        new conn();
    }
}
