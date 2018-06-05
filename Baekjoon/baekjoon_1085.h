#include <iostream>
using namespace std;

int getmin(int a, int b) {
	if (a < b) return a;
	return b;
}
int main() {
	int x, y, w, h;
	cin >> x; cin >> y; cin >> w; cin >> h;

	int result = getmin(getmin(x, y), getmin(w - x, h - y));
	cout << result;
}

