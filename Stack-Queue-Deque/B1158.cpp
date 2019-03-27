#include <iostream>
#include <queue>
#include <vector>

using namespace std;

int main() {
	int N, M;
	queue<int> q;

	cin >> N >> M;
	for (int i = 0; i < N; i++)
		q.push(i + 1);

	cout << "<";
	int count = 1;
	while (!q.empty()) {
		if (count == M) {
			if (q.size() == 1) {
				cout << q.front();
				q.pop();
			}
			else {
				cout << q.front() << ", ";
				q.pop();
			}
			count = 1;
		}
		else {
			q.push(q.front());
			q.pop();
			count++;
		}
	}
	
	cout << ">";
	return 0;
}