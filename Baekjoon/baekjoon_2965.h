#include <iostream>
using namespace std;

int Max(int a, int b) {
	if (a > b) return a;
	return b;
}
int main() {
	int A, B, C;
	cin >> A; cin >> B; cin >> C;

	cout << Max(C - B, B - A) - 1;
}