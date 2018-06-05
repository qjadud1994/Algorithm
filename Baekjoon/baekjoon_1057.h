#include <iostream>
using namespace std;

int next_round(int a) {
	if (a % 2 == 0) return a / 2;
	return a / 2 + 1;
}

int main() {
	int N, a, b;
	cin >> N >> a >> b;

	int round = 0;
	while (a != b) {
		a = next_round(a);
		b = next_round(b);
		round++;
	}
	cout << round;

	return 0;
}