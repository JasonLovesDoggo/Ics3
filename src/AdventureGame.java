import java.util.Scanner;
import java.util.Random;

public class AdventureGame {
    static Scanner stdin = new Scanner(System.in); // Scanner to get user input throughout the program
    static String userName; // Variable to store the user's name
    static Random random = new Random(); // Instance of random so we can use it for dynamic outcomes

    public static void main(String[] args) {
        System.out.print("Enter your name: ");
        userName = stdin.nextLine(); // Get user's name

        System.out.println("Welcome to the Adventure Game, " + userName + "!"); // Welcome message - Incorporating user's name for a personalized experience
        System.out.println("You awaken in a dense forest, unsure of how you arrived. The air is thick with mystery, and the only sound is the rustling of leaves.");

        // Level 1: Forest
        System.out.println(userName + ", do you follow a faint path (yes/no)?");
        if (checkResponse()) { // Follow path
            // Level 2: Path
            System.out.println("The path splits, " + userName + ". A narrow trail winds to the left, while a wider one beckons to the right. Do you go left (yes/no)?");
            if (checkResponse()) { // Left trail
                // Level 3: Left Trail
                System.out.println("The left trail leads you, " + userName + ", to a hidden clearing. Sunlight filters through the trees, illuminating a mysterious well.");
                System.out.println("Do you investigate the well (yes/no)?");
                if (checkResponse()) { // Investigate well
                    // Level 4: Well
                    System.out.println("As you approach the well, " + userName + ", a ghostly figure emerges from the depths!");
                    System.out.println("Do you run (yes/no)?");
                    if (checkResponse()) { // Run
                        System.out.println("You flee in terror, " + userName + ", but the forest seems to grow darker and more menacing.");
                        System.out.println("You stumble upon a hidden village, where the villagers mistake you for a prophesied hero. They offer you shelter and guidance.");
                        System.out.println("You spend your days training with the village warriors, learning their ancient fighting techniques.");
                        System.out.println("Years later, you lead the villagers in a battle against a neighboring tribe, emerging victorious.");
                        System.out.println("You become a legend, " + userName + ", your name whispered in tales for generations to come.");
                        System.exit(0); // End the game
                    } else { // Don't run
                        System.out.println("You stand your ground, " + userName + ", and the figure reveals itself to be a friendly spirit.");
                        System.out.println("The spirit thanks you for your bravery and offers you a magical amulet.");
                        System.out.println("The amulet grants you protection and guides you through the forest, leading you to a hidden path out.");
                        System.out.println("You emerge from the forest, forever changed by your encounter with the spirit.");
                        System.exit(0); // End the game
                    }
                } else { // Don't investigate well
                    System.out.println("You leave the clearing, " + userName + ", but a strange feeling lingers in the air. You continue down the path, the forest growing denser around you.");
                    System.out.println("Suddenly, you are surrounded by a pack of wolves! Do you fight (yes/no)?");
                    if (checkResponse()) { // Fight
                        System.out.println("You draw your weapon, " + userName + ", and prepare for a desperate battle against the wolves.");
                        if (random.nextBoolean()) { // Random outcome of the fight
                            System.out.println("With courage and skill, you manage to fend off the wolves. They retreat, leaving you battered but victorious.");
                            System.out.println("You continue on the path, finding a hidden clearing with a tranquil lake. You rest and recover, gaining strength for the journey ahead.");
                            System.out.println("Refreshed and determined, you continue your journey, eventually finding your way out of the forest and back to civilization.");
                            System.exit(0); // End the game
                        } else {
                            System.out.println("The wolves overwhelm you, " + userName + ". You fight bravely, but your wounds are too severe...");
                            System.out.println("Your journey ends here, in the heart of the dark forest.");
                            System.exit(0); // Game Over
                        }
                    } else { // Don't fight
                        System.out.println("You slowly back away, " + userName + ", hoping to avoid provoking the wolves.");
                        if (random.nextBoolean()) { // Random chance of escape
                            System.out.println("The wolves, sensing your fear, let you pass. You quickly flee the area.");
                            System.out.println("You eventually find your way out of the forest, vowing never to return.");
                            System.exit(0); // End the game
                        } else {
                            System.out.println("The wolves attack! You try to run, but they quickly catch up and...well, let's just say the forest is now a little quieter.");
                            System.exit(0); // Game Over
                        }
                    }
                }
            } else { // Right trail
                // Level 3: Right Trail
                System.out.println("The right trail leads you, " + userName + ", to the edge of a rushing river.");
                System.out.println("Do you try to cross (yes/no)?");
                if (checkResponse()) { // Cross river
                    System.out.println("You assess your options, " + userName + ". Do you try to:");
                    System.out.println("1. Swim across");
                    System.out.println("2. Search for a ford (shallow crossing)");
                    System.out.println("3. Build a raft");

                    // Get user choice for crossing the river
                    int choice = stdin.nextInt();
                    stdin.nextLine(); // Consume newline character
                    switch (choice) {
                        case 1: // Swim
                            System.out.println("You bravely plunge into the river, " + userName + ", but the current is too strong. You are swept away...");
                            System.out.println("Miles downstream, you wash ashore, bruised but alive. You continue your journey, forever changed by your near-death experience.");
                            System.out.println("You wander for days until you stumble upon a hidden city, where you are welcomed as a hero for surviving the treacherous river.");
                            System.out.println("You live out your days in the city, sharing your story and inspiring others with your courage.");
                            System.exit(0); // End the game
                            break;
                        case 2: // Ford
                            if (random.nextBoolean()) { // Random success/failure
                                System.out.println("You find a shallow spot and cross the river safely, " + userName + ".");
                                System.out.println("On the other side, you find a hidden cave filled with ancient artifacts and forgotten treasures.");
                                System.out.println("You collect the treasures, becoming rich and famous. You dedicate your life to studying the artifacts, uncovering secrets of the past.");
                                System.exit(0); // End the game
                            } else {
                                System.out.println("You can't find a safe crossing, " + userName + ". You return to the trail, defeated.");
                                System.out.println("As you turn back, you hear a strange rustling in the bushes. A mysterious figure emerges, offering you a map that leads to a hidden path across the river.");
                                System.out.println("Following the map, you find a safe crossing and continue your journey, grateful for the stranger's help.");
                                System.out.println("You eventually reach a bustling town, where you decide to settle down and start a new life.");
                                System.exit(0); // End the game
                            }
                            break;
                        case 3: // Raft
                            System.out.println("You spend hours gathering materials and building a raft, " + userName + ".");
                            System.out.println("The raft is rickety but floats. You push off into the current.");
                            System.out.println("After a harrowing journey through rapids and waterfalls, you reach a serene lake.");
                            System.out.println("In the middle of the lake, you find a floating island with a magnificent castle.");
                            System.out.println("You explore the castle, discovering a powerful artifact that allows you to control the elements.");
                            System.out.println("With your newfound power, you return home and use it to protect your loved ones and make the world a better place.");
                            System.exit(0); // End the game
                            break;
                        default:
                            System.out.println("Invalid choice -  You try to jump over the water but slip and fall in. Your journey ends here " + userName);
                            System.exit(0); // End the game
                    }
                } else { // Don't cross the river
                    System.out.println("You follow the riverbank, " + userName + ", hoping to find a safer crossing. The path leads you to a hidden waterfall.");
                    System.out.println("Behind the waterfall, you discover a secret cave. Do you enter (yes/no)?");
                    if (checkResponse()) { // Enter cave
                        System.out.println("Inside the cave, you find a group of friendly gnomes who are impressed by your bravery.");
                        System.out.println("They offer to guide you through the forest and share their knowledge of its secrets.");
                        System.out.println("With their help, you navigate the treacherous terrain and avoid dangerous creatures.");
                        System.out.println("The gnomes lead you to an ancient tree, said to hold the wisdom of the forest.");
                        System.out.println("You touch the tree and are filled with a sense of peace and understanding.");
                        System.out.println("You thank the gnomes for their kindness and continue your journey, now equipped with the knowledge to face any challenge.");
                        System.out.println("You eventually emerge from the forest, wiser and stronger than before.");
                        System.exit(0); // End the game
                    } else { // Don't enter cave
                        System.out.println("You decide to stay by the waterfall, enjoying the peace and beauty of the natural wonder.");
                        System.out.println("As you rest, you notice a hidden path behind the cascade of water.");
                        System.out.println("Curiosity piqued, you follow the path and it leads you to a hidden grotto.");
                        System.out.println("Inside the grotto, you find a shimmering pool of water.");
                        System.out.println("Do you drink from the pool (yes/no)?");
                        if (checkResponse()) {
                            System.out.println("The water tastes sweet and refreshing. As you drink, you feel a surge of energy coursing through your veins.");
                            System.out.println("You realize the pool is a magical spring, granting you enhanced strength and agility.");
                            System.out.println("With your newfound abilities, you continue your journey, confident that you can overcome any obstacle.");
                            System.out.println("You eventually escape the forest and return home, forever grateful for the gift of the magical spring.");
                            System.exit(0); // End the game
                        } else {
                            System.out.println("You decide not to risk drinking from the unknown pool.");
                            System.out.println("You leave the grotto and continue exploring the forest, eventually finding your way out.");
                            System.out.println("Although you don't encounter any more magic, you are satisfied with the adventure and knowledge you gained from your time in the forest.");
                            System.exit(0); // End the game
                        }
                    }
                }
            }
        } else {
            System.out.println("Smart choice, " + userName + ". The forest is dark and full of unknown dangers.");
            System.out.println("You decide to stay put and wait for rescue.");
            System.out.println("Hours pass, but you don't mind. The forest is peaceful, and you find solace in its embrace.");
            System.out.println("Eventually, a search party finds you and guides you back to civilization.");
            System.out.println("You return home, forever changed by your adventure in the mysterious forest.");
            System.out.println("(Please try another path next time!)");
            System.exit(0); // End the game
        }
    }

    public static boolean checkResponse() {
        String response = stdin.nextLine();
        if (response.equalsIgnoreCase("yes") || response.equalsIgnoreCase("y")) {
            return true;
        } else if (response.equalsIgnoreCase("no") || response.equalsIgnoreCase("n")) {
            return false;
        } else { // Error handling for invalid response
            System.out.println("Invalid response. Please enter 'yes' or 'no' (or their short form of 'y' or 'n').");
            return checkResponse(); // Recursive call to get a valid response.
        }
    }
}
