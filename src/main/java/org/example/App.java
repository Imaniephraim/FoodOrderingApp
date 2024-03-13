package org.example;

import java.util.ArrayList;
import java.util.List;

public class App {
    private List<User> users;
    private User currentUser;
    private List<Food> menu;

    //constructor
    public App(){
        users = new ArrayList<>();
        //add some sample users
        users.add(new User("Dominic", "password"));
        users.add(new User("Joanoah", "password"));

        menu = new ArrayList<>();

        //populate menu with some food items
        menu.add(new Food("Fish", 599.99));
        menu.add(new Food("Fries", 299.99));
        menu.add(new Food("Burger", 699.99));
        menu.add(new Food("Sushi", 1245.99));
        menu.add(new Food("kackac", 399.99));
    }

    public void login(String username, String password){
        for (User user : users) {
            if (user.getUsername().equals(username)){
                currentUser = user;
                currentUser.login(password);
                return;
            }
        }
        System.out.println("User not found. Login Failed!");
    }

    public void logout(){
        if (currentUser != null && currentUser.isLoggedIn()){
            currentUser.logout();
            currentUser = null;
        }else{
            System.out.println("No user is currently logged in.");
        }
    }

    //a method to display menu item
    public void displayMenu(){
        System.out.println("Menu");
        for(int i = 0; i < menu.size(); i++){
            Food food = menu.get(i);
            System.out.println((i+1) + ". " + food.getName() + "- Ksh" + food.getPrice());
        }
    }

    //a method to add food to the cart
    public void addToCart(int itemIndex){
        if (currentUser != null && currentUser.isLoggedIn()){
            if (itemIndex >= 0 && itemIndex < menu.size()){
                Food selectedFood = menu.get(itemIndex);
                currentUser.addToCart(selectedFood);
            }else{
                System.out.println("Invalid Menu Item Index!");
            }
        }else{
            System.out.println("Please login first in order to add food to cart");
        }
    }
    //a method to remove food from cart
    public void removeFromCart(int itemIndex){
        if (currentUser != null && currentUser.isLoggedIn()){
          if (itemIndex >= 0 && itemIndex < menu.size());
          Food selectedFood = menu.get(itemIndex);
          currentUser.removeFoodFromCart(selectedFood);
        }else{
            System.out.println("Please login first to remove food from cart");
        }
    }

    //a method to view the cart item
    public void viewCart(){
        if (currentUser != null && currentUser.isLoggedIn()){
            currentUser.viewCart();
        }else {
            System.out.println("Please login first!");
        }
    }
    //a method to checkout
    public void checkout(){
        if(currentUser != null && currentUser.isLoggedIn()){
            double totalCost = currentUser.calculateTotalCost();
            System.out.println("Total Cost: " + totalCost);
            //perform check out processes e.g payment
            currentUser.getCart().clear(); // clear the cart after payment/checkout
            System.out.println("Checkout Successful. Your order has been placed.");
        }else{
            System.out.println("Please login First");
        }
    }
}












