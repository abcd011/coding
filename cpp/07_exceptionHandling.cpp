#include <iostream>
using namespace std;

int main() {
    double a, b;
    cout << "Enter two numbers: ";
    cin >> a >> b;
    try {
        // Check for invalid input (cin fails if user enters non-numeric data)
        if (!cin) {
            throw "Invalid input! Please enter numeric values.";
        }
        // Check for division by zero
        if (b == 0) {
            throw "Division by zero not allowed!";
        }
        cout << "Result: " << a / b << "\n";
    }
    catch (const char* msg) {
        cout << msg << "\n";
    }
    return 0;
}
