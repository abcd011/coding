// Operator operloading 
#include <iostream>
using namespace std;


class Complex{
    private:
    int x, y;

    public:
    Complex(){
        x = 0;
        y = 0;
    }

    Complex(int a, int b){
        cout << "Constructor was called with " << endl;
        x = a;
        y = b;
    }

    void display(){
        cout << "x: " << x << endl;
        cout << "y: " << y << endl;
    }

    Complex operator+(Complex c){
        Complex temp;
        temp.x = x + c.x;
        temp.y = y + c.y;
        return temp;
    }

    ~Complex(){
        cout << "Destructor was called" << endl;
    }
};

int main(){
    Complex c1(5, 2);
    c1.display();
    Complex c2(8, 3);
    c2.display();
    Complex c3 = c1 + c2;
    c3.display();
}