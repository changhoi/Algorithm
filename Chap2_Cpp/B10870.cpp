#include <iostream>
#include <functional>
using namespace std;

// Baekjoon 10870번 문제
// function을 이용한 람다 함수 정의
// 피보나치 수열 만들기 - 재귀함수 사용 (람다식 표현)

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
