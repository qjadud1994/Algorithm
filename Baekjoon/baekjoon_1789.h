#include <iostream>
using namespace std;

int main() {
	long long S;
	cin >> S;

	int N = 0;
	long long temp = 0;
	while (temp <= S) {
		N++;
		temp += N;
	}
	cout << N - 1;

	return 0;
}