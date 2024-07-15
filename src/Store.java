import java.util.HashMap;
import java.util.Scanner;

public class Main {

    // Scanner to get user input throughout the program
    private static final Scanner scanner = new Scanner(System.in);

    // Shopping cart using a HashMap to store item name and quantity pairs
    private static final HashMap<String, Integer> ShoppingCart = new HashMap<>();

    // Store inventory using a HashMap to store item name and price pairs
    private static final HashMap<String, Float> StoreItems = new HashMap<>();

    public static void main(String[] args) {

        // Initialize the store inventory with a few items and their prices
        StoreItems.put("Apple", 1.00F);
        StoreItems.put("Banana", 0.50F);
        StoreItems.put("Orange", 1.50F);
        StoreItems.put("Grapes", 2.00F);
        StoreItems.put("Pineapple", 3.00F);
        StoreItems.put("Watermelon", 4.00F);
        StoreItems.put("Strawberry", 1.30F);

        // Welcome the customer and display the available items in a numbered list
        System.out.println("Welcome to Jason's store");
        System.out.println("Here are the items we have in stock:");

        int index = 0;
        for (String item : StoreItems.keySet()) {
            System.out.println(index + ": " + item + " - $" + StoreItems.get(item));
            index++;
        }

        // Initiate the purchase process
        purchaseItem();

        // Display the contents of the shopping cart, including item names, quantities, and individual prices
        System.out.println("Here is your cart:");
        double total = 0;
        for (String item : ShoppingCart.keySet()) {
            System.out.println(item + " - " + ShoppingCart.get(item) + " - at " + StoreItems.get(item) + "$ each");

            // Calculate the running total cost of the items
            total += ShoppingCart.get(item) * StoreItems.get(item);
        }

        // Calculate and display the tax (13%) rounded to 2 decimal places
        double taxes = (Math.round(total * 0.13 * 100.0) / 100.0);

        // Round the total cost to 2 decimal places
        total = Math.round(total * 100.0) / 100.0;
        System.out.println("Subtotal: $" + total);
        System.out.println("Tax (13%): $" + taxes);
        System.out.println("Total: $" + (total + taxes));

        // Thank the customer for their purchase
        System.out.println("Thank you for shopping at Jason's store");

        // Close the scanner to release system resources
        scanner.close();
    }

    // Function to guide the user through purchasing a single item
    public static void purchaseItem() {

        // Prompt the user to enter the item number they want to buy
        System.out.print("Please enter the item number you would like to purchase: ");
        int itemIndex = scanner.nextInt();

        // Retrieve the item name corresponding to the entered number
        String ItemName = StoreItems.keySet().toArray()[itemIndex].toString();

        // Prompt the user to enter the quantity of the item
        System.out.print("Please enter the quantity you would like to purchase: ");
        int ItemQuantity = scanner.nextInt();

        // Update the shopping cart by adding the item or increasing its quantity if it's already there
        if (ShoppingCart.containsKey(ItemName)) {
            ShoppingCart.put(ItemName, ShoppingCart.get(ItemName) + ItemQuantity);
        } else {
            ShoppingCart.put(ItemName, ItemQuantity);
        }
        System.out.println("You have added " + ItemQuantity + " " + ItemName + " to your cart.");

        // Ask if the user wants to buy anything else
        System.out.println("Would you like to purchase anything else? (Y/N)");
        String response = scanner.next();

        // Recursively call the function if the user wants to continue shopping
        if (response.equalsIgnoreCase("Y")) {
            purchaseItem();
        }
    }
}
