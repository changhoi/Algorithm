#include <iostream>
#include <functional>
#include <vector>
using namespace std;

// Baekjoon 10869�� ����
// ���� ǥ���� ����غ���
// Ranged-Based for ����غ���
// ���Ϳ��� ���� �޾Ƽ� ����� ���� ���� ���·� �ؾ���

int main() {
    vector<function<int(int, int)>> d;
    d.push_back([](int x, int y) {
        return x + y;
    });
    d.push_back([](int x, int y) {
        return x - y;
    });
    d.push_back([](int x, int y) {
        return x * y;
    });
    d.push_back([](int x, int y) {
        return x / y;
    });
    d.push_back([](int x, int y) {
        return x % y;
    });

    int x, y;
    cin >> x >> y;
    for (auto &f : d) {
        cout << f(x, y) << "\n";
    }
    return 0;
}