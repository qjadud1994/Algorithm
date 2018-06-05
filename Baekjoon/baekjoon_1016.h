#include <iostream>
#include <cmath>
using namespace std;
// 2���� sqrt(max) ���� ��� �������� ���� �ݺ�
// pow�� max���� ���� �������̸�, temp�� min���� ū pow�� ����� �ǹ��Ѵ�.
// �ߺ� ���Ÿ� ���� bool �迭�� �̿��Ѵ�.
// ���� for���� �̿��� temp���� ū pow�� ����� �ش��ϴ� �� ��ġ�� bool �迭�� true�� �ٲپ��ش�.
// ���������� bool �迭�� scan�Ͽ� true�� �ε����� ������ count�Ѵ�.
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