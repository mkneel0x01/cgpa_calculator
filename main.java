import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

 class GPACGPAcalculator {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            clearScreen();
            printHeader("GPA & CGPA Calculator");

            System.out.println("1. Calculate GPA");
            System.out.println("2. Calculate CGPA");
            System.out.println("3. How GPA & CGPA are calculated");
            System.out.println("4. Exit");
            System.out.print("\nEnter your choice: ");
            int choice = inputValidation("");

            switch (choice) {
                case 1:
                    calculateGPA();
                    break;
                case 2:
                    calculateCGPA();
                    break;
                case 3:
                    displayMethod();
                    break;
                case 4:
                    exitApplication();
                    return;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
                    break;
            }
            System.out.println("\nPress Enter to continue...");
            scanner.nextLine(); // Wait for user to press enter
        }
    }

    private static void clearScreen() {
        // Clear the screen - simulated by printing new lines
        for (int i = 0; i < 50; ++i) System.out.println();
    }

    private static void printHeader(String title) {
        System.out.println(String.format("%50s", "").replace(' ', '-'));
        System.out.printf("%-25s%s%n", "", title);
        System.out.println(String.format("%50s", "").replace(' ', '-'));
        System.out.println();
    }

    private static void calculateGPA() {
        clearScreen();
        printHeader("GPA Calculation");

        System.out.print("Enter the number of subjects: ");
        int numSubjects = inputValidation("");
        List<Float> credits = new ArrayList<>();
        List<Float> grades = new ArrayList<>();
        float totalCredits = 0, weightedSum = 0;

        for (int i = 0; i < numSubjects; ++i) {
            System.out.print("Enter credit hours for subject " + (i + 1) + ": ");
            float credit = inputValidation("");
            credits.add(credit);

            System.out.print("Enter grade (point) for subject " + (i + 1) + ": ");
            float grade = inputValidation("");
            grades.add(grade);

            weightedSum += credit * grade;
            totalCredits += credit;
        }

        System.out.printf("Your GPA is: %.2f%n", weightedSum / totalCredits);
    }

    private static void calculateCGPA() {
        clearScreen();
        printHeader("CGPA Calculation");

        System.out.print("Enter the number of semesters: ");
        int numSemesters = inputValidation("");
        float sumGPA = 0;

        for (int i = 0; i < numSemesters; ++i) {
            System.out.print("Enter GPA for semester " + (i + 1) + ": ");
            sumGPA += inputValidation("");
        }

        System.out.printf("Your CGPA is: %.2f%n", sumGPA / numSemesters);
    }

    private static void displayMethod() {
        clearScreen();
        printHeader("Calculation Method");
        System.out.println("GPA is calculated as the sum of (credit hours * grade points) for all subjects, divided by the total credit hours.");
        System.out.println("CGPA is the average of GPA calculated across all semesters.\n");
    }

    private static void exitApplication() {
        clearScreen();
        System.out.println("Thank you for using the GPA & CGPA Calculator. Goodbye!");
    }

    private static int inputValidation(String prompt) {
        int input = -1;
        boolean valid = false;
        while (!valid) {
            try {
                if (!prompt.isEmpty()) System.out.print(prompt);
                input = scanner.nextInt();
                if (input >= 0) {
                    valid = true;
                } else {
                    System.out.print("Invalid input. Please enter a positive number: ");
                }
            } catch (InputMismatchException e) {
                System.out.print("Invalid input. Please enter a positive number: ");
                scanner.next(); // consume the invalid input
            }
        }
        scanner.nextLine(); // consume the rest of the line
        return input;
    }
}
