class Person {
    protected String name;
    protected int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

class Employee extends Person {
    protected int empId;
    protected double salary;

    public Employee(String name, int age, int empId, double salary) {
        super(name, age); 
        this.empId = empId;
        this.salary = salary;
    }
}

class Manager extends Employee {
    private String department;

    public Manager(String name, int age, int empId, double salary, String department) {
        super(name, age, empId, salary);  // Call Employee constructor
        this.department = department;
    }

    public void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Employee ID: " + empId);
        System.out.println("Salary: " + salary);
        System.out.println("Department: " + department);
    }

    public static void main(String[] args) {
        Manager m1 = new Manager("Naman", 40, 131, 87465.56, "Tech");
        m1.displayDetails();
    }
}
