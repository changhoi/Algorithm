#include <iostream>

using namespace std;

int gcd(int a, int b) {
	if (b == 0) return a;
	return gcd(b, a%b);
}

int main() {
	int a, b;
	cin >> a >> b;
	int g = gcd(a, b);
	int l = g * (a / g) * (b / g);

	cout << g << "\n";
	cout << l << "\n";

	return 0;
}