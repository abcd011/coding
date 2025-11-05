import java.util.*;

class Student {
    String name;
    int rollNo;

    public Student(String name, int rollNo) {
        this.name = name;
        this.rollNo = rollNo;
    }

    public String toString() {
        return "Roll No: " + rollNo + ", Name: " + name;
    }
}

public class CollectionDemo {
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student("Raman", 11));
        students.add(new Student("Rohit", 49));
        students.add(new Student("Rocky", 33));
        students.add(new Student("Rohit", 24)); 

        System.out.println("Students in ArrayList:");
        for (Student s : students) {
            System.out.println(s + ", ");
        }
        HashSet<String> nameSet = new HashSet<>();
        for (Student s : students) {
            nameSet.add(s.name);
        }
        System.out.print("\nUnique student names: ");
        for (String name : nameSet) {
            System.out.print(name + ", ");
        }
        HashMap<Integer, String> rollNameMap = new HashMap<>();
        for (Student s : students) {
            rollNameMap.put(s.rollNo, s.name);
        }

        System.out.println("\nRoll No and Names from HashMap:");
        Iterator<Map.Entry<Integer, String>> it = rollNameMap.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Integer, String> entry = it.next();
            System.out.println("Roll No: " + entry.getKey() + ", Name: " + entry.getValue());
        }
        students.sort(Comparator.comparing(s -> s.name));
        System.out.println("\nStudents sorted by name:");
        for (Student s : students) {
            System.out.println(s);
        }
    }
}
