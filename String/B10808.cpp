#include <iostream>
#include <vector>
#include <string>

/* Baekjoon 10808번 문제
 * 알파벳 개수
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