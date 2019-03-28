#include <iostream>

using namespace std;

/* Baekjoon 11727¹ø ¹®Á¦
 * DP: Bottom-up
 */

int sol(int d[], int N) {
	for (int i = 2; i <= N; i++) {
		d[i] = d[i - 1] + 2 * d[i - 2];
		d[i] %= 10007;
	}
	return d[N];
}


int main() {
	int N;
	cin >> N;
	int * d = new int[N + 1]{ 0, };
	d[0] = 1;
	d[1] = 1;
	cout << sol(d, N) << "\n";

	return 0;
}