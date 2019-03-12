#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

void print(vector<int> &a) {
	for (int x : a) {
		cout << x << ' ';
	}
	cout << "\n";
}

int main() {
	int N, value;
	vector<int> arr;
	cin >> N;
	while (N--) {
		cin >> value;
		arr.push_back(value);
	}
	auto minMax = minmax_element(arr.begin(), arr.end());
	cout << *minMax.first << ' ' << *minMax.second << "\n";
}