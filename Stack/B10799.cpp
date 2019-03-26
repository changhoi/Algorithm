#include <iostream>
#include <stack>
#include <string>

using namespace std;

/*
 * Baekjoon 10799 ����
 * '(' ������ �״ٰ� ')'�� ������ �� ��������� ���������� �Ǵ�
 * �������, ����Ⱑ �ϳ� �߰��Ǹ鼭 ���� ����
 * �������� ��쿡�� ���� �� += ����� ��
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
				// ������
				stick--;
				pieces += stick;
				
			}
			else {
				// ����� ��
				stick--;
				pieces++;
			}
		}
	};
	cout << pieces << "\n";
	return 0;
}