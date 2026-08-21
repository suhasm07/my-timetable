import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

// Loads the full set of courses from a CSV file and stores them.
public class CourseCatalog {
//    An array list of Course
    private List<Course> courses;

    public CourseCatalog() {
        this.courses = new ArrayList<>();
    }

//  Reads "courses.csv" file and populates the catalog.
    public void loadFromCSV(String filePath) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line = reader.readLine();
            while ((line = reader.readLine()) != null) {
                if (line.isBlank()) {
                    continue;
                }
                Course course = parseCourseLine(line);
                if (course != null) {
                    courses.add(course);
                }
            }
        }
    }
//  Parses a single CSV row into the correct Course subclass, chosen by the "Delivery mode" column
    private Course parseCourseLine(String line) {
        String[] fields = line.split(",");
        if (fields.length < 7) {
            return null;
        }

        String name = fields[0].trim();
        String capacityText = fields[1].trim();
        String year = fields[2].trim();
        String deliveryMode = fields[3].trim();
        String day = fields[4].trim();
        String time = fields[5].trim();
        double duration = Double.parseDouble(fields[6].trim());

        if (deliveryMode.equals("Online")) {
            return new OnlineCourse(name, year, day, time, duration);
        } else {
            int capacity = Integer.parseInt(capacityText);
            return new FaceToFaceCourse(name, capacity, year, day, time, duration);
        }
    }

    // Returns a copy of the course list, so changes made outside this class don't affect the real list stored here.
    public List<Course> getAllCourses() {
        List<Course> copy = new ArrayList<>(courses);
        return copy;
    }

    public int size() {
        return courses.size();
    }
}
