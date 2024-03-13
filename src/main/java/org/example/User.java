package org.example;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String username;
    private String password;
    private boolean isLoggedIn;
    private List<Food> cart;

    //constructor
    public User(String username, String password){
        this.username = username;
        this.password = password;
        this.isLoggedIn = false;
        this.cart = new ArrayList<>();
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public boolean isLoggedIn() {
        return isLoggedIn;
    }

    public List<Food> getCart() {
        return cart;
    }

    //a method to login
    public void login(String enterPassword){
        if(enterPassword.equals(password)){
            isLoggedIn = true;
            System.out.println("Login in successful. Welcome ," + username + "!");
        }else{
            System.out.println("Incorrect Password. Login failed!");
        }
    }
    //a method to logout
    public void logout(){
        isLoggedIn = false;
        //clear the cart on logout
        cart.clear();
        System.out.println("Logout successful. Goodbye, " + username + "!");
    }
    //a method to add food to the cart
    public void addToCart(Food food){
        cart.add(food);
        System.out.println(food.getName() + " added to cart.");
    }
    //a method to remove food from the cart
    public void removeFoodFromCart(Food food){
        if(cart.remove(food)){
            System.out.println(food.getName() + " removed from cart.");
        }else{
            System.out.println(food.getName() + " not found in cart.");
        }
    }

    //a method to view the cart items
    public void viewCart(){
        if(cart.isEmpty()) {
            System.out.println("Your Cart Is Empty!");
        }else{
            System.out.println("Your Cart: ");
            for(Food food : cart){
                System.out.println(food.getName() + " - Ksh" + food.getPrice());
            }
        }
    }

    //a method to calculate the total cost of the food ordered
    public double calculateTotalCost() {
        double totalCost = 0;

        for (Food food : cart) {
            totalCost += food.getPrice();
        }

        return totalCost;
    }
}
























