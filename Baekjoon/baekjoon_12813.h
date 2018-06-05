#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>

#include <iostream>
#include <bitset>
//#include <string>
using namespace std;

int main(void) {
	bitset<10> A, B;
	cin >> A >> B;

	cout << (A & B) << endl;
	cout << (A | B) << endl;
	cout << (A ^ B) << endl;
	cout << (~A) << endl;
	cout << (~B) << endl;
	return 0;
}
