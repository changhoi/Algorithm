#include <iostream>

using namespace std;

/* 
 * Baekjoon 1463¹ø ¹®Á¦
 * DP - Top-Down
 */


int sol(int d[], int N) {
	if (N == 1) return 0;
	if (d[N]) return d[N];
	else {
		d[N] = sol(d, N - 1) + 1;
		if (N % 2 == 0 && d[N] > d[N / 2] + 1) {
			d[N] = d[N / 2] + 1;
		}
		if (N % 3 == 0 && d[N] > d[N / 3] + 1) {
			d[N] = d[N / 3] + 1;
		}
		return d[N];
	}
}

int main() {
	int N;
	cin >> N;
	int* d = new int[N + 1]{ 0, };

	cout << sol(d, N);
	return 0;
}