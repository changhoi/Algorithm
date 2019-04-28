#include <iostream>
using namespace std;

/**
 * Baekjoon 1929문제
 * M - N 까지의 소수 찾기 문제
 * 에라토스테네스의 채
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