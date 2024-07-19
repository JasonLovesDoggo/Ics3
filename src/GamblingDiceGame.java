// Name: Jason Cameron
// Date 2024-07-18
// Description: This program is a simple gambling dice game where the user can bet on the outcome of rolling multiple dice. The game includes various rules and payouts based on the dice rolls.
import java.util.Random;
import java.util.Scanner;

public class GamblingDiceGame {

    // Game constants
    static final int MIN_BET = 10;
    static final int MAX_DICE = 7;
    static final int MATCH_PAYOUT = 2;
    static final int EVEN_PAYOUT = 1;
    static final int ODD_PAYOUT = -1;
    static final int ONE_PAYOUT = -2;

    // Function to get the number of dice from the user
    static int getNumDice(Scanner scanner) {
        int numDice;
        do {
            System.out.print("Enter the number of dice to roll (1-7): ");
            numDice = scanner.nextInt();
            if (numDice < 1 || numDice > MAX_DICE) {
                System.out.println("Invalid number of dice. Please try again.");
            }
        } while (numDice < 1 || numDice > MAX_DICE);
        return numDice;
    }

    // Function to get the bet amount from the user
    static int getBetAmount(Scanner scanner, int balance) {
        int bet;
        do {
            System.out.printf("You have $%d. Place your bet (minimum $%d): ", balance, MIN_BET);
            bet = scanner.nextInt();
            if (bet < MIN_BET || bet > balance) {
                System.out.println("Invalid bet amount. Please try again.");
            }
        } while (bet < MIN_BET || bet > balance);
        return bet;
    }

    // Function to roll a single die
    static int rollDie(Random random) {
        return random.nextInt(6) + 1; // Random value between 1 and 6
    }

    // Function to calculate the payout for a single roll
    static int calculateSingleRollPayout(int roll, int bet) {
        if (roll == 1) {
            return ONE_PAYOUT * bet;
        } else if (roll % 2 == 0) {
            return EVEN_PAYOUT * bet;
        } else {
            return ODD_PAYOUT * bet;
        }
    }

    // Main game logic
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int balance = 100;

        System.out.println("Welcome to the Gambling Dice Game!");

        while (balance >= MIN_BET) {
            System.out.println("\nYour current balance is $" + balance);

            int numDice = getNumDice(scanner);
            int bet = getBetAmount(scanner, balance);
            int totalPayout = 0;
            int[] previousRolls = new int[numDice];

            System.out.println("\nRolling the dice...");

            for (int i = 0; i < numDice; i++) {
                int roll = rollDie(random);
                System.out.println("Rolled a " + roll);

                // Calculate initial payout for the roll
                int payout = calculateSingleRollPayout(roll, bet);
                totalPayout += payout;

                // Check for matches and adjust payout
                for (int j = 0; j < i; j++) {
                    if (roll == previousRolls[j]) {
                        payout *= MATCH_PAYOUT;
                        payout = Math.max(payout, 0); // Payout cannot be negative after a match
                        if (payout == 0) {
                            System.out.println("Match found, but you were already at $0 payout. No change.");
                        } else {
                            System.out.println("Match found! Payout multiplied by " + MATCH_PAYOUT + ".");
                        }
                        totalPayout += payout; // Add the doubled amount to the total payout
                    }
                }

                // Store the roll for future match checks
                previousRolls[i] = roll;

                // Update balance and display
                balance += payout;
                System.out.println("Current payout: $" + payout + ", Balance: $" + balance);

                // Check if the player can continue
                if (balance < MIN_BET) {
                    System.out.println("You've run out of money! Game over.");
                    break;
                }
            }

            // Ask if the player wants to play again, only if the loop wasn't broken early
            if (balance >= MIN_BET) {
                System.out.print("Play again? (yes/no): ");
                if (!scanner.next().equalsIgnoreCase("yes")) {
                    break;
                }
            }
        }

        System.out.println("\nThanks for playing! Your final balance is $" + balance);
    }
}
