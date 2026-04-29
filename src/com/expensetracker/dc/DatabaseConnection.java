/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.expensetracker.dc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class DatabaseConnection {
    private static final String URL = "jdbc:sqlite:C:/Users/Wirya Angana/Documents/NetBeansProjects/Lecture 1/ExpenseTracker/expenses.db";
    
    public static Connection connect() throws SQLException {
        try{
        Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        return DriverManager.getConnection(URL);
    }
}
