#include <iostream>
#include <deque>
#include <string>
using namespace std;

/* Baekjoon 10866 문제
 * 덱 구현하기 문제
 */

int main() {
	deque<int> d;
	string cmd;
	int x, N;
	cin >> N;
	while(N--) {
		cin >> cmd;
		if (cmd == "push_front") {
			cin >> x;
			d.push_front(x);
		}
		else if (cmd == "push_back") {
			cin >> x;
			d.push_back(x);
		}
		else if (cmd == "pop_front") {
			if (d.empty()) cout << -1 << "\n";
			else {
				cout << d.front() << "\n";
				d.pop_front();
			}
			
		}
		else if (cmd == "pop_back") {
			if (d.empty()) cout << -1 << "\n";
			else {
				cout << d.back() << "\n";
				d.pop_back();
			}
		}
		else if (cmd == "size") {
			cout << d.size() << "\n";
		}
		else if (cmd == "empty") {
			if (d.empty()) cout << 1 << "\n";
			else cout << 0 << "\n";
		}
		else if (cmd == "front") {
			if (d.empty()) cout << -1 << "\n";
			else cout << d.front() << "\n";

		}
		else if (cmd == "back") {
			if (d.empty()) cout << -1 << "\n";
			else cout << d.back() << "\n";

		}
	}
	return 0;
}