/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.expensetracker.service;
import com.expensetracker.model.Expense;
import com.expensetracker.dc.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class ExpenseService {
    public void addExpense(double amount, String category, String date, String note){
        String sql = "INSERT INTO expenses(amount, category, date, note) VALUES(?,?,?,?)";
        
        try(Connection conn = DatabaseConnection.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setDouble(1, amount);
            pstmt.setString(2, category);
            pstmt.setString(3, date);
            pstmt.setString(4, note);
            pstmt.executeUpdate();
        } catch (Exception e){
            e.printStackTrace();
        }
        }
    public List<Expense> getAllExpenses(){
        List<Expense> expenses = new ArrayList<>();
        String sql = "SELECT * FROM expenses";
        
        try (Connection conn = DatabaseConnection.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery()) {
             
            while(rs.next()){
                Expense e = new Expense(
                rs.getInt("id"),
                rs.getDouble("amount"),
                rs.getString("category"), 
                rs.getString("date"),
                rs.getString("note")
            );
                expenses.add(e);
            }
            }catch(Exception e){
                e.printStackTrace();
            }
        return expenses;
            }
    
    public void deleteExpense(int id){
        String sql = "DELETE FROM expenses WHERE id = ?";
        try (Connection conn = DatabaseConnection.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql)){
            
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (Exception e){
            e.printStackTrace();
}
}
    public double getTotalExpenses(){
        String sql = "SELECT SUM(amount) as total FROM expenses";
        try(Connection conn = DatabaseConnection.connect();
           PreparedStatement pstmt = conn.prepareStatement(sql);
           ResultSet rs = pstmt.executeQuery()){
            
            if (rs.next()){
                return rs.getDouble("total");
            }
            } catch (Exception e){
                e.printStackTrace();
            }
        return 0;
            }
    public Map<String, Double> getTotalByCategory(){
        Map<String, Double> categoryTotals = new HashMap<>();
        String sql = "SELECT category, SUM(amount) as total FROM expenses GROUP BY category";
        
        try(Connection conn = DatabaseConnection.connect();
           PreparedStatement pstmt = conn.prepareStatement(sql);
           ResultSet rs = pstmt.executeQuery()){
            
           while(rs.next()){
               categoryTotals.put(
                    rs.getString("category"),
                    rs.getDouble("total")
               );
           }
           } catch(Exception e){
               e.printStackTrace();
           }
        return categoryTotals;
        }
    }
        
   


      
