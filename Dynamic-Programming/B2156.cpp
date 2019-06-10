#include <iostream>

/*
 * Baekjoon 2156 DP
 */

using namespace std;

int d[11111]; // d[i]는 i번째 잔에서 최대로 마실 수 있는 포도주의 양
int a[11111]; // a[i]는 i번째 잔의 양

int main() {
    int n;

    cin >> n;

    for (int i = 1; i <= n; i++) {
        cin >> a[i];
    }

    d[1] = a[1];
    d[2] = a[1] + a[2];

    for (int i = 3; i <= n; i++) {
        d[i] = max(d[i - 1], d[i - 2] + a[i]);
        d[i] = max(d[i], d[i - 3] + a[i - 1] + a[i]);
    }
    cout << d[n] << "\n";
}
