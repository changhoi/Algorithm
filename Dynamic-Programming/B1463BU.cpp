#include <iostream>

using namespace std;

/* Baekjoon 1463번 문제
 * DP: Bottom-Up (Top-down보다 메모리도 효율적, 시간도 4배 빨랐음)
 */

int sol(int d[], int  N) {
	for (int i = 2; i <= N; i++) {
		d[i] = d[i - 1] + 1;
		if (i % 2 == 0 && d[i] > d[i/2] + 1) {
			d[i] = d[i / 2] + 1;
		}
		if (i % 3 == 0 && d[i] > d[i / 3] + 1) {
			d[i] = d[i / 3] + 1;
		}
	}
	return d[N];
}

int main() {
	int N;
	cin >> N;

	int* d = new int[N + 1]{ 0, };
	d[1] = 0;
	cout << sol(d, N) << "\n";

	return 0;
}