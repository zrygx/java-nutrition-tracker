package main;

public class User {
    //Encapsulation
    private String userName;
    private String password;
    private int calorieGoal;

    public User(String userName, String password, int calorieGoal){
        this.userName = userName;
        this.password = password;
        this.calorieGoal = calorieGoal;
    }

    //Getters
    public String getUsername() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public int getCalorieGoal() {
        return calorieGoal;
    }
    
    public boolean authenticate(String inputUsername, String inputPassword){
        return inputUsername.equals(userName) && inputPassword.equals(password);
    }

}
