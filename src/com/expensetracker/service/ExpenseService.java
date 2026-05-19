/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.expensetracker.service;
import com.expensetracker.model.Expense;
import com.expensetracker.dc.DatabaseConnection;
import com.expensetracker.dao.ExpenseDAO;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class ExpenseService {
    private ExpenseDAO dao = new ExpenseDAO();
    public void createTableIfNotExists(){
        dao.createTableIfNotExists();
    }
    public void addExpense(double amount, String category, String date, String note){
        dao.addExpense(amount,category,date,note);
        }
    public List<Expense> getAllExpenses(){
        return dao.getAllExpenses();
            }

    public void deleteExpense(int id){
        dao.deleteExpense(id);
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
    public List<Expense> searchExpenses(String keyword){
        List<Expense> results = new ArrayList<>();
        keyword = keyword.toLowerCase().trim();
        for(Expense e :dao.getAllExpenses()){
            String category = e.getCategory().toLowerCase();
            String date = e.getDate().toLowerCase().trim();
            
            String yearMonth = "";
            if(date.length()>=7){
                yearMonth = date.substring(0,7);
            }
            if(yearMonth.equals(keyword)||category.contains(keyword)||date.contains(keyword)){
                results.add(e);
            }
        }
        return results;
    }
    public List<Expense> sortByAmount(){
        List<Expense> list = dao.getAllExpenses();
        for(int i = 1; i<list.size(); i++){
            Expense key = list.get(i);
            int j= i - 1;
            while (j >= 0 &&
                list.get(j).getAmount()>key.getAmount()){
            list.set(j+1,list.get(j));
            j--;
            }
            list.set(j+1,key);
        }
        return list;
    }
    }





