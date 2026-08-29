import java.util.ArrayList;
import java.util.List;

// Represents the student using the program and the courses they've enrolled into.
public class Student {

    // The list of courses the student is currently enrolled in.
    private List<Course> coursesEnrolled;

    public Student() {
        this.coursesEnrolled = new ArrayList<>();
    }

    // Checks if a student is enrolled in the course or not
    public boolean isEnrolled(Course course) {
        return coursesEnrolled.contains(course);
    }

    // Adds a course to the student's enrolled list.
    public void enroll(Course course) {
        coursesEnrolled.add(course);
    }

    // Returns a copy of the courses enrolled
    public List<Course> getCoursesEnrolled() {
        List<Course> copy = new ArrayList<>(coursesEnrolled);
        return copy;
    }

    // Withdraws/removes a course from the coursesEnrolled list
    public void  withdrawCourse(Course course) {
        coursesEnrolled.remove(course);
    }
}