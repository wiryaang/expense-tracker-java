# 📊 Expense Tracker (Java + Swing + SQLite)

A simple desktop application built with Java Swing to track personal expenses.  
This project demonstrates GUI design, data handling, and database integration.

---

## 🚀 Features

- Add new expenses (amount, category, date, note)
- View all expenses in a table
- Delete selected expenses
- Filter expenses by category
- Sort expenses by amount
- Persistent storage using SQLite (data is saved after closing the app)

---

## 🛠️ Technologies Used

- Java (JDK 17)
- Java Swing (GUI)
- SQLite (Database)
- JDBC (Database connection)
- NetBeans IDE

---

## 📂 Project Structure

- `model` → Expense data class  
- `dao` → Database operations (ExpenseDAO)  
- `dc` → Database connection  
- `service` → Business logic (optional)  
- `ui` → User interface (MainFrame)  

---

## 🧠 How It Works

- The GUI interacts with `ExpenseDAO`
- `ExpenseDAO` handles database operations (CRUD)
- Data is stored in a local SQLite database (`expenses.db`)
- JTable updates dynamically after each action

---

## ▶️ How to Run

1. Clone the repository:
   ```
   git clone https://github.com/wiryaang/expense-tracker-java.git
   ```

2. Open the project in NetBeans (or any Java IDE)

3. Make sure SQLite JDBC is added to Libraries

4. Run `MainFrame.java`

---

## 📌 Current Status

✅ Add / View / Delete expenses  
✅ Database integration (SQLite)  
✅ GUI fully functional  

🚧 Planned Features:
- Monthly expense summary
- Category breakdown
- Total spending display
- UI improvements

---

## 📸 Preview

*(Add screenshots here later)*

---

## 💡 Future Improvements

- Charts (expense visualization)
- Export data to CSV
- Filter by date range
- Better UI/UX

---

## 👤 Author

Wirya Angana  
https://github.com/wiryaang
