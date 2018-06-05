#include <iostream>
using namespace std;

int main() {
	int N; cin >> N;

	int five = 0;
	for (int i = 5; N >= i; i *= 5) {
		five += N / i;
	}
	cout << five;
}