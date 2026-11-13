# Nutrition & Supplement Tracker 🥗

A comprehensive command-line Java application designed to track daily food intake, macronutrients, and calorie goals.

## Features
- **User Registration & Login:** Create a local account and set a daily calorie goal. Includes a 3-attempt login lockout.
- **Create Daily Logs:** Log multiple foods per day, including calories, protein, carbs, and fat.
- **View & Analyze:** View any day's food log, complete with automatically calculated macro totals. Compares your total intake against your daily calorie goal.
- **Update Entries:** Edit the nutritional values of a specific food item in a past log.
- **Delete Entries:** Remove specific food items from a log.

## Concepts Used
- **Object-Oriented Programming (OOP):** Separation of concerns across `Food`, `DailyLog`, `User`, and `NutritionTracker` classes.
- **Encapsulation:** Data is secured in private fields with public getters/setters and validation (preventing negative calories).
- **Data Structures:** Nested `ArrayLists` to manage a history of daily logs, each containing a list of food objects.
- **Input Handling:** Safe `Scanner` reading with buffer clearing to prevent input skipping.
- **CRUD Operations:** Full Create, Read, Update, and Delete functionality.

## How to Run
1. Clone this repository.
2. Open the project in NetBeans (or your preferred Java IDE).
3. Run the `NutritionTracker.java` file.