#include <iostream>
#include <stack>
#include <string>

using namespace std;

/*
 * Baekjoon 10799 문제
 * '(' 스택을 쌓다가 ')'가 나왔을 때 막대기인지 레이저인지 판단
 * 막대기라면, 막대기가 하나 추가되면서 스택 제거
 * 레이저인 경우에는 조각 수 += 막대기 수
 */

int main() {
	int stick = 0;
	int pieces = 0;
	string parentheses;
	cin >> parentheses;
	int len = parentheses.length();
	for (int i = 0; i < len; i++) {
		if (parentheses.at(i) == '(') {
			stick++;
		}
		else {
			if (parentheses.at(i-1) == '(') {
				// 레이저
				stick--;
				pieces += stick;
				
			}
			else {
				// 막대기 끝
				stick--;
				pieces++;
			}
		}
	};
	cout << pieces << "\n";
	return 0;
}