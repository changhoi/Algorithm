#include <iostream>
#include <functional>
#include <vector>
using namespace std;

// Baekjoon 10869번 문제
// 람다 표현식 사용해보기
// Ranged-Based for 사용해보기
// 벡터에서 값을 받아서 사용할 때는 참조 형태로 해야함

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