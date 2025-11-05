#include <iostream>
using namespace std;

double area(double radius) { return 3.14 * radius * radius; }
double area(double length, double breadth) { return length * breadth; }
double area(double base, double height, int) { return 0.5 * base * height; }

class Shape {
public:
    virtual void displayArea() = 0; 
};

class Circle : public Shape {
    double radius;
public:
    Circle(double r) : radius(r) {}
    void displayArea() override {
        cout << "Circle area: " << area(radius) << endl;
    }
};

class Rectangle : public Shape {
    double length, breadth;
public:
    Rectangle(double l, double b) : length(l), breadth(b) {}
    void displayArea() override {
        cout << "Rectangle area: " << area(length, breadth) << endl;
    }
};

int main() {
    cout << "Overloaded areas:\n";
    cout << "Circle: " << area(5) << "\nRectangle: " << area(4, 6) << "\nTriangle: " << area(4, 5, 1) << endl;

    Shape* s1 = new Circle(3);
    Shape* s2 = new Rectangle(5, 7);

    cout << "Runtime polymorphism:\n";
    s1->displayArea();
    s2->displayArea();

    delete s1; delete s2;
    return 0;
}
