#include <iostream>
#include <string>
using namespace std;

class Student {
    string name;
    int rollNo;
    float marks;

public:
    Student() {
        name = "Unknown";
        rollNo = 0;
        marks = 0;
        cout << "Default constructor called\n";
    }
    Student(string n, int r, float m) {
        name = n;
        rollNo = r;
        marks = m;
        cout << "Parameterized constructor called\n";
    }
    Student(const Student &s) {
        name = s.name;
        rollNo = s.rollNo;
        marks = s.marks;
        cout << "Copy constructor called\n";
    }

    ~Student() {
        cout << "Destructor called for " << name << "\n";
    }

    void display() {
        cout << "Name: " << name << ", RollNo: " << rollNo << ", Marks: " << marks << "\n";
    }
};

int main() {
    Student s1;
    Student s2("Mohan", 24, 97);
    Student s3 = s2;

    s1.display();
    s2.display();
    s3.display();

    return 0;
}
