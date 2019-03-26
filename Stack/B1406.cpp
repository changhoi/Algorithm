#include <iostream>
#include <stack>
#include <string>

using namespace std;

/*
 * Baekjoon 1406번 문제 
 * L: 커서 왼쪽으로
 * D: 커서 오른쪽으로
 * B: 커서 왼쪽 글자 삭제
 * P$: $라는 문자를 커서 왼쪽에 추가

 * 커서 기준으로 왼쪽 스택, 오른쪽 스택 사용
 */


void print(stack<char> left, stack<char> right) {
	int leftLength = left.size();
	int rightLength = right.size();
	int all = leftLength + rightLength;
	while(!left.empty()){
		right.push(left.top());
		left.pop();
	}
	while (!right.empty()) {
		cout << right.top();
		right.pop();
	}
	cout << "\n";
}

int main() {
	char cmd;
	stack<char> left;
	stack<char> right;
	string str;
	int N;
	
	cin >> str;
	cin >> N;
	int j = 0;
	for (int i = str.length(); j < i; j++)
		left.push(str.at(j));
	
	while (N--) {
		cin >> cmd;
		if (cmd == 'P') {
			// 입력
			char insert;
			cin >> insert;
			left.push(insert);
		}
		else if (cmd == 'L' && !left.empty()) {
			// 커서 왼쪽 이동
			char letter = left.top();
			left.pop();
			right.push(letter);
		}
		else if (cmd == 'D' && !right.empty()) {
			// 커서 오른쪽 이동
			char letter = right.top();
			right.pop();
			left.push(letter);
		}
		else if (cmd == 'B' && !left.empty()) {
			// 커서 왼쪽 삭제
			left.pop();
		}
	}

	print(left, right);
	return 0;
}