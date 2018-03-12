package assignment1;

import java.util.ArrayList;

/**
 *
 * @author Dylan
 */
public class Course {
    /**
     * Instance variables.
     */
    private Instructor instructor;
    private String courseCode, courseName, room;
    private ArrayList<Student> students = new ArrayList<Student>();
    private int maxStudents;
    
    /**
     * Course constructor
     * @param instructor
     * @param courseCode
     * @param courseName
     * @param room
     * @param maxStudents
     */
    public Course(Instructor instructor, String courseCode, String courseName, String room, int maxStudents){
        setInstructor(instructor);
        setCourseCode(courseCode);
        setCourseName(courseName);
        setRoom(room);
        setMaxStudents(maxStudents);
    }

    /**
     * Return the instructor
     * @return 
     */
    public Instructor getInstructor() {
        return instructor;
    }

    /**
     * Verify the instructor is certified to teach the course.
     * @param instructor 
     */
    public void setInstructor(Instructor instructor) {
        if(instructor.canTeach("COMP1008")){
            this.instructor = instructor;
        }else{
            throw new IllegalArgumentException("The instructor isn't certified to teach the course.");
        }
        
        //v DOES NOT WORK v
        /*if(instructor.canTeach(getCourseCode())){
            this.instructor = instructor;
        }else{
            throw new IllegalArgumentException("The instructor isn't certified to teach the course.");
        }*/
    }

    /**
     * Return the course code.
     * @return 
     */
    public String getCourseCode() {
        return courseCode;
    }

    /**
     * Verify the course code isn't empty.
     * @param courseCode 
     */
    public void setCourseCode(String courseCode) {
        if("".equals(courseCode)){
            throw new IllegalArgumentException("The course code cannot be empty.");
        }else{
            this.courseCode = courseCode;
        }
    }

    /**
     * Return the course name.
     * @return 
     */
    public String getCourseName() {
        return courseName;
    }

    /**
     * Verify the course name isn't empty.
     * @param courseName 
     */
    public void setCourseName(String courseName) {
        if("".equals(courseName)){
            throw new IllegalArgumentException("The course name cannot be empty.");
        }else{
            this.courseName = courseName;
        }
    }

    /**
     * Return the room.
     * @return 
     */
    public String getRoom() {
        return room;
    }

    /**
     * Verify the room isn't empty.
     * @param room 
     */
    public void setRoom(String room) {
        if("".equals(room)){
            throw new IllegalArgumentException("The room cannot be empty.");
        }else{
            this.room = room;
        }
    }

    /**
     * Return the maximum students allowed in a course.
     * @return 
     */
    public int getMaxStudents() {
        return maxStudents;
    }

    /**
     * Verify the number of students in a course is within 0-45.
     * @param maxStudents 
     */
    public void setMaxStudents(int maxStudents) {
        if(maxStudents > 0 && maxStudents <= 45){
            this.maxStudents = maxStudents;
        }else{
            throw new IllegalArgumentException("The maximum number of students must be within the range 0-45.");
        }
    }
    
    /**
     * Verify the student is in good standing and there's enough space in the course, if so add the student to the course.
     * @param student 
     */
    public void addStudent(Student student){
        if(student.isInGoodStanding()){
            if(students.size() < maxStudents){
                students.add(student);
            }else{
                throw new IllegalArgumentException("There isn't enough space in the course.");
            }
        }else{
            throw new IllegalArgumentException("The student isn't in good standing.");
        }
    }
    
    /**
     * Print the names of each student registered in the class 
     */
    public void showClassList(){
        for(Student value: students){
            System.out.println(value);
        }
    }
    
    /**
     * Return an ArrayList of students enrolled in the course
     * @return 
     */
    public ArrayList getStudents(){
        return students;
    }
    
    /**
     * override the toString method returning the course name and course code
     * @return 
     */
    @Override
    public String toString() {
        return courseName + " " + courseCode;
    }
    
    
}
