import java.util.ArrayList;
import java.util.List;

public class CourseMaster {
    List<Course> courseList = new ArrayList<>();

    void add(Course newCourse){
        courseList.add(newCourse);
    }

    public Course get(int courseId){
        for (int i = 0; i < courseList.size(); i++) {
            Course course = courseList.get(i);

            if(courseId == course.getCourseId())
                return course;
        }
        throw new IllegalArgumentException("Course with id "+courseId+" is not present");
    }

    void delete(int courseId){
        for (int i = 0; i < courseList.size(); i++) {
            Course course = courseList.get(i);

            if(courseId == course.getCourseId()){
                courseList.remove(course);
                return;
            }

        }
        throw new IllegalArgumentException("Course with id "+courseId+" is not present");
    }

    void update(int courseId,String courseDescription){
        for (int i = 0; i < courseList.size(); i++) {
            Course course = courseList.get(i);

            if(courseId == course.getCourseId()){
                course.setDescription(courseDescription);
                return;
            }

        }
        throw new IllegalArgumentException("Course with id "+courseId+" is not present");
    }

    List<Course> getCourseList(){
        return courseList;
    }

    void printCourses(){
        for (Course course : courseList) {
            System.out.println(course);
        }
    }
    public static void main(String[] args) {
        Course course1 = new Course(1,"C course","C language is basic for all");
        Course course2 = new Course(2,"Java course","Java language is powerful");
        Course course3 = new Course(3,"Javascript course","Javascript is used in web");

        CourseMaster courseMaster = new CourseMaster();

        //add courses
        courseMaster.add(course1);
        courseMaster.add(course2);
        courseMaster.add(course3);

        System.out.println("All courses added");
        courseMaster.printCourses();
        System.out.println();

        //get course
        Course course = courseMaster.get(1);
        System.out.println("Course with course id 1 is :"+course);
        System.out.println();

        //update course
        courseMaster.update(3,"Javascript  is weired language");
        System.out.println("After updation");
        courseMaster.printCourses();
        System.out.println();

        //delete course
        courseMaster.delete(2);
        System.out.println("After deletion");
        courseMaster.printCourses();
    }
}
