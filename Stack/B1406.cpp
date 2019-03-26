#include <iostream>
#include <stack>
#include <string>

using namespace std;

/*
 * Baekjoon 1406�� ���� 
 * L: Ŀ�� ��������
 * D: Ŀ�� ����������
 * B: Ŀ�� ���� ���� ����
 * P$: $��� ���ڸ� Ŀ�� ���ʿ� �߰�

 * Ŀ�� �������� ���� ����, ������ ���� ���
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
			// �Է�
			char insert;
			cin >> insert;
			left.push(insert);
		}
		else if (cmd == 'L' && !left.empty()) {
			// Ŀ�� ���� �̵�
			char letter = left.top();
			left.pop();
			right.push(letter);
		}
		else if (cmd == 'D' && !right.empty()) {
			// Ŀ�� ������ �̵�
			char letter = right.top();
			right.pop();
			left.push(letter);
		}
		else if (cmd == 'B' && !left.empty()) {
			// Ŀ�� ���� ����
			left.pop();
		}
	}

	print(left, right);
	return 0;
}