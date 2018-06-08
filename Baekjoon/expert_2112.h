#include <stdio.h>

int D, W, K;
short film[14][21];					// ���� film �迭
short film_val[14][21];				// �񱳸� ���� ���ϴ� film �迭
bool end;

void change_line(int d, short flag) {		// � line�� ���Ҹ� ��� flag(0 or 1)�� �ٲٴ� �Լ�
	int j;
	for (j = 0; j < W; j++) film_val[d][j] = flag;
}

void reset_line(int d) {					// � line�� ���Ҹ� ������� �����ϴ� �Լ�
	int j;
	for (j = 0; j < W; j++) film_val[d][j] = film[d][j];
}

bool is_possible() {						// ���� film_val �� ������ �����ϴ��� Ȯ��
	int i, j, count;
	for (j = 0; j < W; j++) {
		count = 1;							// ���� ���Һ��� count�ϹǷ� 1���� ����
		for (i = 1; i < D && count < K; i++) {					//���ӵǴ� ������ ��(count)�� K �̻��� �� ����
			if (film_val[i][j] == film_val[i - 1][j]) count++;	//���ӵǸ� count����
			else count = 1;										//�ƴ϶�� count ó������
		}
		if (count != K) return false;		// count�� K�� �ƴ϶�� �ҿ����̹Ƿ� �Ұ����� �迭 -> return false
	}
	return true;
}

void recursive(int k, int count, int start) {	// k�� �� ��� ���� ����ϱ� ���� ��� �Լ�
	if (end) return;							// �����ϴ� ������ ã������ ������
	if (count == k) {							// k���� ������ ����������
		if (is_possible()) end = true;			// �ش� ������ ������ �����ϴ��� Ȯ��
		return;
	}
	for (int i = start; i < D; i++) {
		change_line(i, 0);						//�ش� line�� ��� 0 (A)���� �ٲٱ�
		recursive(k, count + 1, i + 1);			//���� ���� Ž��
		reset_line(i);							//Ž�� �� line�� ���Ҹ� ������� ����

		change_line(i, 1);						//�ش� line�� ��� 1 (B)���� �ٲٱ�
		recursive(k, count + 1, i + 1);			//���� ���� Ž��
		reset_line(i);							//Ž�� �� line�� ���Ҹ� ������� ����
	}
}

int main()
{
	int T;
	scanf("%d", &T);
	short check[14];

	int t, i, j, max;
	for (t = 1; t <= T; t++) {
		scanf("%d %d %d", &D, &W, &K);
		for (i = 0; i < D; i++) {
			for (j = 0; j < W; j++) {
				scanf("%hd", &film[i][j]);
				film_val[i][j] = film[i][j];
			}
		}
		end = false;
		for (i = 0; i < D; i++) {		// k�� 0���� D���� ��� Ȯ��
			recursive(i, 0, 0);
			if (end) {
				printf("#%d %d\n", t, i); break;	// �����ϸ� ����
			}
		}
	}
}