#include <iostream>
#include <algorithm>
#include <string>
using namespace std;

bool cmp(string a, string b)//bool은 참 거짓  a는 앞데이터 b는 뒤데이터 
{
	if (a.length() == b.length()) return a < b;
	else {
		return a.length() < b.length();
	}
}

int main(void) {
	int n, i;
	cin >> n;

	string str[20001];
	for (i = 0; i < n; i++) cin >> str[i];

	sort(str, str + n, cmp);

	string overlap = "";
	for (i = 0; i < n; i++) {
		if (str[i] == overlap) continue;
		cout << str[i] << endl;
		overlap = str[i];
	}
	return 0;
}
