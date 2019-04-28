#include <iostream>
#include <math.h>
using namespace std;
long long MOD = 1000000000;

// 자리수가 N일때 계단 수의 개수 == d[N]

long long sum(long long* arr) {
	long long result = 0;
	for (int i = 0; i < 10; i++) {
		result += arr[i];
	}
	return result;
}


int main() {
	int N;
	cin >> N;
	long long d[111][11];
	d[1][0] = 0;
	d[1][10] = 0;
	for (int i = 1; i <= 9; i++) d[1][i] = 1;
	
	for (int i = 2; i <= N; i++) {
		for (int j = 0; j <= 9; j++) {
			d[i][j] = 0;
			if (j - 1 >= 0) d[i][j] += d[i - 1][j - 1];
			if (j + 1 <= 9) d[i][j] += d[i - 1][j + 1];
			d[i][j] %= MOD;
		}
	}

	long long answer = sum(d[N]);
	answer %= MOD;
	cout << answer << "\n";

	return 0;
}
