#include <iostream>

using namespace std; 

/* Baekjoon 11726¹ø ¹®Á¦
 * DP: Top-down
 */

int sol(int d[], int N) {
	if (d[N]) return d[N];
	if (N <= 1) return 1;
	d[N] = (sol(d, N - 1) + sol(d, N - 2)) % 10007;
	return d[N];
}

int main() {
	int N;
	cin >> N;
	int* d = new int[N + 1]{ 0, };
	cout << sol(d, N) << "\n";

	return 0;
}