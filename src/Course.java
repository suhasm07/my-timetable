// Abstract superclass for a course. Holds fields shared by every course type.
public abstract class Course {
    private String courseName;
    private String year;
    private String dayOfLecture;
    private String timeOfLecture;
    private double durationHours;

    protected Course(String courseName, String year, String dayOfLecture,
                      String timeOfLecture, double durationHours) {
        this.courseName = courseName;
        this.year = year;
        this.dayOfLecture = dayOfLecture;
        this.timeOfLecture = timeOfLecture;
        this.durationHours = durationHours;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getYear() {
        return year;
    }

    public String getDayOfLecture() {
        return dayOfLecture;
    }

    public String getTimeOfLecture() {
        return timeOfLecture;
    }

    public double getDurationHours() {
        return durationHours;
    }


//  returns how this course is delivered(e.g. "Face-to-face" or "Online")
    public abstract String getDeliveryMode();

//  returns the capacity of the course. e.g. "120" for a capped course or "N/A" for an uncapped one.
    public abstract String getCapacityInfo();

//  Formats the end time of the lecture based on start time + duration. (e.g. "11:30-13:30")
    private String getEndTime() {
        String[] timeParts = timeOfLecture.split(":");
        int startHour = Integer.parseInt(timeParts[0]);
        int startMinute = Integer.parseInt(timeParts[1]);

        int totMinutes = (int) Math.round(durationHours * 60);
        int endHour = startHour + (startMinute + totMinutes) / 60;
        int endMinute = (startMinute + totMinutes) % 60;

        return String.format("%02d:%02d", endHour % 24, endMinute);
    }

//  Common display format used throughout the menu. e.g.: "Java programming  Face-to-face  Wed 11:30-13:30"
    @Override
    public String toString() {
        String shortDay;
        if (dayOfLecture.length() >= 3) {
            shortDay = dayOfLecture.substring(0, 3);
        } else {
            shortDay = dayOfLecture;
        }

        String endTime = getEndTime();

        return String.format("%-30s %-16s %s %s-%s",
                courseName, getDeliveryMode(), shortDay, timeOfLecture, endTime);
    }
}
