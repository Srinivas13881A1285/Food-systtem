import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


class CourseMasterTest {

    CourseMaster courseMaster;
    Course course1;
    Course course2;
    Course course3;

    @BeforeEach
    void setUp() {
        courseMaster = new CourseMaster();
        course1 = new Course(1, "C course", "C language is basic for all");
        course2 = new Course(2, "Java course", "Java language is powerful");
        course3 = new Course(3, "Javascript course", "Javascript is used in web");

        courseMaster.add(course1);
        courseMaster.add(course2);
        courseMaster.add(course3);
    }

    @AfterEach
    void tearDown() {
        courseMaster = null;
        course1 = null;
        course2 = null;
        course3 = null;
    }

    @Test
    void testAdd() {
        assertEquals(3, courseMaster.getCourseList().size());
        Course course4 = new Course(1, "C++ course", "C++ language is basic for all");
        courseMaster.add(course4);

        List<Course> courseList = courseMaster.getCourseList();
        assertEquals(4, courseList.size());
        assertTrue(courseList.contains(course4));
    }

    @Test
    void testGet() {
        assertEquals(course1, courseMaster.getCourseList().get(0));
        assertEquals("C course", courseMaster.getCourseList().get(0).getCourseName());
    }

    @Test
    void testDelete() {
        assertEquals(3,courseMaster.getCourseList().size());
        courseMaster.delete(2);
        assertEquals(2, courseMaster.getCourseList().size());
        assertFalse(courseMaster.getCourseList().contains(course2));
    }

    @Test
    void testUpdate() {
        //update course
        assertEquals("Javascript is used in web", courseMaster.get(3).getDescription());
        courseMaster.update(3, "Javascript  is weired language");
        assertEquals("Javascript  is weired language", courseMaster.get(3).getDescription());
    }


}