# OrangeHRM Automation – Selenium with Java

This repository contains an automated test project for an HR management web application. The automation covers core workflows like login, employee management, and logout using Selenium WebDriver and Java.

---

## 🔍 Project Overview

The goal of this project is to validate key HR functionalities such as user authentication, adding employees, and verifying employee data. The tests simulate real user behavior and check if the system responds correctly.

---

## ✅ What This Project Tests

- **Login Page** – Validates login with correct credentials.
- **Add Employee Page** – Adds a new employee with first name, last name, and ID.
- **Employee List Page** – Searches and verifies added employee records.
- **Logout** – Ensures the logout process works as expected.

---

## ⚙️ Tech Stack Used

- **Language:** Java
- **Automation Tool:** Selenium WebDriver
- **Test Framework:** JUnit
- **Driver Management:** WebDriverManager (auto-handles ChromeDriver)
- **Browser Tested:** Google Chrome

---

## 🚀 How to Run

### ✅ Prerequisites

- JDK 17+
- Maven installed
- Google Chrome browser
- IntelliJ IDEA or any Java IDE

### 🔧 Running the Tests

From terminal (if Maven configured):
```bash
mvn test

Or, directly from your IDE

Open any test class (e.g., AddEmployeeTest.java).
Right-click on the class or a test method.
Select Run from the context menu.
