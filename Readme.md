<h1 align="center">🛫 Yatra Fare Finder Automation</h1>
<p align="center">
  <b>Automate fare selection using Selenium WebDriver & Java</b><br>
  🔍 Find the lowest fares on <a href="https://www.yatra.com" target="_blank">Yatra.com</a> based on travel date
</p>

---

## 📖 Project Overview

Welcome to the **Yatra Calendar Fare Finder** — an automation script designed to identify the **lowest fare travel dates** from Delhi to Mumbai using **Selenium WebDriver in Java**.

> Developed by [www.techwithjatin.com](https://www.techwithjatin.com)

---

## 🎯 Objective

Automate the following tasks on [Yatra.com](https://www.yatra.com):

✅ Launch Yatra website  
✅ Open the **departure date** calendar (default route: Delhi → Mumbai)  
✅ Identify the **lowest fare**:
- 📅 In the **current month**
- 📅 In the **next month**
- 📅 Across **both months**

---

```
+------------------------+---------------------------------------------------+
| Technology             | Purpose                                           |
+------------------------+---------------------------------------------------+
| Java                   | Core programming language                         |
| Selenium WebDriver     | Automates web browser interaction                 |
| ChromeDriver           | Controls Google Chrome via WebDriver              |
| Maven                  | Build tool & dependency management                |
| WebDriverWait          | Explicit wait handling for elements/popups        |
| XPath                  | Locate calendar and fare elements precisely       |
+------------------------+---------------------------------------------------+
```
---

## 📋 Features

✨ Dynamic interaction with calendar widget  
✨ Fare scraping and comparison logic  
✨ Handles modals, loaders, and overlays  
✨ Console output with best fare dates  
✨ Clean and modular code structure  

---

## 🚀 Getting Started

### 🔧 Prerequisites

- Java JDK 8+
- Maven
- Chrome browser


### 📥 Clone the Repo

bash
git clone https://github.com/your-username/yatra-calendar-automation.git
cd yatra-calendar-automation

---


## sample Output
🔎 Scanning fares from Delhi to Mumbai...

✅ Lowest fare in current month: ₹3,245 on 22nd July
✅ Lowest fare in next month: ₹3,095 on 10th August
🏆 Lowest fare overall: ₹3,095 on 10th August

