/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.expensetracker.model;

/**
 *
 * @author Wirya Angana
 */
public class Expense {
    private int id;
    private double amount;
    private String category;
    private String date;
    private String note;
    
    public Expense(int id, double amount, String category, String date, String note){
        this.id = id;
        this.amount = amount;
        this.category = category;
        this.date = date;
        this.note = note;
    }
    public int getId(){
         return id;
    }
    public double getAmount(){
         return amount;
    }
    public String getCategory(){
         return category;
     }
    public String getDate(){
        return date;
     }
    public String getNote(){
        return note;
    }
}
     
     
    
