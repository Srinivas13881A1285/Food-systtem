import java.util.Objects;

public class Course {
    private int courseId;
    private String courseName;
    private String description;

    public Course(int courseId, String courseName, String description) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.description = description;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseId=" + courseId +
                ", courseName='" + courseName + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return courseId == course.courseId && Objects.equals(courseName, course.courseName) && Objects.equals(description, course.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(courseId, courseName, description);
    }
}
