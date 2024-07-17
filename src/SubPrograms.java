// Name: Jason Cameron
// Date: 2024-07-16
// Description: This program provides a menu-driven interface for calculating various geometric properties such as area, volume, and perimeter using many subprograms.

import java.util.Scanner;

public class SubPrograms {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;

        do {
            displayMenu();
            choice = input.nextInt();

            switch (choice) {
                case 1: {
                    // Get the length and width of the rectangle from the user
                    double length = getDoubleInput("Enter length: ");
                    double width = getDoubleInput("Enter width: ");
                    double areaRectangle = calculateAreaRectangle(length, width);
                    displayResult("Area of rectangle", areaRectangle);
                    break;
                }
                case 2: {
                    // Get the base and height of the triangle from the user
                    double base = getDoubleInput("Enter base: ");
                    double height = getDoubleInput("Enter height: ");
                    double areaTriangle = calculateAreaTriangle(base, height);
                    displayResult("Area of triangle", areaTriangle);
                    break;
                }
                case 3: {
                    // Get the radius of the circle from the user
                    double radius = getDoubleInput("Enter radius: ");
                    double areaCircle = calculateAreaCircle(radius);
                    displayResult("Area of circle", areaCircle);
                    break;
                }
                case 4: {
                    // Get the side of the cube from the user
                    double side = getDoubleInput("Enter side: ");
                    double volumeCube = calculateVolumeCube(side);
                    displayResult("Volume of cube", volumeCube);
                    break;
                }
                case 5: {
                    // Get the radius of the sphere from the user
                    double radius = getDoubleInput("Enter radius: ");
                    double volumeSphere = calculateVolumeSphere(radius);
                    displayResult("Volume of sphere", volumeSphere);
                    break;
                }
                case 6: {
                    // Get the length and width of the rectangle from the user
                    double length = getDoubleInput("Enter length: ");
                    double width = getDoubleInput("Enter width: ");
                    double perimeterRectangle = calculatePerimeterRectangle(length, width);
                    displayResult("Perimeter of rectangle", perimeterRectangle);
                    break;
                }
                case 7: {
                    // Get the three sides of the triangle from the user
                    double side1 = getDoubleInput("Enter side 1: ");
                    double side2 = getDoubleInput("Enter side 2: ");
                    double side3 = getDoubleInput("Enter side 3: ");
                    double perimeterTriangle = calculatePerimeterTriangle(side1, side2, side3);
                    displayResult("Perimeter of triangle", perimeterTriangle);
                    break;
                }
                case 8: {
                    // Get the radius of the circle from the user
                    double radius = getDoubleInput("Enter radius: ");
                    double circumferenceCircle = calculateCircumferenceCircle(radius);
                    displayResult("Circumference of circle", circumferenceCircle);
                    break;
                }
                case 9: {
                    // Get the two bases and height of the trapezoid from the user
                    double base1 = getDoubleInput("Enter base 1: ");
                    double base2 = getDoubleInput("Enter base 2: ");
                    double height = getDoubleInput("Enter height: ");
                    double areaTrapezoid = calculateAreaTrapezoid(base1, base2, height);
                    displayResult("Area of trapezoid", areaTrapezoid);
                    break;
                }
                case 10: {
                    // Get the radius and height of the cylinder from the user
                    double radius = getDoubleInput("Enter radius: ");
                    double height = getDoubleInput("Enter height: ");
                    double volumeCylinder = calculateVolumeCylinder(radius, height);
                    displayResult("Volume of cylinder", volumeCylinder);
                    break;
                }
                case 0:
                    // Exit the program
                    System.out.println("Exiting...");
                    break;
                default:
                    // Invalid choice, display an error message and go again.
                    System.out.println("Invalid choice!");
            }
        } while (choice != 0); // Continue the loop until the user chooses to exit (enters 0)

        // Close the scanner to release system resources
        input.close();
    }

    // Subroutines (Methods)
    public static void displayMenu() {
        System.out.println("\nSelect a calculation:");
        System.out.println("1. Area of a rectangle");
        System.out.println("2. Area of a triangle");
        System.out.println("3. Area of a circle");
        System.out.println("4. Volume of a cube");
        System.out.println("5. Volume of a sphere");
        System.out.println("6. Perimeter of a rectangle");
        System.out.println("7. Perimeter of a triangle");
        System.out.println("8. Circumference of a circle");
        System.out.println("9. Area of a trapezoid");
        System.out.println("10. Volume of a cylinder");
        System.out.println("0. Exit");
    }

    public static void displayResult(String calculation, double result) {
        double roundedResult = roundResult(calculation, result); // Round the result to 2 or 3 decimal places based on the calculation
        System.out.println(calculation + ": " + roundedResult);
    }

    public static double getDoubleInput(String prompt) {
        System.out.print(prompt);
        return input.nextDouble();
    }

    public static double roundResult(String calculation, double result) {
        // Round the result to 2 decimal places for area and volume calculations, and 3 decimal places for perimeter and circumference calculations
        if (calculation.contains("Area") || calculation.contains("Volume")) {
            return Math.round(result * 100.0) / 100.0;
        } else {
            return Math.round(result * 1000.0) / 1000.0;
        }
    }

    // Calculation Methods (Included In-line)

    // Calculates the area of a rectangle given its length and width
    public static double calculateAreaRectangle(double length, double width) {
        return length * width;
    }

    // Calculates the area of a triangle given its base and height
    public static double calculateAreaTriangle(double base, double height) {
        return 0.5 * base * height;
    }

    // Calculates the area of a circle given its radius
    public static double calculateAreaCircle(double radius) {
        return Math.PI * radius * radius;
    }

    // Calculates the area of a trapezoid given its two bases and height
    public static double calculateAreaTrapezoid(double base1, double base2, double height) {
        return 0.5 * (base1 + base2) * height;
    }

    // Calculates the volume of a cube given its side length
    public static double calculateVolumeCube(double side) {
        return side * side * side;
    }

    // Calculates the volume of a sphere given its radius
    public static double calculateVolumeSphere(double radius) {
        return (4.0 / 3.0) * Math.PI * Math.pow(radius, 3); // 4/3 * pi * r^3
    }

    // Calculates the volume of a cylinder given its radius and height
    public static double calculateVolumeCylinder(double radius, double height) {
        return Math.PI * radius * radius * height;
    }

    // Calculates the perimeter of a rectangle given its length and width
    public static double calculatePerimeterRectangle(double length, double width) {
        return 2 * (length + width);
    }

    // Calculates the perimeter of a triangle given its three side lengths
    public static double calculatePerimeterTriangle(double side1, double side2, double side3) {
        return side1 + side2 + side3;
    }

    // Calculates the circumference of a circle given its radius
    public static double calculateCircumferenceCircle(double radius) {
        return 2 * Math.PI * radius;
    }

}
