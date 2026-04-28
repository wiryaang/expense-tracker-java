/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.expensetracker.service;
import com.expensetracker.model.Expense;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
public class ExpenseService {
    private List<Expense> expenses;
    private int currentId;
    
    public ExpenseService(){
        expenses = new ArrayList<>();
        currentId = 1;
    }
    public void addExpense(double amount, String category, String date, String note){
        Expense expense = new Expense(currentId++, amount, category, date, note);
        expenses.add(expense);
    }
    public List<Expense> getAllExpenses(){
        return expenses;
    }
    public void deleteExpense(int id){
        expenses.removeIf(e -> e.getId() == id);
    }
    public double getTotalExpenses(){
        double total = 0;
        for(Expense e:expenses){
            total += e.getAmount();
        }
        return total;
    }
    public Map<String, Double> getTotalByCategory(){
        Map<String,Double> categoryTotals = new HashMap<>();
        
        for(Expense e: expenses){
            String category = e.getCategory();
            double amount = e.getAmount();
            categoryTotals.put(
            category,
            categoryTotals.getOrDefault(category,0.0)+ amount
            );
        }
        return categoryTotals;
    }
}

  
