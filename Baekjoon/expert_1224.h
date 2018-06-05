#include <string>
#include <iostream>
#include <set>
using namespace std;

set<string> K[11];
int result;

string swap(string n, int i, int j) {
	string result = n;
	char temp = result[i];
	result[i] = result[j];
	result[j] = temp;
	return result;
}

void solution(string n, int c, int count) {
	if (c == count) {
		int len = atoi(n.c_str());
		if (result < len) result = len;
	}
	else {
		int max = n.length();
		for (int i = 0; i < max; i++) {
			for (int j = i + 1; j < max; j++) {
				string str = swap(n, i, j);
				if (K[count + 1].find(str) == K[count + 1].end()) {
					K[count + 1].insert(str);
					solution(str, c, count + 1);
				}
			}
		}
	}
}

int main(void) {
	int T, c;
	cin >> T;
	string n;
	for (int i = 1; i <= T; i++) {
		for (int j = 0; j < 11; j++) K[j].clear();
		result = 0;
		cin >> n >> c;
		solution(n, c, 0);
		cout << "#" << i << " " << result << "\n";
	}

	return 0;
}