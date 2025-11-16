package OOPs.Associations_Aggregation_Composition;

class Passport {
    private String passportNumber;
    Passport(String passportNumber){
        this.passportNumber = passportNumber;
    }

    public String getPassportNumber(){
        return passportNumber;
    }
}
class Student_ {
    String name;
    Passport passport;

    Student_(String name, Passport passport) {
        this.name = name;
        this.passport = passport;
    }

    public void displayDetails(){
        System.out.println("Name: " + name);
        System.out.println("Passport number: " + passport.getPassportNumber());
    }
}

// Aggregation : A class can have another class within it but it does not owns it.
//               Means Student_ has Passport within it but it does not own that class.
//               It is a weak relationship.
public class Aggregation {
    public static void main(String[] args) {
        Passport passport = new Passport("11111111");
        Student_ student = new Student_("John", passport);
    }
}
