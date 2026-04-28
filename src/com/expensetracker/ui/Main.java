/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.expensetracker.ui;
import com.expensetracker.service.ExpenseService;
import com.expensetracker.model.Expense;
import java.util.List;
import java.util.Scanner;
import java.util.Map;
public class Main {
    public static void main(String[] args){
        ExpenseService service = new ExpenseService();
        Scanner scanner = new Scanner(System.in);
        
        while(true){
            System.out.println("\n=== Expense Tracker ===");
            System.out.println("1. Add Expense");
            System.out.println("2. View Expense");
            System.out.println("3. Delete Expense");
            System.out.println("4. View Total");
            System.out.println("5. View Category Summary");
            System.out.println("6. Exit");
            System.out.println("Choose: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine();
            
            if(choice ==1){
                System.out.println("Amount: ");
                double amount = scanner.nextDouble();
                scanner.nextLine();
                
                System.out.println("Category: ");
                String category = scanner.nextLine();
                
                System.out.println("Date: ");
                String date = scanner.nextLine();
                
                System.out.println("Note: ");
                String note = scanner.nextLine();
                
                service.addExpense(amount, category, date, note);
                System.out.println("Expense added!");
            } else if(choice == 2){
                List<Expense> expenses = service.getAllExpenses();
                if(expenses.isEmpty()){
                    System.out.println("No expenses found.");
                } else {
                    for (Expense e: expenses){
                        System.out.println(
                        e.getId()+ " | " +
                        e.getAmount()+ " | "+
                        e.getCategory() + " | " +
                        e.getDate()+ " | " + 
                        e.getNote()
                        );
                    }
                }
            } else if (choice == 3){
                System.out.println("Enter ID to delet: ");
                int id = scanner.nextInt();
                service.deleteExpense(id);
                System.out.println("Deleted (if ID existed).");
                
            } else if (choice == 4){
                double total = service.getTotalExpenses();
                System.out.println("Total Expenses: "+total);
            }else if(choice == 5){
                Map<String,Double> summary = service.getTotalByCategory();
                if(summary.isEmpty()){
                    System.out.println("No Data available.");
                    
                }else{
                    for(String category: summary.keySet()){
                        System.out.println(category + ": "+summary.get(category));
                    }
                }
            } else if (choice == 6){
                System.out.println("Goodbye");
                break;
            }else{
                System.out.println("Invalid choice.");
            }
        }
        scanner.close();
    }
}
