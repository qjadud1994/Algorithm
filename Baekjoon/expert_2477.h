#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <queue>
using namespace std;

short reception[10], repair[10];
short visitor[1001];

typedef struct person {
	int rec = 0, rep = 0;
}Person;

int solution(int N, int M, int K, int A, int B) {
	int i, j, k, wait_first;
	short rec[10], rep[10];
	short rec_visit[10], rep_visit[10];
	for (i = 1; i < 10; i++) {
		rec[i] = rep[i] = 0;
	}

	queue<int> wait;
	bool rec_full = false, rep_full = false;
	short time = visitor[1];
	int person = 1;
	Person *p = new Person[K + 1];

	int result = 0, num = 0;

	while (K > num) {
		//printf("\ntime : %d\n", time);
		for (k = 1; k <= M; k++) {		//���� â���� ����
			if (rep[k] != 0) {
				rep[k]--;
			}
		}

		k = 1;
		while (!wait.empty()) {			// ���� â�� ��ٸ��� �����
			wait_first = wait.front();
			rep_full = true;
			j = k;
			for (k = j; k <= M; k++) {			// ������ ���� â�� Ž��
				if (rep[k] == 0) {
					rep[k] = repair[k];			// ���� â�� count ����
					rep_visit[k] = wait_first;	// ���� â�� �湮�� ������Ʈ
					p[wait_first].rep = k;
					//printf("repair %d <- reception %d <- visitor %d\n", k, p[wait_first].rec, wait_first);
					rep_full = false;
					wait.pop();
					num++;				// ���� ���� �� �� ����
					break;
				}
			}
			if (rep_full) break;
		}

		rep_full = false;
		k = 1;
		for (j = 1; j <= N; j++) {					// ���� â���� ���� 
			if (rec[j] != 0) {						// ���� ���� â�����
				rec[j]--;							// ���� count ����
				if (rec[j] == 0) {						// ������ ��������
					if (rep_full) {						// �̹� �� á���� ��� ��ܿ� �߰�
						wait.push(rec_visit[j]);
						continue;
					}
					rep_full = true;
					i = k;
					for (k = i; k <= M; k++) {		// ���� â���� �̵�
						if (rep[k] == 0) {			// ���� â���� ����ٸ�
							rep[k] = repair[k];			// ���� â�� count ����
							rep_visit[k] = rec_visit[j];	// ���� â�� �湮�� ������Ʈ
							p[rec_visit[j]].rep = k;
							//printf("repair %d <- reception %d <- visitor %d\n", k, j, rec_visit[j]);
							rep_full = false;
							num++;				// ���� ���� �� �� ����
							break;
						}
					}
					if (rep_full) wait.push(rec_visit[j]);		//�� á���� ��� ��ܿ� �߰�
				}
			}
		}

		j = 1;
		for (i = person; i <= K; i++) {			// ��� ��� ���� â�� �����ϱ�
			rec_full = true;
			if (visitor[i] > time) break;		// ����ð� �մ� ���� ��
			k = j;
			for (j = k; j <= N; j++) {			// ���� â�� scan
				if (rec[j] == 0) {				// ����ִٸ�
					rec[j] = reception[j];	// ���� �ð� count ����
					p[i].rec = j;
					rec_visit[j] = i;			// �������� �մ� ��ȣ ����
												//printf("recption %d <- visitor %d\n", j, i);
					rec_full = false;
					break;
				}
			}
			if (rec_full) break;		// �� á���� �׸�
		}

		person = i;
		time++;
	}
	for (i = 1; i <= K; i++) {
		if (p[i].rec == A && p[i].rep == B) {	// ���� ������ Ȯ��
			result += i;
		}
	}
	return result == 0 ? -1 : result;
}

int main() {
	int T, N, M, K, A, B;
	int t, j;

	scanf("%d", &T);

	for (t = 1; t <= T; t++) {
		scanf("%d %d %d %d %d", &N, &M, &K, &A, &B);
		for (j = 1; j <= N; j++) scanf("%hd", &reception[j]);
		for (j = 1; j <= M; j++) scanf("%hd", &repair[j]);
		for (j = 1; j <= K; j++) scanf("%hd", &visitor[j]);

		printf("#%d %d\n", t, solution(N, M, K, A, B));
	}
}