#include <iostream>
using namespace std;

int get10(int num) {
	if (num < 10) {
		return 0;
	}
	return num / 10;
}
int get1(int num) {
	return num % 10;
}

int main() {
	int num, one;
	cin >> num;
	int cur = num, cycle = 0;
	do {
		one = get1(cur);
		cur = one * 10 + get1(get10(cur) + one);
		cycle++;
	} while (num != cur);
	cout << cycle;
	return 0;
}

