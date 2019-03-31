# include <iostream>

using namespace std;


int gcd(int a, int b) {
	if (b == 0) return a;
	return gcd(b, a % b);
}


int main() {
	int T;
	cin >> T;
	int arr[111];
	while (T--) {
		int N;
		cin >> N;
		for (int i = 0; i < N; i++) {
			cin >> arr[i];
		}
		long long sum = 0;
		for (int i = 0; i < N - 1; i++) {
			for (int j = i + 1; j < N; j++) {
				sum += gcd(arr[i], arr[j]);
			}
		}
		cout << sum << "\n";
	}

	return 0;
}