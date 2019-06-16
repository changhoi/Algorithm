#include <iostream>

using namespace std;

/* Baekjoon 2579
 * d[i]는 a[i] 번째 계단을 마지막 계단으로 했을 때 최대 점수
 */

int d[333];

int max_value(int a, int b) {
    return a > b ? a : b;
}

int main() {

    int n;
    cin >> n;
    int a[n + 1];

    for (int i = 1; i <= n; i++) {
        cin >> a[i];
    }

    d[1] = a[1];
    d[2] = d[1] + a[2];
    d[3] = max_value(a[1] + a[3], a[2] + a[3]);

    for (int i = 4; i <= n; i++) {
        d[i] = max_value(d[i - 2] + a[i], d[i - 3] + a[i - 1] + a[i]);
    }

    cout << d[n] << "\n";


    return 0;
}