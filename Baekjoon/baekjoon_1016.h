#include <iostream>
#include <cmath>
using namespace std;
// 2부터 sqrt(max) 까지 모든 제곱수에 대해 반복
// pow는 max보다 작은 제곱수이며, temp는 min보다 큰 pow의 배수를 의미한다.
// 중복 제거를 위해 bool 배열을 이용한다.
// 안쪽 for문을 이용해 temp보다 큰 pow의 배수에 해당하는 값 위치의 bool 배열을 true로 바꾸어준다.
// 마지막으로 bool 배열을 scan하여 true인 인덱스의 개수를 count한다.
int main() {
	long long min, max, temp, pow;
	cin >> min >> max;

	bool *reg = new bool[max - min + 1];

	for (long long i = 2; i*i <= max; i++) {
		pow = i*i;
		temp = ((min - 1) / pow + 1) * pow;
		for (; temp <= max; temp += pow) {
			reg[temp - min] = true;
		}
	}
	long long count = 0;
	for (long long i = min; i <= max; i++) {
		if (reg[i - min] == true) count++;
	}
	cout << max - min + 1 - count;

	return 0;
}