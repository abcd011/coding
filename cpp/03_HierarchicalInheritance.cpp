#include <iostream>
using namespace std;

class Employee {
public:
    int empId;
    string name;
    Employee(int id, string n) : empId(id), name(n) {}
};

class Department {
public:
    string deptName;
    string location;
    Department(string d, string l) : deptName(d), location(l) {}
};

class Salary : public Employee, public Department {
public:
    double basic, hra, da;
    Salary(int id, string n, string d, string l, double b, double h, double a)
        : Employee(id, n), Department(d, l), basic(b), hra(h), da(a) {}

    void display() {
        cout << "Employee ID: " << empId << ", Name: " << name << "\n";
        cout << "Department: " << deptName << ", Location: " << location << "\n";
        cout << "Total Salary: " << (basic + hra + da) << "\n";
    }
};

int main() {
    Salary s(101, "John", "Sales", "NY", 5000, 1500, 1000);
    s.display();
    return 0;
}
