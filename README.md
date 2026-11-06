# 💰 Accounting Ledger Application

A robust command-line financial tracking and reporting application built in Java. This application allows users to record deposits, track payments/expenses, and generate detailed time-based or vendor-specific financial reports—all backed by persistent CSV storage.

---

## 🚀 Features

* **Transaction Management:** 
  * Add deposits (income) with custom descriptions, vendors, and amounts.
  * Make payments (expenses) to track money going out.
* **Ledger View:** 
  * View all transactions sorted chronologically (newest first).
  * Filter easily between "All", "Deposits Only", and "Payments Only".
* **Comprehensive Reporting Suite:**
  * **Month To Date (MTD):** View transactions made in the current month.
  * **Previous Month:** Review financial activity from the past month.
  * **Year To Date (YTD):** Track year-to-date income and expenses.
  * **Previous Year:** Analyze historical data from the previous year.
  * **Vendor Search:** Filter and look up all transactions associated with a specific vendor.
* **Persistent Storage:** Automatically reads and writes all transaction logs safely to a local `transactions.csv` file without overwriting history.

---

## 🛠️ Tech Stack & Requirements

* **Language:** Java (JDK 17 or higher recommended)
* **Build Tool:** Maven / Standard Java Compiler (`javac`)
* **Core Libraries:** `java.time.LocalDate` for precise date handling and filtering logic.

---

## 📂 Project Structure

```text
AccountingLedger/
│
├── src/main/java/com/pluralsight/
│   ├── Accounting.java       # Main entry point and user interface loop
│   ├── LoadHistory.java      # Handles loading/parsing CSV records into memory
│   ├── Reports.java          # Houses menu navigation and date/vendor filtering logic
│   └── Transaction.java      # Model class representing individual financial entries
│
├── transactions.csv          # Local database storing transaction history
└── pom.xml                   # Maven configuration file
```

---

## ⚙️ Getting Started & Installation

### 1. Clone the Repository
```bash
git clone https://github.com/your-username/AccountingLedger.git
cd AccountingLedger/AccountingLedger
```

### 2. Compile the Code
Navigate to your source directory or use your IDE (like IntelliJ IDEA or VS Code), and compile the Java files:
```bash
javac com/pluralsight/*.java
```

### 3. Run the Application
Launch the app from the root package context:
```bash
java com.pluralsight.Accounting
```

---

## 🖥️ Usage Guide

Upon launching the application, you will be greeted by the main home screen menu:

```text
=== Main Menu ===
D) Add Deposit
P) Make Payment (Debit)
L) Ledger
R) Reports
X) Exit
Choose an option:
```

* **Adding a Transaction:** Select `D` or `P`, then follow the prompts to input the description, vendor, and amount.
* **Viewing Reports:** Select `R` to open the Reports Menu, where you can filter by time periods or search for specific vendors seamlessly.

---

## 💡 Acknowledgments
Developed as part of a professional software development training curriculum to master object-oriented programming, data handling, and control flows in Java.
