#include <iostream>
using namespace std;

/**
* Baekjoon 6588번 문제
* 골드바흐의 추측
* 뭔 시간초과가 계속 뜸
*/

// 에라토스테네스 채 -> N = 홀수 소수 + 홀수 소수
// N보다 작은 홀수 소수 중에 isPrime(N - 홀수 소수)이 성립하면 추측 성립

const int MAX = 1000000;
bool isNotPrime[MAX]; // true이면 소수 아님, false이면 소수
int numberOfPrime = 0;
int prime[MAX];

int main() {
	isNotPrime[0] = isNotPrime[1] = true;

	for (int i = 2; i < MAX; i++) {
		if (isNotPrime[i] == false) {
			prime[numberOfPrime] = i;
			numberOfPrime++;
			for (int j = i * 2; j <= MAX; j += i) {
				if(isNotPrime[j] == false) isNotPrime[j] = true;
			}
		}
	}

	while (true) {
		int T;
		cin >> T;
		if (T == 0) break;
		
		for (int p = 0; p < numberOfPrime; p++) {
			if (isNotPrime[T - prime[p]] == false) {
				cout << T << " = " << prime[p] << " + " << T - prime[p] << "\n";
				break;
			}
		}
	}
	return 0;
}