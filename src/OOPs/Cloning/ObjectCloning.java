package OOPs.Cloning;


class Address implements Cloneable{
    String city;

    Address(String city) {
        this.city = city;
    }

    // Overriding default clone() method
    @Override
    protected Object clone() throws CloneNotSupportedException {
//        return new Address(this.city);  // Creating a new object
        return super.clone();
    }
}

class Person implements Cloneable {
    String name; // Primitive field
    Address address; // Reference-type field

    Person(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    // clone() method is inherited from Object class and must be Overriden
    @Override
    protected Object clone() throws CloneNotSupportedException {
        /*
         // Use below for Shallow copy
        return super.clone();  // Shallow copy
         */

        Person clonedPerson = (Person) super.clone(); // Shallow copy
        // Cloning nested object for Deep Cloning
        clonedPerson.address = (Address) address.clone();
        return clonedPerson;
    }
}


public class ObjectCloning {
    public static void main(String[] args) throws CloneNotSupportedException {
        Address address = new Address("Mumbai");
        Person person = new Person("Rahul", address);

        Person clonedPerson = (Person) person.clone();

        clonedPerson.name = "Rajesh";
        clonedPerson.address.city = "Ahmedabad";

        // Output to check if changes are reflected in the original
        System.out.println(person.name + " lives in " + person.address.city);
        System.out.println(clonedPerson.name + " lives in " + clonedPerson.address.city);

    }
}
