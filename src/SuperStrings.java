/*Name: Jason CameronDate: 2024-07-08Description: This program is a simple string manipulation program that allows the user to perform various operations on a given string. */import java.util.Scanner;public class SuperStrings {    public static void main(String[] args) {        Scanner scanner = new Scanner(System.in);        String inputString;        String outputString;        int selection;        do {            System.out.println("Welcome to SUPER STRING SOFTWARE");            System.out.println("1) Regex Match");            System.out.println("2) Concatenate");            System.out.println("3) Last Character");            System.out.println("4) Contains Substring?");            System.out.println("5) Starts With?");            System.out.println("6) Ends With?");            System.out.println("7) Replace First Occurrence");            System.out.println("8) Compare To");            System.out.println("9) EXIT");            System.out.print("Select from one of the following string operations: ");            selection = scanner.nextInt();            scanner.nextLine(); // Consume leftover newline character            switch (selection) {                case 1:                    System.out.print("Enter a string: ");                    inputString = scanner.nextLine();                    System.out.println("Enter a regex pattern to match: ");                    String regexPattern = scanner.nextLine();                    outputString = inputString.matches(regexPattern) ? "matches" : "does not match";                    System.out.println("The string " + outputString + " the regex pattern.");                    break;                case 2:                    System.out.print("Enter the first string: ");                    String string1 = scanner.nextLine();                    System.out.print("Enter the second string: ");                    String string2 = scanner.nextLine();                    outputString = string1.concat(string2);                    System.out.println("The concatenated string is: " + outputString);                    break;                case 3:                    System.out.print("Enter a string: ");                    inputString = scanner.nextLine();                    outputString = inputString.substring(inputString.length() - 1);                    System.out.println("The last character is: " + outputString);                    break;                case 4:                    System.out.print("Enter a string: ");                    inputString = scanner.nextLine();                    System.out.print("Enter a substring: ");                    String substring = scanner.nextLine();                    outputString = String.valueOf(inputString.contains(substring));                    System.out.println("Does the string contain the substring? " + outputString);                    break;                case 5:                    System.out.print("Enter a string: ");                    inputString = scanner.nextLine();                    System.out.print("Enter a prefix: ");                    String prefix = scanner.nextLine();                    outputString = String.valueOf(inputString.startsWith(prefix));                    System.out.println("Does the string start with the prefix? " + outputString);                    break;                case 6:                    System.out.print("Enter a string: ");                    inputString = scanner.nextLine();                    System.out.print("Enter a suffix: ");                    String suffix = scanner.nextLine();                    outputString = String.valueOf(inputString.endsWith(suffix));                    System.out.println("Does the string end with the suffix? " + outputString);                    break;                case 7:                    System.out.print("Enter a string: ");                    inputString = scanner.nextLine();                    System.out.print("Enter the target: ");                    String target = scanner.nextLine();                    System.out.print("Enter the replacement: ");                    String replacement = scanner.nextLine();                    outputString = inputString.replaceFirst(target, replacement);                    System.out.println("The string with the first occurrence replaced is: " + outputString);                    break;                case 8:                    System.out.print("Enter the first string: ");                    String compString1 = scanner.nextLine();                    System.out.print("Enter the second string: ");                    String compString2 = scanner.nextLine();                    int comparison = compString1.compareTo(compString2);                    if (comparison < 0) {                        System.out.println("The first string is lexicographically smaller.");                    } else if (comparison > 0) {                        System.out.println("The first string is lexicographically greater.");                    } else {                        System.out.println("The strings are lexicographically equal.");                    }                    break;                case 9:                    System.out.println("Goodbye!");                    break;                default:                    System.out.println("Invalid selection.");            }        } while (selection != 9);        scanner.close();    }}