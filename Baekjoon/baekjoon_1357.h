#include <iostream>
using namespace std;

int Rev(int n) {
	int result = 0;
	while (n > 0) {
		result *= 10;
		result += n % 10;
		n = n / 10;
	}
	return result;
}

int main() {
	int X, Y;
	cin >> X >> Y;

	cout << Rev(Rev(X) + Rev(Y));
	return 0;
}