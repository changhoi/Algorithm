#include <iostream>
#include <deque>
#include <string>
#include <math.h>
using namespace std;

int binToOcto(char* bin) {
	int result = 0;
	for (int i = 2; i >= 0; i--) {
		if (bin[i] == 1) result += int(pow(2, i));
	}
	return result;
}
int main() {
	string s;
	cin >> s;
	int len = s.length();
	if (len % 3 == 1) {
		cout << s[0];
	}
	else if (len % 3 == 2) {
		cout << (s[0] - '0') * 2 + (s[1] - '0');
	}
	for (int i = len % 3; i<len; i += 3) {
		cout << (s[i] - '0') * 4 + (s[i + 1] - '0') * 2 + (s[i + 2] - '0');
	}
	cout << '\n';
	return 0;
}