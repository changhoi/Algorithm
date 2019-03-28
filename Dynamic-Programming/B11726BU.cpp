#include <iostream>

using namespace std;

/* Baekjoon 11726
 * DP: Bottom-Up
 */

int sol(int* d, int N) {
	if (d[N] != 0) return d[N];
	for (int i = 3; i <= N; i++) {
		d[i] = d[i - 1] + d[i - 2];
		d[i] %= 10007;
		// (A + B) % C == (A % C) + (B % C)
	}
	return d[N];
}

int main() {
	// d[N] == 2*N 크기 직사각형을 채우는 방법의 수
	// d[0] == 1로 두기? d[1] == 1
	int N;
	cin >> N;
	int* d = new int[N + 1]{ 0, };
	d[0] = 0;
	d[1] = 1;
	d[2] = 2;
	cout << sol(d, N) << "\n";

	return 0;
}