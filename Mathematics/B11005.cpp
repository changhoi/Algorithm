#include <iostream>
#include <deque>
using namespace std;

int main() {
	int N, B;
	cin >> N >> B;
	deque<int> arr;
	while (N > 0) {
		arr.push_front(N % B);
		N /= B;
	}
	for (int i : arr) {
		if (i >= 10) {
			cout << char(i + 55);
		}
		else {
			cout << i;
		}
	}
	cout << "\n";

	return 0;
}