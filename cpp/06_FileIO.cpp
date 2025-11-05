#include <iostream>
#include <fstream>
#include <string>
using namespace std;

void writeData() {
    ofstream fout("student.txt"); 
    int roll;
    string name;
    float marks;

    cout << "Enter roll no, name, marks:\n";
    cin >> roll >> ws;
    getline(cin, name);
    cin >> marks;

    fout << roll << " " << name << " " << marks << "\n";
    fout.close();
}

void readData() {
    ifstream fin("student.txt");
    int roll;
    string name;
    float marks;

    cout << "\nStudent Records:\n";
    while (fin >> roll) {
        fin >> ws;
        getline(fin, name);
        fin >> marks;
        cout << roll << " " << name << " " << marks << "\n";
    }
    fin.close();
}

int main() {
    writeData();
    readData();
    return 0;
}
