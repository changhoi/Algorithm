#include <iostream>
#include <string>

using namespace std;

int main() {
	string N;
	int B;
	cin >> N >> B;
	int len = N.length();
	int sum = 0;
	for (char i : N) {
		if ('0' <= i && i <= '9') {
			sum = sum * B + (i - '0');
		}
		else {
			sum = sum * B + (i - 'A' + 10);
		}
	}

	cout << sum << "\n";
	
}