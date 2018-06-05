#include <iostream>
using namespace std;

int main() {
	int sugar, three, five, rest;
	cin >> sugar;

	five = sugar / 5;
	while (five >= 0) {
		rest = sugar - (five * 5);
		if (rest % 3 == 0) {
			three = rest / 3;
			break;
		}
		five--;
	}
	if (five == -1) cout << -1;
	else cout << three + five;
}

