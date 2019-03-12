#include <iostream>
#include <iomanip>
using namespace std;

// Baekjoon 2741번 문제
// N찍기 문제
// cout << << endl보다 \n을 쓰는 게 훨씬 빠르다


int main() {
    int i;
    cin >> i;
    for (int j = 0; j < i; j++) {
        cout << j + 1 << "\n";
    }

}