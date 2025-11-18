import java.util.ArrayList;
import java.util.List;

class OuterClass {
    static int val = 10;
    String name = "Nand";

    class InnerClass {
        public void execute(){
            System.out.println("Inner class executed... " + val);
        }
    }
}

interface Sample {
    public void execute();
}


public class Main {
    public static void main(String[] args) {
//        OuterClass oc = new OuterClass();
//
//        OuterClass.InnerClass ic = oc.new InnerClass();
//        ic.execute();


        Sample sample = new Sample() {
            @Override
            public void execute() {
                System.out.println("Anonymous Inner class");
            }
        };
        sample.execute();


    }
}