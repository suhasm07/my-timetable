// A course delivered online.
public class OnlineCourse extends Course {
    // Builds an online course
    public OnlineCourse(String courseName, String year, String dayOfLecture,
                         String timeOfLecture, double durationHours) {
        super(courseName, year, dayOfLecture, timeOfLecture, durationHours);
    }

    // Tells the superclass this course's delivery mode is online.
    @Override
    public String getDeliveryMode() {
        return "Online";
    }

    // Online courses have no capacity limit, so this always returns "N/A".
    @Override
    public String getCapacityInfo() {
        return "N/A";
    }
}