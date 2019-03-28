#include <iostream>

using namespace std;

/**
 * Baekjoon 9095¹ø ¹®Á¦
 * DP: Bottom-up
 */

int sol(int* d, int N) {
	d[1] = 1;
	d[2] = 2;
	d[3] = 4;
	for (int i = 4; i <= N; i++) {
		d[i] = d[i - 1] + d[i - 2] + d[i - 3];
	}
	return d[N];
}

int main() {
	int T, N;
	cin >> T;
	while (T--) {
		cin >> N;
		int * d = new int[N + 1]{ 0, };
		cout << sol(d, N) << "\n";
	}

	return 0;
}