#include <iostream>
using namespace std;

// Baekjoon 2555 문제
// C++ 람다 함수 사용해보기

int main() {
    auto print = [] {
        cout << "10/14" << "\n";
    };
    print();
}