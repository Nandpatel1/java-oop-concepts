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



public class Association {
    public static void main(String[] args) {

    }
}
