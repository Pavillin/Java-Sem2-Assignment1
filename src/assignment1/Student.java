package assignment1;

import java.time.LocalDate;
import java.time.Period;

/**
 *
 * @author Dylan
 */
public class Student {
    /**
     * Instance variables
     */
    private String firstName, lastName, streetAddress, city, postalCode;
    private int studentNum;
    private LocalDate dateEnrolled, dateOfBirth;
    private boolean inGoodStanding = true;
    
    /**
     * The student constructor that makes up a student
     * @param firstName
     * @param lastName
     * @param streetAddress
     * @param city
     * @param postalCode
     * @param dateOfBirth
     * @param dateEnrolled
     * @param studentNum 
     */
    public Student (String firstName, String lastName, String streetAddress, String city,
                    String postalCode, LocalDate dateOfBirth, LocalDate dateEnrolled,
                    int studentNum){
        setFirstName(firstName);
        setLastName(lastName);
        setStreetAddress(streetAddress);
        setCity(city);
        setPostalCode(postalCode);
        setDateOfBirth(dateOfBirth);
        setDateEnrolled(dateEnrolled);
        setStudentNum(studentNum);
    }

    /**
     * return the first name
     * @return 
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * set the first name and verify the input has a value
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
     * return the last name
     * @return 
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * set the last name and verify the input has a value
     * @param lastName 
     */
    public void setLastName(String lastName) {
        if("".equals(lastName)){
            throw new IllegalArgumentException("The last name cannot be empty.");
        } else{
            this.lastName = lastName;
        }
    }

    /**
     * return the street address
     * @return 
     */
    public String getStreetAddress() {
        return streetAddress;
    }

    /**
     * set the street address and verify the input has a value
     * @param streetAddress 
     */
    public void setStreetAddress(String streetAddress) {
        if("".equals(streetAddress)){
            throw new IllegalArgumentException("The street address cannot be empty.");
        } else {
            this.streetAddress = streetAddress;
        }
    }

    /**
     * return the city
     * @return 
     */
    public String getCity() {
        return city;
    }

    /**
     * set the city and verify the input has a value
     * @param city 
     */
    public void setCity(String city) {
        if("".equals(city)){
            throw new IllegalArgumentException("The city cannot be empty.");
        } else{
            this.city = city;
        }
    }

    /**
     * return the postal code
     * @return 
     */
    public String getPostalCode() {
        return postalCode;
    }

    /**
     * set the postal code and make sure the input has a value
     * @param postalCode 
     */
    public void setPostalCode(String postalCode) {
        if("".equals(postalCode)){
            throw new IllegalArgumentException("The postal code cannot be empty.");
        } else{
            this.postalCode = postalCode;
        }
    }

    /**
     * return the student number
     * @return 
     */
    public int getStudentNum() {
        return studentNum;
    }

    /**
     * set the student number and make sure it's valid(>0)
     * @param studentNum 
     */
    public void setStudentNum(int studentNum) {
        if(studentNum < 0){
            throw new IllegalArgumentException("Invalid student number.");
        } else{
            this.studentNum = studentNum;
        }
    }

    /**
     * return the date the student enrolled
     * @return 
     */
    public LocalDate getDateEnrolled() {
        return dateEnrolled;
    }

    /**
     * set the date enrolled and verify the student didn't enroll in the future
     * @param dateEnrolled 
     */
    public void setDateEnrolled(LocalDate dateEnrolled) {
        if(dateEnrolled.isAfter(LocalDate.now())){
            throw new IllegalArgumentException("Invalid enrollment date.");
        } else{
            this.dateEnrolled = dateEnrolled;
        }
    }
    
    /**
     * getYearEnrolled will get the year the student enrolled
     * @return 
     */
    public int getYearEnrolled(){
        int yearEnrolled = dateEnrolled.getYear();
        return yearEnrolled;
    }

    /**
     * return the students date of birth
     * @return 
     */
    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * Set the students date of birth and verify they're younger than 100 years old
     * @param dateOfBirth 
     */
    public void setDateOfBirth(LocalDate dateOfBirth) {
        if(Period.between(dateOfBirth, LocalDate.now()).getYears()>100){
            throw new IllegalArgumentException("Student cannot be older than 100.");
        } else{
            this.dateOfBirth = dateOfBirth;
        }
    }

    /**
     * inGoodStanding (true/false) will be returned
     * @return 
     */
    public boolean isInGoodStanding() {
        return inGoodStanding;
    }
    
    /**
     * setInGoodStanding will initially set inGoodStanding to true
     * @param inGoodStanding 
     */
    public void setInGoodStanding(boolean inGoodStanding) {
        this.inGoodStanding = inGoodStanding;
    }
    
    /**
     * suspendStudent will set the students inGoodStanding to false
     * @return 
     */
    public boolean suspendStudent(){
        return inGoodStanding = false;
    }
    
    /**
     * reinstateStudent will set the students inGoodStanding back to true
     * @return 
     */
    public boolean reinstateStudent(){
        return inGoodStanding = true;
    }
    
    /**
     * getAge will calculate how old the student is in years
     * @return 
     */
    public int getAge(){
        int age = Period.between(dateOfBirth, LocalDate.now()).getYears();
        return age;
    }
    
    /**
     * getYearBorn will get the year the student was born
     * @return 
     */
    public int getYearBorn(){
        int yearBorn = dateOfBirth.getYear();
        return yearBorn;
    }
    
    /**
     * override the toString method returning the first name, last name, and student number
     * @return 
     */
    @Override
    public String toString()
    {
        return firstName + " " + lastName + ", student number: " + studentNum;
    }
}
