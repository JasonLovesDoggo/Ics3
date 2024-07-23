// Author: Jason Cameron
// Date: 2024-07-22
// Description: This program provides a menu-driven interface for various algorithms including factorial calculation, prime number checking, and Fibonacci number generation.s

import java.util.Scanner;

public class AlgorithmDesign {

    /**
     * Fetches an integer input from the user.
     *
     * @param scanner The scanner object to read input.
     * @param prompt The prompt message to display.
     * @return The integer the user entered.
     */
    public static int getIntInput(Scanner scanner, String prompt) {
        String input = scanner.nextLine(); // Read the entire line
        try {
            return Integer.parseInt(input); // Attempt to convert the input to an integer
        } catch (NumberFormatException e) { // If what the user entered is not an integer
            System.out.println("Invalid input. Please enter a valid integer."); // Ask the user to enter a valid integer
            return getIntInput(scanner, prompt); // Try again
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            // Display the menu
            System.out.println("Choose an option:");
            System.out.println("1. Calculate Factorial");
            System.out.println("2. Check Prime");
            System.out.println("3. Find Fibonacci");
            System.out.println("4. Exit");

            int choice = getIntInput(scanner, "Enter your choice: ");

            switch (choice) {
                case 1:
                    // Factorial
                    System.out.print("Enter a number to find its factorial: ");
                    int potentialFactorial = getIntInput(scanner, "Enter a number: ");
                    System.out.println("Factorial of " + potentialFactorial + " is " + factorial(potentialFactorial));
                    break;

                case 2:
                    // Prime Check
                    System.out.print("Enter a number to check if it is prime: ");
                    int potentialPrime = getIntInput(scanner, "Enter a number: ");
                    if (isPrime(potentialPrime)) {
                        System.out.println(potentialPrime + " is a prime number.");
                    } else {
                        System.out.println(potentialPrime + " is not a prime number.");
                    }
                    break;

                case 3:
                    // Fibonacci
                    System.out.print("Enter the position to find the Fibonacci number: ");
                    int fibPosition = getIntInput(scanner, "Enter a position: ");
                    System.out.println("Fibonacci number at position " + fibPosition + " is " + fibonacci(fibPosition));
                    break;

                case 4:
                    // Exit
                    exit = true;
                    break;

                default:
                    System.out.println("Invalid choice. Please select again.");
                    break;
            }
        }
        scanner.close();
    }

    /**
     * Calculates the factorial of a number.
     *
     * @param potentialFactorial The number.
     * @return The factorial of the number.
     */
    public static long factorial(int potentialFactorial) {
        if (potentialFactorial < 0) {
            throw new IllegalArgumentException("Number must be non-negative.");
        }
        long result = 1;
        for (int i = 1; i <= potentialFactorial; i++) {
            result *= i;
        }
        return result;
    }

    /**
     * Checks if a number is prime.
     *
     * @param potentialPrime The number.
     * @return True if the number is prime, false otherwise.
     */
    public static boolean isPrime(int potentialPrime) {
        if (potentialPrime <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(potentialPrime); i++) {
            if (potentialPrime % i == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * Finds the Fibonacci number at a specific position.
     * Note: This implementation uses a long instead of {@link java.math.BigInteger} as we have not learned it
     * @param position The position.
     * @return The Fibonacci number at the position.
     */
    public static long fibonacci(int position) {
        if (position < 0) {
            throw new IllegalArgumentException("Position must be non-negative.");
        }
        if (position == 0) {
            return 0;
        }
        if (position == 1) {
            return 1;
        }
        long a = 0, b = 1, c;
        for (int i = 2; i <= position; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return b;
    }
}
