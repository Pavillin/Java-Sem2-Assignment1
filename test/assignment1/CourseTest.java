/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment1;

import java.time.LocalDate;
import java.time.Month;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Dylan
 */
public class CourseTest
{
    Course course;
    Instructor instructor;
    
    public CourseTest()
    {
    }
    
    @BeforeClass
    public static void setUpClass()
    {
    }
    
    @AfterClass
    public static void tearDownClass()
    {
    }
    
    @Before
    public void setUp()
    {
        Student validStudent = new Student("Barb", "Dwyer", "123 Happy St", "Barrie", "L4M 8T0", LocalDate.of(1976, Month.MARCH, 10), LocalDate.of(2016, Month.SEPTEMBER, 1), 10001);
        instructor = new Instructor("Professor", "Snape", "11 Sinsister St", "London", "L0L 1W4", LocalDate.of(2000, Month.SEPTEMBER, 12), LocalDate.of(1976, Month.MARCH, 12), 1); 
        instructor.addCourseToAbilities("COMP1008");
        course = new Course(instructor, "COMP1008", "Intro to Objects", "K324", 2);
    }
    
    @After
    public void tearDown()
    {
    }

    /**
     * Test of getInstructor method, of class Course.
     */
    @Test
    public void testGetInstructor()
    {
        
        Instructor expResult = instructor;
        Instructor result = course.getInstructor();
        assertEquals(expResult, result);
    }

    /**
     * Test of setInstructor method, of class Course.
     */
    @Test
    public void testSetInstructorInvalid()
    {
        System.out.println("setInstructor");
        Instructor instructor = new Instructor("Funny", "Guy", "11 Funny St", "London", "L0L 1W4", LocalDate.of(2000, Month.SEPTEMBER, 12), LocalDate.of(1976, Month.MARCH, 12), 1);
        try{
            course.setInstructor(instructor);
            fail("The Instructor is not qualified to teach this course");
        }
        catch (IllegalArgumentException e)
        {
            System.out.println(e);
        }
        
        
    }

    /**
     * Test of getCourseCode method, of class Course.
     */
    @Test
    public void testGetCourseCode()
    {
        String expResult = "COMP1008";
        String result = course.getCourseCode();
        assertEquals(expResult, result);
    }

    /**
     * Test of setCourseCode method, of class Course.
     */
    @Test
    public void testSetCourseCodeInvalid()
    {
        
        String courseCode = "";
        try{
            course.setCourseCode(courseCode);
            fail("The course code cannot be empty");
        }
        catch (IllegalArgumentException e)
        {
            System.out.println(e);
        }
        
    }

    /**
     * Test of getCourseName method, of class Course.
     */
    @Test
    public void testGetCourseName()
    {
        String expResult = "Intro to Objects";
        String result = course.getCourseName();
        assertEquals(expResult, result);
    }

    /**
     * Test of setCourseName method, of class Course.
     */
    @Test
    public void testSetCourseNameInvalid()
    {
        String courseName = "";
        try{
            course.setCourseName(courseName);
            fail("The course name cannot be empty");
        }
        catch (IllegalArgumentException e)
        {
            System.out.println(e);
        }
    }

    /**
     * Test of getRoom method, of class Course.
     */
    @Test
    public void testGetRoom()
    {
        String expResult = "K324";
        String result = course.getRoom();
        assertEquals(expResult, result);
    }

    /**
     * Test of setRoom method, of class Course.
     */
    @Test
    public void testSetRoomInvalid()
    {
        String room = "";
        try{
            course.setRoom(room);
            fail("The test case is a prototype.");    
        }
        catch (IllegalArgumentException e)
        {
            System.out.println(e);
        }
        
    }

    /**
     * Test of getMaxStudents method, of class Course.
     */
    @Test
    public void testGetMaxStudents()
    {
        int expResult = 2;
        int result = course.getMaxStudents();
        assertEquals(expResult, result);
    }

    /**
     * Test of setMaxStudents method, of class Course.
     */
    @Test
    public void testSetMaxStudentsLow()
    {
        int maxStudents = 0;
        try{
            course.setMaxStudents(maxStudents);
            fail("Class size must be greater than 0");    
        }
        catch (IllegalArgumentException e)
        {
            System.out.println(e);
        }
    }
    
    /**
     * Test of setMaxStudents method, of class Course.
     */
    @Test
    public void testSetMaxStudentsHigh()
    {
        int maxStudents = 46;
        try{
            course.setMaxStudents(maxStudents);
            fail("Class size must be greater than 0");    
        }
        catch (IllegalArgumentException e)
        {
            System.out.println(e);
        }
    }

    /**
     * Test of toString method, of class Course.
     */
    @Test
    public void testToString()
    {
        String expResult = "Intro to Objects COMP1008";
        String result = course.toString();
        assertEquals(expResult, result);
    }
}
