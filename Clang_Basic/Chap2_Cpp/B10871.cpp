#include <iostream>
using namespace std;

// Baekjoon 10871�� ����
// ���� �Լ� ����ϱ�

int main() {
    int n, x;
    cin >> n >> x;
    auto is_less = [&x] (int num) {
        return x > num;
    };
    for (int i = 0; i < n; i++) {
        int num;
        cin >> num;
        if (is_less(num)) {
            cout << num << ' ';
        }
    }
    cout << "\n";
    return 0;
}