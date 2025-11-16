package OOPs.Associations_Aggregation_Composition;

class Passport_ {
    private String passportNumber;
    Passport_(String passportNumber){
        this.passportNumber = passportNumber;
    }

    public String getPassportNumber(){
        return passportNumber;
    }
}
class Student1 {
    String name;
    Passport_ passport;

    Student1(String name, String passportNumber) {
        this.name = name;
        this.passport = new Passport_(passportNumber);
    }

    public void displayDetails(){
        System.out.println("Name: " + name);
        System.out.println("Passport number: " + passport.getPassportNumber());
    }
}

// Composition : Opposite of Aggregation
//               A class owns another class within it.
//               Strong relationship.
public class Composition {
    public static void main(String[] args) {
        Student1 one = new Student1("One", "222222");
        one.displayDetails();
    }
}
