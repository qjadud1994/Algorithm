#include <iostream>
using namespace std;

int main() {
	int X, stick = 64, count = 0;
	cin >> X;

	while (X != 0) {
		if (stick > X) {
			stick /= 2;
			if (stick < X) {
				count++;
				X = X - stick;
			}
		}
		else {
			count++;
			X = X - stick;
		}
	}
	cout << count;
}