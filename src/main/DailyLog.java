package main;

import java.util.ArrayList;
public class DailyLog {
    private String date;
    private ArrayList<Food> consumption; //connects this class to create arraylist of food
    
    //constructor
    public DailyLog(String date){
        this.date = date;
        this.consumption = new ArrayList<>(); //initialize as an arraylist
    }
    
    //initialize food, we will call this to add food in the main menu into daily log 
    public void addFood(Food food){
        consumption.add(food);
    }
    
    //Displays details of the daily logs with food details 
    public void printLog(){
        System.out.println("\n--- Log for " + date + " ---");
        
        if(consumption.isEmpty()){
            System.out.println("No food logged for this day yet.");
        return; //Exit
        }
        
        int totalCalories = 0;
        int totalProtein = 0;
        int totalCarbs = 0;
        int totalFat = 0;
        
        //advance for loop to scan each food that is added on that date 
        for(Food food:consumption){
            System.out.println("- " + food.toString()); // Prints the formatted food string in food class
        
        // Add up the totals
        totalCalories += food.getCalories();
        totalProtein += food.getProtein();
        totalCarbs += food.getCarbs();
        totalFat += food.getFat();
        }
        
        System.out.println("---------------------------------");
        System.out.println("TOTAL: " + totalCalories + " kcal | P: " + totalProtein + "g, C: " + totalCarbs + "g, F: " + totalFat + "g");
        System.out.println("---------------------------------");
    }
    
    public String getDate(){
        return date;
    }
    
    //getter for comsumption, to read the contents of the food
    public ArrayList<Food> getConsumption() {
        return consumption;
    }
    
    public int getTotalCalories() {
      int total = 0;
        for (Food food : consumption) {
            total += food.getCalories();
        }
     return total;
    }
}
