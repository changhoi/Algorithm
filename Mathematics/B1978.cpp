#include <iostream>

using namespace std;

bool isPrime(int num);

int main() {
	int count = 0;
	int T = 0;
	cin >> T;

	while (T--) {
		int num;
		cin >> num;
		if (isPrime(num)) count++;
	}
	cout << count;
	return 0;
}

bool isPrime(int num) {
	if (num < 2) return false;
	for (int i = 2; i * i <= num; i++) {
		if (num % i == 0) return false;
	}
	return true;
}