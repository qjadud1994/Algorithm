#include <iostream>
#include <stack>
#include <string>
using namespace std;

bool check(string a) {
	stack<char> st;
	for (int i = 0; i < a.length(); i++) {
		if (a[i] == '(') st.push('(');
		else {
			if (st.empty()) return false;
			st.pop();
		}
	}
	if (st.empty()) return true;
	return false;
}

int main(void) {
	int T;
	cin >> T;
	string a;
	for (int i = 0; i < T; i++) {
		cin >> a;
		if (check(a)) cout << "YES" << endl;
		else cout << "NO" << endl;
	}
	return 0;
}