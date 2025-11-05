#include <iostream>
#include <string>
using namespace std;

class BankAccount {
    string accNumber, name;
    double balance;

public:
    BankAccount(string acc, string nm, double bal) : accNumber(acc), name(nm), balance(bal) {}

    void deposit(double amt) {
        if (amt > 0) balance += amt;
    }

    bool withdraw(double amt) {
        if (amt > 0 && balance - amt >= 1000) { 
            balance -= amt; 
            return true; 
        }
        return false;
    }

    void display() const {
        cout << "Account: " << accNumber << ", Name: " << name << ", Balance: " << balance << '\n';
    }
};

int main() {
    BankAccount b1("2403", "Hitesh", 2000);
    b1.deposit(500);
    b1.withdraw(800);
    b1.display();
    return 0;
}
