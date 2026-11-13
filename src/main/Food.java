package main;
public class Food {
    //private for encapsulation
    private String foodName;
    private int calories;
    private int protein;
    private int carbs;
    private int fat;
    
    //Constructor for all attributes
    public Food(String foodName, int calories, int protein, int carbs, int fat){
        this.foodName = foodName;
        this.calories = calories;
        this.protein = protein;
        this.carbs = carbs;
        this.fat = fat;
    }
    
    //Setters and validation
    public void setFoodName(String foodName){
        this.foodName = foodName;
    }   
    
    public void setProtein(int protein) {
        if (protein >= 0){
            this.protein = protein;
        }
        else {
            System.out.println("Error: protein must be postive intergers only!");
        }
    }

    public void setCarbs(int carbs) {
        if (carbs >= 0){
            this.carbs = carbs;
        }
        else {
            System.out.println("Error: carbs must be postive intergers only!");
        }
    }

    public void setFat(int fat) {
        if (fat >= 0){
            this.fat = fat;
        }
        else {
            System.out.println("Error: fat must be postive intergers only!");
        }
    }
    
    public void setCalories(int calories){
        if (calories >= 0){
            this.calories = calories;
        }
        else {
            System.out.println("Error: calories must be postive intergers only!");
        }
    }
    
    
    //Getts
    public String getFoodName(){
        return foodName;
    }  
    
    public int getCalories(){
        return calories;
    }
    
    public int getProtein(){
        return protein;
    }
    
    public int getCarbs(){
        return carbs;
    }
    
    public int getFat(){
        return fat;
    } 
    
    //override toString of java to make our own toString method
    @Override
    public String toString() {
        return foodName + " - " + calories + " kcal | P: " + protein + "g, C: " + carbs + "g, F: " + fat + "g";
    }   
}
