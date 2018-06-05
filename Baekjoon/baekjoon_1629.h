#include <iostream>
using namespace std;

//Divide and Conquer
long long pow(long long A, long long B, long long C) {
	if (B == 0) return 1;
	if (B % 2 == 1) return (pow(A, B - 1, C) * A) % C;		// odd
	else return (pow(A, B / 2, C) * pow(A, B / 2, C)) % C;		// even
}

int main() {
	long long A, B, C;
	cin >> A >> B >> C;

	cout << pow(A, B, C);
}