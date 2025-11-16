package OOPs.Associations;
import java.util.*;

// One to One
/*
class Passport {
    private String passportNumber;
    Passport(String passportNumber){
        this.passportNumber = passportNumber;
    }

    public String getPassportNumber(){
        return passportNumber;
    }
}
class Student {
    String name;
    Passport passport;

    Student(String name, Passport passport) {
        this.name = name;
        this.passport = passport;
    }

    public void displayDetails(){
        System.out.println("Name: " + name);
        System.out.println("Passport number: " + passport.getPassportNumber());
    }
}
 */




// One to Many
/*
class Student {
    private String name;

    Student(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }
}

class College {
    private String collegeName;
    private List<Student> students;

    College(String collegeName){
        this.collegeName = collegeName;
        students = new ArrayList<>();
    }

    public void addStudent(Student student){
        students.add(student);

    }

    public void printAllStudents(){
        int numberOfStudents = students.size();
        for(int i = 0; i < numberOfStudents; i++){
            System.out.println(students.get(i).getName());
        }
    }
}
*/


// Many to Many
class Student {
    private final String name;
    private List<Course> courses;
    Student(String name){
        this.name = name;
        courses = new ArrayList<>();
    }

    public String getName(){
        return name;
    }

    public void addCourse(Course course){
        courses.add(course);
    }

    public void displayAllCourses(){
        int numberOfStudents = courses.size();
        System.out.println("All courses of " + name);
        for(int i = 0; i < numberOfStudents; i++){
            System.out.print(courses.get(i).getName() + " ");
        }
        System.out.println('\n');
    }
}
class Course {
    private String name;
    private List<Student> students;

    Course(String name){
        this.name = name;
        students = new ArrayList<>();
    }

    public String getName(){
        return name;
    }

    public void addStudent(Student student){
        students.add(student);
    }

    public void displayAllStudents(){
        int numberOfStudents = students.size();
        System.out.println("All Student of course " + name);
        for(int i = 0; i < numberOfStudents; i++){
            System.out.print(students.get(i).getName() + " ");
        }
        System.out.println("\n");
    }
}



public class Association {
    public static void main(String[] args) {
        Course cs = new Course("CS");
        Course math = new Course("Math");

        Student john = new Student("John");
        Student sam = new Student("Sam");
        Student smith = new Student("Smith");

        cs.addStudent(john);
        math.addStudent(john);
        john.addCourse(cs);
        john.addCourse(math);

        math.addStudent(sam);
        sam.addCourse(math);

        cs.addStudent(smith);
        smith.addCourse(cs);

        john.displayAllCourses();
        math.displayAllStudents();
    }
}
