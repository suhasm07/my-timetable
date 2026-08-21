import java.io.IOException;
import java.util.Scanner;
import java.util.List;

// Entry point for the MyTimetable console application.
public class MyTimetable {

    private static final String COURSES_FILE = "course.csv";

    // Holds all the courses loaded from the CSV file.
    private CourseCatalog catalog;

    // Holds the courses the current user has enrolled into.
    private Student student;

    // Reads what the user types into the console.
    private Scanner scanner;

    public MyTimetable() {
        this.catalog = new CourseCatalog();
        this.scanner = new Scanner(System.in);
        this.student = new Student();
    }

    // Option 1: search by keyword to enroll. Lets the user search for a course by keyword, then choose one to enroll into.
    private void searchByKeyAndEnroll() {
        System.out.print("Please provide a brand: ");
        String keyword = scanner.nextLine().trim();

        List<Course> matchedCourses = catalog.searchByKeyword(keyword);

        if (matchedCourses.isEmpty()) {
            System.out.println("No courses matched your keyword.");
            return;
        }

        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("> Select from matching list");
        System.out.println("--------------------------------------------------------------------------------");

        int ind = 1;
        for (Course course : matchedCourses) {
            System.out.println(" " + ind + ") " + course.getCourseName());
            ind += 1;
        }
        int backToMenu = matchedCourses.size() + 1;
        System.out.println(" " + backToMenu + ") Go to main menu");

        System.out.print("Please select: ");
        int choice = Integer.parseInt(scanner.nextLine().trim());

        if (choice == backToMenu) {
            return;
        }

        Course chosenCourse = matchedCourses.get(choice - 1);

        // checks if student is already enrolled before enrolling
        if (student.isEnrolled(chosenCourse)) {
            System.out.println("You are already enrolled in " + chosenCourse.getCourseName() + ".");
        } else {
            student.enroll(chosenCourse);
            System.out.println("You have enrolled in the course " + chosenCourse.getCourseName() + "!");
        }
    }

    // Option 2: displays all the courses the student is currently enrolled in.
    private void showCoursesEnrolled() {
        List<Course> coursesEnrolled = student.getCoursesEnrolled();

        if (coursesEnrolled.isEmpty()) {
            System.out.println("You don't have any courses enrolled.");
            return;
        }

        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("You have enrolled into the following course(s):");
        System.out.println("--------------------------------------------------------------------------------");

        int ind = 1;
        for (Course course : coursesEnrolled) {
            System.out.println(" " + ind + ") " + course);
            ind += 1;
        }
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
                    searchByKeyAndEnroll();
                    break;
                case "2":
                    showCoursesEnrolled();
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
