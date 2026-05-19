/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.expensetracker.model;

/**
 *
 * @author Wirya Angana
 */
public class TransportExpense extends Expense {
    public TransportExpense(int id, double amount, String category, String date, String note){
        super(id,amount,category,date, note);
    }
    @Override
    public String generateReport(){
        return "Transport Expense: Rp "+getAmount()+" | Date: "+getDate();
    }
}
