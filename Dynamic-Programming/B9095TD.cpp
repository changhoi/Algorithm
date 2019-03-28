#include <iostream>

using namespace std;

/**
 * Baekjoon 9095¹ø ¹®Á¦
 * DP: Top-down
 */

int sol(int d[], int N) {
	if (d[N]) return d[N];
	d[N] = sol(d, N - 1) + sol(d, N - 2) + sol(d, N - 3);
	return d[N];
}

int main() {
	int T;
	int N;
	cin >> T;

	while (T--) {
		cin >> N;
		int* d = new int[N + 1]{ 0, };
		d[1] = 1;
		d[2] = 2;
		d[3] = 4;
		cout << sol(d, N) << "\n";
	}

	return 0;
}