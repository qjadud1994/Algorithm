#include <iostream>
#include <cmath>
using namespace std;

int main() {
	int N, r, c, size;
	cin >> N >> r >> c;

	int result = 0;
	int x = pow(2, N - 1);
	int y = x;
	for (int i = N; i >= 2; i--) {
		int size = pow(2, i - 1);
		if (r - x < 0) {	//up
			if (c - y < 0) { x -= size / 2; y -= size / 2; }		//left
			else { result += 1 * size * size; x -= size / 2; y += size / 2; }	//right
		}
		else {				//bottom
			if (c - y < 0) { result += 2 * size * size; x += size / 2; y -= size / 2; }	//left
			else { result += 3 * size * size; x += size / 2; y += size / 2; }	//right
		}
	}
	// last 4 pixel
	if (r - x  < 0) {	//up			
		if (c - y >= 0) result += 1;	//right 
	}
	else {				//bottom
		if (c - y < 0) result += 2;		//left
		else result += 3;				//right
	}
	cout << result;
}