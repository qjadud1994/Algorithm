#include <iostream>
#include <string.h>
#include <stdlib.h>
#include <stdio.h>
using namespace std;

int main() {
	char A[10], B[10];
	cin >> A >> B;

	for (int i = 0; i < strlen(A); i++) {
		if (A[i] == '6') A[i] = '5';
	}
	for (int i = 0; i < strlen(B); i++) {
		if (B[i] == '6') B[i] = '5';
	}
	cout << atoi(A) + atoi(B) << " ";

	for (int i = 0; i < strlen(A); i++) {
		if (A[i] == '5') A[i] = '6';
	}
	for (int i = 0; i < strlen(B); i++) {
		if (B[i] == '5') B[i] = '6';
	}
	cout << atoi(A) + atoi(B) << " ";

	return 0;
}