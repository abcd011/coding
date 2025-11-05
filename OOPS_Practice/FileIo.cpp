#include <iostream>
#include <fstream>
using namespace std;
#include <string>

int main(){
    string fileName = "spiderman.txt";
    ofstream fout(fileName, ios::app);
    string name;
    cout << "Enter your name: ";
    getline(cin, name);
    fout << name << endl;
    fout.close();

    string x;
    ifstream fin(fileName);
    while (getline(fin, x))
    {
        cout << x << endl;
    }
    fin.close();

}