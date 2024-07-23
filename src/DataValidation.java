// Name: Jason Cameron
// Date: 2024-07-20
// Purpose of program: To create a data validation program that prompts the user for various types of input and validates the input based on specific criteria.

import java.util.Scanner;

public class DataValidation {

    // Stage 1: Validates a string input from the user.
    // The input must be longer than 6 characters to be considered valid.
    public static boolean stage1() {
        Scanner scanner = new Scanner(System.in);
        while (true) { // Continue prompting the user until valid input is provided.
            System.out.print("Enter a string longer than 6 characters: ");
            String input = scanner.nextLine(); // Read the user's input.
            if (input.length() > 6) { // Check if the input length meets the criteria.
                return true; // Return true to indicate successful validation.
            } else {
                System.out.println("Invalid input. Try again."); // Display an error message.
            }
        }
    }

    // Stage 2: Validates a string input from the user.
    // The input must contain at least one lowercase 'a' character to be considered valid.
    public static boolean stage2() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Enter a string containing at least one lowercase 'a': ");
            String input = scanner.nextLine();
            if (input.toLowerCase().contains("a")) { // Convert to lowercase and check for 'a'.
                return true;
            } else {
                System.out.println("Invalid input. Try again.");
            }
        }
    }

    // Stage 3: Validates a string input from the user.
    // The input must be between 5 and 15 characters long and cannot contain the letter 'z' to be considered valid.
    public static boolean stage3() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Enter a string between 5 and 15 characters long (no 'z'): ");
            String input = scanner.nextLine();
            if (input.length() >= 5 && input.length() <= 15 && !input.contains("z")) { // Check length and absence of 'z'.
                return true;
            } else {
                System.out.println("Invalid input. Try again.");
            }
        }
    }

    // Stage 4: Validates an integer input from the user.
    // The input must be a number between 5 and 500 (inclusive) to be considered valid.
    public static boolean stage4() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Enter an integer between 5 and 500: ");
            try { // Attempt to read an integer from the input.
                int num = scanner.nextInt();
                if (num >= 5 && num <= 500) { // Check if the integer is within the valid range.
                    return true;
                } else {
                    System.out.println("Invalid input. Try again.");
                }
            } catch (java.util.InputMismatchException e) { // Handle the case where the input is not an integer.
                System.out.println("Invalid input. Please enter an integer.");
                scanner.nextLine(); // Clear the invalid input from the buffer.
            }
        }
    }

    // Stage 5: Validates an integer input from the user.
    // The input must be a negative number to be considered valid.
    public static boolean stage5() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Enter a negative integer: ");
            try {
                int num = scanner.nextInt();
                if (num < 0) {
                    return true;
                } else {
                    System.out.println("Invalid input. Try again.");
                }
            } catch (java.util.InputMismatchException e) {
                System.out.println("Invalid input. Please enter an integer.");
                scanner.nextLine();
            }
        }
    }

    // Stage 6: Validates an integer input from the user.
    // The input must be a positive and odd number to be considered valid.
    public static boolean stage6() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Enter a positive, odd integer: ");
            try {
                int num = scanner.nextInt();
                if (num > 0 && num % 2 != 0) { // Check if the integer is positive and odd.
                    return true;
                } else {
                    System.out.println("Invalid input. Try again.");
                }
            } catch (java.util.InputMismatchException e) {
                System.out.println("Invalid input. Please enter an integer.");
                scanner.nextLine();
            }
        }
    }

    // Main function that runs the data validation process
    public static void main(String[] args) {
        boolean stage1Success = false, stage2Success = false, stage3Success = false,
                stage4Success = false, stage5Success = false, stage6Success = false;

        while (!(stage1Success && stage2Success && stage3Success && stage4Success && stage5Success && stage6Success)) {
            if (!stage1Success) stage1Success = stage1(); // Attempt stage 1 if not already passed
            if (!stage2Success) stage2Success = stage2(); // Attempt stage 2 if not already passed
            if (!stage3Success) stage3Success = stage3(); // Attempt stage 3 if not already passed
            if (!stage4Success) stage4Success = stage4(); // Attempt stage 4 if not already passed
            if (!stage5Success) stage5Success = stage5(); // Attempt stage 5 if not already passed
            if (!stage6Success) stage6Success = stage6(); // Attempt stage 6 if not already passed
        }

        System.out.println("Congratulations! You have successfully completed all stages.");
    }
}
