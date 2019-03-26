#include <iostream>
#include <functional>
using namespace std;

// Baekjoon 10870�� ����
// function�� �̿��� ���� �Լ� ����
// �Ǻ���ġ ���� ����� - ����Լ� ��� (���ٽ� ǥ��)

int main() {
    function<int(int)> fibo = [&](int n) {
        if (n > 1) {
            return fibo(n - 1) + fibo(n - 2);
        }
        return n;
    };
    int n;
    cin >> n;
    cout << fibo(n) << "\n";

    return 0;
}
