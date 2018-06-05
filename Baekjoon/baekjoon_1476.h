#include <iostream>
using namespace std;

void Min(int &a, int &b, int &c) {
	if (a <= b && a <= c) a += 15;
	else if (b <= a && b <= c) b += 28;
	else if (c <= a && c <= b) c += 19;
}
bool check(int a, int b, int c) {
	if (a == b && a == c) return true;
	return false;
}

int main() {
	int E, S, M;
	cin >> E; cin >> S; cin >> M;
	int count = 0;
	while (!check(E, S, M)) {
		Min(E, S, M);
		count++;
	}
	cout << E;
}