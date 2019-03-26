#include <iostream>
using namespace std;

// Baekjoon 10871번 문제
// 람다 함수 사용하기

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