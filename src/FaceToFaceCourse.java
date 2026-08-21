// A course delivered face-to-face.
public class FaceToFaceCourse extends Course {

    private int capacity;

    // Builds a face-to-face course. Passes the shared fields up to Course class and stores the extra capacity field here.
    public FaceToFaceCourse(String courseName, int capacity, String year,
                             String dayOfLecture, String timeOfLecture,
                             double durationHours) {
        super(courseName, year, dayOfLecture, timeOfLecture, durationHours);
        this.capacity = capacity;
    }

    // Returns the maximum number of students allowed in this course.
    public int getCapacity() {
        return capacity;
    }

    // Tells the superclass this course's delivery mode is face-to-face.
    @Override
    public String getDeliveryMode() {
        return "Face-to-face";
    }

    // Converts the capacity number into text for display, e.g. "120".
    @Override
    public String getCapacityInfo() {
        return String.valueOf(capacity);
    }
}