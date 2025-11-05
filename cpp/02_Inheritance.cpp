#include <iostream>
using namespace std;

class Person {
public:
    string name;
    int age;
    Person(string n, int a) : name(n), age(a) {}
};

class Student : public Person {
public:
    int rollNo;
    string course;
    Student(string n, int a, int r, string c) : Person(n, a), rollNo(r), course(c) {}
};

class Exam : public Student {
public:
    int marks1, marks2, marks3;

    Exam(string n, int a, int r, string c, int m1, int m2, int m3) 
        : Student(n, a, r, c), marks1(m1), marks2(m2), marks3(m3) {}

    void displayResults() {
        int total = marks1 + marks2 + marks3;
        double avg = total / 3.0;
        cout << "Name: " << name << ", Age: " << age << "\n";
        cout << "Roll No: " << rollNo << ", Course: " << course << "\n";
        cout << "Total Marks: " << total << ", Average: " << avg << "\n";
    }
};

int main() {
    Exam e("Mohit", 20, 404, "Data Science", 85, 90, 88);
    e.displayResults();
    return 0;
}
