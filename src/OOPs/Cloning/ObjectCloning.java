package OOPs.Cloning;

import java.util.ArrayList;
import java.util.List;

// Example 1
class Book implements Cloneable{
    String title;
    String author;

    Book(String title, String author){
        this.title = title;
        this.author = author;
    }

    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

class Library implements Cloneable{
    String name;
    List<Book> book;

    Library(String name) {
        this.name = name;
        book = new ArrayList<>();
    }

    public Library shallowClone() throws CloneNotSupportedException {
        return (Library) super.clone();
    }
    public Library deepClone() throws CloneNotSupportedException {
        Library clonedLib = (Library) super.clone();
        List<Book> cloneBook = new ArrayList<>();
        for(int i = 0; i < book.size(); i++){
            cloneBook.add((Book)book.get(i).clone());
        }
        clonedLib.book = cloneBook;
        return clonedLib;
    }
    public void display() {
        int len = book.size();
        for(int i = 0; i < len; i++){
            System.out.print(book.get(i).title + " ");
        }
        System.out.println('\n');
    }
    public void addBook(Book newBook) {
        book.add(newBook);
    }

    @Override
    public Library clone() throws CloneNotSupportedException {
        return (Library) super.clone();
    }
}



// Example 2
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
