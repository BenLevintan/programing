#include <iostream>
#include <cmath>
#include <string>

using namespace std;

void temp();


int main() {
    int file_size;    // Snake case
    int FileSize;     // Pascal case
    int filesize;     // Camel case
    int iFileSize;    // Hungarian notation (i for int)

    // String manipulation in main

    int luckyNums[] = {1,2,3,4,5};

    cout << luckyNums[1];

    //temp();

    return 0;
}

void temp() {
    cout << "Enter a temperature in Fahrenheit: ";
    double f_temp;
    cin >> f_temp;
    cout << "The temperature in Celsius is: " << (f_temp - 32.0) / 1.8 << endl;
}