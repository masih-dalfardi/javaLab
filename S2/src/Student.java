public class Student {
    // the student’s first name
    private String firstName;
    // the student’s last name
    private String lastName;
    //the student ID
    private String id;
    //the grade
    private int grade;

    /**
     * Create a new student with a given name and ID number.
     *
     * @param fName first name of student
     * @param lname last name of student
     * @param sID   student ID
     */

    public Student(String fName, String lname, String sID) {
        firstName = fName;
        lastName = lname;
        id = sID;
        grade = 12;

    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade1) {
        grade = grade1;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String fName) {
        firstName = fName;
    }

    public void print() {
        System.out.println(lastName + ", student ID: " + id + ", grade: " + grade);
    }
}
