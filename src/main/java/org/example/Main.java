package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        App app = new App();

        int userChoice;

        do{
            System.out.println("Welcome To CPL Online Food Ordering App");
            System.out.println("\n1. Login");
            System.out.println("2. Logout");
            System.out.println("3. Display Menu");
            System.out.println("4. Add to Cart");
            System.out.println("5. Remove from cart");
            System.out.println("6. View Cart");
            System.out.println("7. Checkout");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");
            userChoice = scanner.nextInt();
            scanner.nextLine(); //consumes rhe new line character

            switch (userChoice) {
                case 1:
                    System.out.println("Enter Your Username: ");
                    String username = scanner.nextLine();

                    System.out.println("Enter your password");
                    String password = scanner.nextLine();

                    app.login(username, password);

                    break;
                case 2:
                    app.logout();
                    break;
                case 3:
                    app.displayMenu();
                    break;
                case 4:
                    System.out.println("Enter the index of the item to add to cart: ");
                    //adjust for 0- based indexing
                    int addToCartIndex = scanner.nextInt() -1;
                    app.addToCart(addToCartIndex);
                    break;
                case 5:
                    System.out.println("Enter the index of the item to remove from Cart: ");
                    int removeFromCartIndex = scanner.nextInt() -1;
                    app.removeFromCart(removeFromCartIndex);
                    break;
                case 6:
                    app.viewCart();
                    break;
                case 7:
                    app.checkout();
                    break;
                case 8:
                    System.out.println("Exiting Program...");
                    break;
                default:
                    System.out.println("Invalid Choice, Please Try Again!");
            }


        }while (userChoice!= 8);

        //close the scanner object
        scanner.close();
    }
}








