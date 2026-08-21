import java.io.IOException;
import java.util.Scanner;

// Entry point for the MyTimetable console application.
public class MyTimetable {

    private static final String COURSES_FILE = "course.csv";

    // Holds all the courses loaded from the CSV file.
    private CourseCatalog catalog;

    // Reads what the user types into the console.
    private Scanner scanner;

    public MyTimetable() {
        this.catalog = new CourseCatalog();
        this.scanner = new Scanner(System.in);
    }

    public static void main(String[] args) {
        MyTimetable app = new MyTimetable();
        app.run();
    }

    // Loads the course data, then keeps showing the menu until the user exits.
    public void run() {
        System.out.println("Welcome to MyTimetable!");

        try {
            catalog.loadFromCSV(COURSES_FILE);
        } catch (IOException e) {
            System.out.println("Could not load " + COURSES_FILE + ": " + e.getMessage());
            return;
        }

        // Keeps the menu showing until the user picks option 4 to Exit.
        boolean flag = true;
        while (flag) {
            printMenu();
            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    System.out.println("This option is not implemented yet.");
                    break;
                case "2":
                    System.out.println("This option is not implemented yet.");
                    break;
                case "3":
                    System.out.println("This option is not implemented yet.");
                    break;
                case "4":
                    flag = false;
                    break;
                default:
                    System.out.println("Please enter a number between 1 and 4.");
            }
        }
        System.out.println("Goodbye!");
        scanner.close();
    }

    // Prints the main menu options to the console.
    private void printMenu() {
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("> Select from main menu");
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println(" 1) Search by keyword to enroll");
        System.out.println(" 2) Show my enrolled courses");
        System.out.println(" 3) Withdraw from a course");
        System.out.println(" 4) Exit");
        System.out.print("Please select: ");
    }
}
