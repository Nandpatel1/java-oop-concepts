package OOPs.Associations_Aggregation_Composition;
import java.util.*;

class College {
    private String name;
    private String id;

    public College(String name, String id) {
        this.name = name;
        this.id = id;
    }

    public void displayDetails() {
        System.out.println("College Name : " + name);
        System.out.println("College ID : " + id);
    }
}

class University {
    private String name;
    private List<College> colleges;

    public University(String name) {
        this.name = name;
        this.colleges = new ArrayList<>();
    }

    public void addCollege(String collegeName, String collegeId) {
        colleges.add(new College(collegeName, collegeId));
    }

    public void displayDetails() {
        System.out.println("University Name : " + name);
        for (College college : colleges) {
            college.displayDetails();
        }
    }
}

// Composition : Opposite of Aggregation
//               A class owns another class within it.
//               Strong relationship.
public class Composition {
    public static void main(String[] args) {
        String universityName = "Global_University";
        String[] collegeNames = { "COEP", "PICT", "VJTI", "WCE", "PCCOE" };
        String[] collegeIds = { "CO8543", "PI9514", "VJ8643", "VF569", "PC9246" };

        University university = new University(universityName);

        for (int i = 0; i < collegeNames.length; i++) {
            university.addCollege(collegeNames[i], collegeIds[i]);
        }

        university.displayDetails();
    }
}
