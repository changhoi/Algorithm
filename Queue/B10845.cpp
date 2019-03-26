#include <iostream>
#include <queue>
#include <string>

using namespace std;

int main() {
	int N, val;
	string cmd;
	queue<int> q;

	cin >> N;

	while (N--) {
		cin >> cmd;
		if (cmd == "push") {
			cin >> val;
			q.push(val);
		}
		else if (cmd == "pop") {
			if (q.empty()) cout << -1 << "\n";
			else {
				cout << q.front() << "\n";
				q.pop();
			}
		}
		else if (cmd == "front") {
			if (q.empty()) cout << -1 << "\n";
			else {
				cout << q.front() << "\n";
			}
		}
		else if (cmd == "back") {
			if (q.empty()) cout << -1 << "\n";
			else {
				cout << q.back() << "\n";
			}
		}
		else if (cmd == "size") {
			cout << q.size() << "\n";
		}
		else if (cmd == "empty") {
			if (q.empty()) cout << 1 << "\n";
			else cout << 0 << "\n";
		}
	}

	return 0;
}