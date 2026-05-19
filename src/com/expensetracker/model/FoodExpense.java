/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.expensetracker.model;

/**
 *
 * @author Wirya Angana
 */
public class FoodExpense extends Expense {
    public FoodExpense(int id, double amount, String category, String date, String note){
        super(id,amount,category,date,note);
    }
    @Override
    public String generateReport(){
        return"Food Expense: Rp "+getAmount()+" | Note: "+getNote();
    }
}
