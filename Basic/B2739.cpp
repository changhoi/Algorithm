#include <iostream>
using namespace std;

int main() {
	int dan = 0;
	cin >> dan;
	for (int i = 1; i <= 9; i++) {
		cout << dan << " * " << i << " = " << dan * i << "\n";
	}

	return 0;
}