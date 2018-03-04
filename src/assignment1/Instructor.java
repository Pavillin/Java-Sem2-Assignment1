package assignment1;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

/**
 *
 * @author Dylan
 */
public class Instructor {
    /**
     * Instance Variables
     */
    private String firstName, lastName, streetAddress, city, postalCode;
    private LocalDate hireDate, birthday;
    private int employeeNum;
    private ArrayList<String> teachableSubjects = new ArrayList();
    
    /**
     * Instructor constructor
     * @param firstName
     * @param lastName
     * @param streetAddress
     * @param city
     * @param postalCode
     * @param hireDate
     * @param birthday
     * @param employeeNum
     */
    public Instructor(String firstName, String lastName, String streetAddress, String city, String postalCode, LocalDate hireDate, LocalDate birthday, int employeeNum) {
        setFirstName(firstName);
        setLastName(lastName);
        setStreetAddress(streetAddress);
        setCity(city);
        setPostalCode(postalCode);
        setHireDate(hireDate);
        setBirthday(birthday);
        setEmployeeNum(employeeNum);
    }

    /**
     * Return the first name.
     * @return 
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Verify the first name isn't empty.
     * @param firstName 
     */
    public void setFirstName(String firstName) {
        if("".equals(firstName)){
            throw new IllegalArgumentException("The first name cannot be empty.");
        } else{
            this.firstName = firstName;
        }
    }

    /**
     * Return the last name
     * @return 
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Verify the last name isn't empty.
     * @param lastName 
     */
    public void setLastName(String lastName) {
        if("".equals(lastName)){
            throw new IllegalArgumentException("The last name cannot be empty.");
        }else{
            this.lastName = lastName;
        }
    }

    /**
     * Return the street address.
     * @return 
     */
    public String getStreetAddress() {
        return streetAddress;
    }

    /**
     * Verify the street address isn't empty.
     * @param streetAddress 
     */
    public void setStreetAddress(String streetAddress) {
        if("".equals(streetAddress)){
            throw new IllegalArgumentException("The street address cannot be empty.");
        }else{
            this.streetAddress = streetAddress;
        }
    }

    /**
     * Return the city.
     * @return 
     */
    public String getCity() {
        return city;
    }

    /**
     * Verify the city isn't empty.
     * @param city 
     */
    public void setCity(String city) {
        if("".equals(city)){
            throw new IllegalArgumentException("The city cannot be empty.");
        }else{
            this.city = city;
        }
    }

    /**
     * Return the postal code.
     * @return 
     */
    public String getPostalCode() {
        return postalCode;
    }

    /**
     * Verify the postal code isn't empty.
     * @param postalCode 
     */
    public void setPostalCode(String postalCode) {
        if("".equals(postalCode)){
            throw new IllegalArgumentException("The postal code cannot be empty.");
        }
        this.postalCode = postalCode;
    }

    /**
     * Return the date the instructor was hired.
     * @return 
     */
    public LocalDate getHireDate() {
        return hireDate;
    }

    /**
     * Verify the hire date is within a month from today.
     * @param hireDate 
     */
    public void setHireDate(LocalDate hireDate) {
        if(hireDate.isAfter(LocalDate.now().plusMonths(1))){
            throw new IllegalArgumentException("The hire date can't be more than one month in the future.");
        }else{
            this.hireDate = hireDate;
        }
    }

    /**
     * Return the instructors birthday.
     * @return 
     */
    public LocalDate getBirthday() {
        return birthday;
    }

    /**
     * Set the instructors birthday and verify they're younger than 90 years old.
     * @param birthday 
     */
    public void setBirthday(LocalDate birthday) {
        if(Period.between(birthday, LocalDate.now()).getYears()>=90){
            throw new IllegalArgumentException("Instructor must be under 90 years old.");
        }else{
            this.birthday = birthday;
        }
    }

    /**
     * Return the employee number.
     * @return 
     */
    public int getEmployeeNum() {
        return employeeNum;
    }

    /**
     * Validate the employee number is greater than zero
     * @param employeeNum 
     */
    public void setEmployeeNum(int employeeNum) {
        if(employeeNum < 0){
            throw new IllegalArgumentException("Invalid employee number, must be greater than zero.");
        }else{
            this.employeeNum = employeeNum;
        }
    }
    
    /**
     * override the toString method returning the first name and last name
     * @return 
     */
    @Override
    public String toString() {
        return firstName + " " + lastName;
    }
    
    /**
     * getAge will calculate how old the instructor is in years
     * @return 
     */
    public int getAgeInYears(){
        return Period.between(birthday, LocalDate.now()).getYears();
    }
    
    /**
     * Will get the year the instructor was born
     * @return 
     */
    public int getYearBorn(){
        return birthday.getYear();
    }
    
    /**
     * Will get the number of years the instructor has worked at the college.
     * @return 
     */
    public int getYearsAtCollege(){
        return Period.between(hireDate, LocalDate.now()).getYears();
    }
    
    public void addCourseToAbilities(String courseCode){
        if("".equals(courseCode)){
            throw new IllegalArgumentException("The course code cannot be empty.");
        }else{
            teachableSubjects.add(courseCode.toUpperCase());
        }
    }
    
    public boolean canTeach(String courseCode){
        return teachableSubjects.contains(courseCode);
    }
    
    public String listOfSubjectsCertifiedToTeach(){
        return (teachableSubjects.toString().replace("[","").replace("]",""));
    }
    
}
