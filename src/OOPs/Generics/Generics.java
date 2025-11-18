package OOPs.Generics;

import java.util.ArrayList;
import java.util.List;

class CreateList<T> {
    private List<T> list;

    CreateList(){
         list = new ArrayList<>();
    }

    public void addItem(T val) {
        list.add(val);
    }

    public T getItem(int index) {
        return list.get(index);
    }

    public void print(){
        for(T value : list) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    public void displayType() {
        T obj = list.getFirst();
        System.out.println(obj.getClass().getName());
    }
}

class GenericMethodExample {
    // Generic method with T data type
    public <T> void print(T data) {
        System.out.println("Data: " + data);
    }
}


class NumericBox<T extends Number> {
    private T num;
    public NumericBox(T num) {
        this.num = num;
    }

    public double square() {
        return num.doubleValue() * num.doubleValue();
    }
}

// `? extends T` allows read but restricts write
class UpperBoundExample {
    public static void printList(List<? extends Number> list) { // Accepts Number and its subtypes
        for (Number num : list) {
            System.out.print(num + " "); // Reading is allowed
        }
        System.out.println("");

        // list.add(10); // Compilation error: Cannot add elements to a list of `? extends Number`
    }
}

// `? super T` allows write access but restricts reading
class LowerBoundExample {
    public static void addNumbers(List<? super Integer> list) { // Accepts Integer and its supertypes
        list.add(10); // Allowed
        list.add(20);

        // Reading AND Storing is not Allowed
        // Integer num = list.get(0); // Error: Cannot guarantee it’s an Integer

        System.out.println(list);
    }
}

public class Generics {
    public static void main(String[] args) {
        CreateList<Integer> ls = new CreateList<>();
        ls.addItem(5);
        ls.addItem(2);
        ls.addItem(98);
        ls.print();

        GenericMethodExample obj = new GenericMethodExample();
        obj.print(100);
        obj.print("Generics");
        obj.print(3.14);

        List<Number> list = new ArrayList<>();
        list.add(2.3);
        LowerBoundExample.addNumbers(list);
    }
}
