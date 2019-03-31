#include <iostream>
using namespace std;

int gcd(int a, int b) {
	while (b != 0) {
		int temp = a;
		a = b;
		b = temp % b;
	}
	return a;
}

int main() {
	int T;
	cin >> T;
	int a, b;
	while (T--) {
		cin >> a >> b;
		int g = gcd(a, b);
		cout << g * (a / g) * (b / g) << "\n";
	}

	return 0;
}