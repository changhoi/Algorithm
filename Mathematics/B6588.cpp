#include <iostream>
using namespace std;

/**
* Baekjoon 6588�� ����
* �������� ����
* �� �ð��ʰ��� ��� ��
*/

// �����佺�׳׽� ä -> N = Ȧ�� �Ҽ� + Ȧ�� �Ҽ�
// N���� ���� Ȧ�� �Ҽ� �߿� isPrime(N - Ȧ�� �Ҽ�)�� �����ϸ� ���� ����

const int MAX = 1000000;
bool isNotPrime[MAX]; // true�̸� �Ҽ� �ƴ�, false�̸� �Ҽ�
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