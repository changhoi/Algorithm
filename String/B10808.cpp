#include <iostream>
#include <vector>
#include <string>

/* Baekjoon 10808�� ����
 * ���ĺ� ����
 */
using namespace std;

int main() {
	vector<int> vec(26, 0);
	string words;

	cin >> words;
	for (int i : words) {
		vec[i - (int)'a']++;
	}
	for (int i : vec) {
		cout << i << " ";
	}
	return 0;
}