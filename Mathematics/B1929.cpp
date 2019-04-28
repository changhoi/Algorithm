#include <iostream>
using namespace std;

/**
 * Baekjoon 1929����
 * M - N ������ �Ҽ� ã�� ����
 * �����佺�׳׽��� ä
 */

int main() {
	int M, N;
	cin >> M >> N;
	bool * c = new bool[N + 1]{};

	for (int i = 2; i <= N; i++) {
		if (!c[i]) {
			if (i >= M) cout << i << "\n";
			for (int j = i * 2; j <= N; j += i) {
				c[j] = true;
			}
		}
	}

	return 0;
}