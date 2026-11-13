package main;
import java.util.*;

public class NutritionTracker {
    
    //global variables so we dont need to pass them everytime, static variable because main class is static, else it will not be considered main class
    static Scanner cin = new Scanner(System.in);
    static ArrayList<DailyLog> history = new ArrayList<>(); //initializing arraylist of class called daily log and calling it history
    static boolean running = false; //set to false, authenticate first before menu shows up
    
    public static void main(String[] args) {
        System.out.println("-------------Welcome to Nutrition Tracker App!!------------");
        
        System.out.print("Create Username: ");
        String username = cin.nextLine();
        
        System.out.print("Create Password: ");
        String password = cin.nextLine();
        
        System.out.print("Calorie Goal: ");
        int caloriegoal = cin.nextInt();
        cin.nextLine(); //buffer
        
        User currentUser = new User(username, password,caloriegoal);
        boolean loggedIn = false;

        // 3 tries to log in
        for (int attempts = 1; attempts <= 3; attempts++) {
            System.out.print("Enter username: ");
            String u = cin.nextLine();

            System.out.print("Enter password: ");
            String p = cin.nextLine();

            //Check authentication
            if (currentUser.authenticate(u, p)) {
                System.out.println("Login successful! Welcome, " + currentUser.getUsername());
                loggedIn = true;
                break; // Exit the loop because they are in
            } else {
                System.out.println("Invalid credentials. Attempts left: " + (3 - attempts));
            }
        }

        //Only show the menu if they logged in successfully
        if (loggedIn) {
            running = true; // Turn the menu loop on
            menu(currentUser); 
        } else {
            System.out.println("Too many failed attempts. Account locked.");
        }
    }
    
    public static void menu(User currentUser){
        String[] menu = {"1. Create a New Daily Log", "2. View Daily Log", "3. Update Food Entry", "4. Delete Food Entry", "5. Quit"};
        int choice;
        while(running){
            System.out.println("\n------------ NUTRITION TRACKER ------------------");
            for (String menus: menu){
                System.out.println(menus);
            }
            System.out.print("Enter your choice: ");
            choice = cin.nextInt();
            cin.nextLine(); //scanner buffer for the insivisible enter bug
            
            switch (choice){
                case 1 -> {
                    createLog();
                }
                case 2 -> {
                    viewLog(currentUser);
                }
                case 3 -> {
                    updateEntry();
                }
                case 4 -> {
                    deleteEntry();
                }
                case 5 -> {
                    running = false;
                    System.out.println("Goodbye!");
                }
                default -> System.out.println("Invalid choice.");
            }
        }
    }
    
    public static void createLog(){
        System.out.println("\n------------Create a daily log---------------");
        System.out.print("Enter date: ");
        String date = cin.nextLine();
        boolean addingFood = true;
        
        DailyLog newLog = new DailyLog(date); //creates object of class called dailylog
        history.add(newLog); //then adding this into the array list called history
       
        //lets us add mulitple food in a single log         
        while (addingFood) {
            System.out.print("\nEnter food name (type done to exit): ");
            String name = cin.nextLine();    
            
            if (name.equalsIgnoreCase("done")){
                addingFood = false; //exits loop
                break;
            }
            
            //inputing number of grams and kcal with buffers
            System.out.print("Enter calories(kcal): ");
            int cals = cin.nextInt();
            cin.nextLine();

            System.out.print("Enter protein(g): ");
            int protein = cin.nextInt();
            cin.nextLine();

            System.out.print("Enter carbs(g): ");
            int carbs = cin.nextInt();
            cin.nextLine();

            System.out.print("Enter fat(g): ");
            int fat = cin.nextInt();
            cin.nextLine();

            Food food = new Food(name, cals, protein, carbs, fat);
            newLog.addFood(food); //calling addFood method in our daily log class
        }
        
        System.out.println("Food added successfully to " + date + "!");
    }
    
    public static void viewLog(User currentUser){
        System.out.println("\n-------------VIEW LOG-----------------");
        System.out.print("Enter date: ");
        String searchDate = cin.nextLine();
        boolean found = false;
        
        for (DailyLog log: history){
            //searches every date on the records with the getter
            if (log.getDate().equals(searchDate)){
                log.printLog();
               
                int userGoal = currentUser.getCalorieGoal();
                int totalCalorie = log.getTotalCalories();
                int remaining = userGoal - totalCalorie;
                int over = totalCalorie - userGoal;

                if (totalCalorie > userGoal) {
                    System.out.println("Warning: You went over your goal by " + over + " calories.");
                } else {
                    System.out.println("Great job! You have " + remaining + " calories remaining today.");
                }
                
                System.out.println("\n[Goal Tracker] " + currentUser.getUsername() + ", your daily goal is: " + currentUser.getCalorieGoal() + " kcal.");
                
                
                found = true;
                break; //stop searching
            }
        }
        
        if(!found){
            System.out.println("No log recorded on that date.");
        }
    }
    
    public static void updateEntry(){
        System.out.println("\n--------------- UPDATE AN ENTRY ----------------");
        System.out.print("Enter the date you want to edit: ");
        String searchDate = cin.nextLine();
        boolean found = false;
        boolean findFood = false;
        
        for (DailyLog log: history){
            //searches every date on the records with the getter
            if (log.getDate().equals(searchDate)){
                log.printLog();
                found = true;
                
                System.out.print("\nEnter the name of food: ");
                String food = cin.nextLine();
                
                for (Food foods : log.getConsumption()){
                    if(foods.getFoodName().equalsIgnoreCase(food)){
                        findFood = true;
                        System.out.print("Enter new calories: ");
                        int calories  = cin.nextInt();
                        cin.nextLine();
                        
                        System.out.print("Enter new protein: ");
                        int protein = cin.nextInt();
                        cin.nextLine();
                        
                        System.out.print("Enter new carbs: ");
                        int carbs = cin.nextInt();
                        cin.nextLine();
                        
                        System.out.print("Enter new fats: ");
                        int fat = cin.nextInt();
                        cin.nextLine();
                    
                        //using setters to update food details 
                        foods.setCalories(calories);
                        foods.setProtein(protein);
                        foods.setCarbs(carbs);
                        foods.setFat(fat);
                        
                        System.out.println("Food have been updated.");
                        break; //stop searching for food
                        
                    }
                       
                }
                if(!findFood){
                    System.out.println("Food cannot be find.");
                }
                break; //stop searching for date
            }
        }
        
        
        
        if(!found){
            System.out.println("No log recorded on that date.");
        }
    }
    
    public static void deleteEntry(){
          System.out.println("\n--------------- DELETE AN ENTRY ----------------");
        System.out.print("Enter the date you want to edit: ");
        String searchDate = cin.nextLine();
        boolean found = false;
        boolean findFood = false;
        
        for (DailyLog log: history){
            //searches every date on the records with the getter
            if (log.getDate().equals(searchDate)){
                found = true;
                log.printLog();
                
                System.out.print("\nEnter the name of food: ");
                String food = cin.nextLine();
                
                for (Food foods : log.getConsumption()){
                    if(foods.getFoodName().equalsIgnoreCase(food)){
                        findFood = true;
                        
                        //scans log and then deletes the food that is inserted
                        log.getConsumption().remove(foods);
                        
                        System.out.println("Food entry have been deleted.");
                        break; //stop searching for food
                        
                    }
                       
                }
                if(!findFood){
                    System.out.println("Food cannot be find.");
                }
                break; //stop searching for date
            }
        }
        
        
        
        if(!found){
            System.out.println("No log recorded on that date.");
        }
    }
}