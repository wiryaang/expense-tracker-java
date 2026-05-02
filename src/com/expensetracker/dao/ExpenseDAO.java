/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.expensetracker.dao;
import com.expensetracker.model.Expense;
import com.expensetracker.dc.DatabaseConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class ExpenseDAO {
    public void addExpense(double amount, String category, String date, String note){
        String sql = "INSERT INTO expenses(amount, category, date, note) VALUES(?,?,?,?)";
        
        try(Connection conn = DatabaseConnection.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql)){
            
            pstmt.setDouble(1,amount);
            pstmt.setString(2, category);
            pstmt.setString(3, date);
            pstmt.setString(4, note);
            
            pstmt.executeUpdate();
            
        } catch(SQLException e){
            e.printStackTrace();
        }
    }
    public List<Expense> getAllExpenses(){
        List<Expense> list = new ArrayList<>();
        String sql = "SELECT * FROM expenses";
        
        try(Connection conn = DatabaseConnection.connect();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)){
            
            while(rs.next()){
                list.add(new Expense(
                rs.getInt("id"),
                rs.getDouble("amount"),
                rs.getString("category"),
                rs.getString("date"),
                rs.getString("note")
                ));
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return list;
    }
    public void deleteExpense(int id){
        String sql = "DELETE FROM expenses WHERE id = ?";
        
        try (Connection conn = DatabaseConnection.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql)){
            
            pstmt.setInt(1,id);
            pstmt.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
    public void createTableIfNotExists(){
        String sql = "CREATE TABLE IF NOT EXISTS expenses ("
                + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "amount REAL,"
                + "category TEXT,"
                + "date TEXT,"
                + "note TEXT"
                + ");";
        try(Connection conn = DatabaseConnection.connect();
                Statement stmt = conn.createStatement()){
            stmt.execute(sql);
        } catch(SQLException e){
            e.printStackTrace();
        }
    }
}
