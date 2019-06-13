#include <iostream>

using namespace std;

/*
 * Baekjoon 11053번 문제 DP
 * d[i] == a[i]를 마지막으로 하는 가장 긴 수열의 길이
 *
 */

int d[1111];

int main() {
    int N;
    cin >> N;
    int a[N + 1];
    for (int i = 1; i <= N; i++) {
        cin >> a[i];
    }

    d[1] = 1;

    for (int i = 2; i <= N; i++) {
        d[i] = 1;
        for(int j = i - 1; j >= 1; j--) {
            if (a[j] < a[i] && d[i] < d[j] + 1) {
                d[i] = d[j] + 1;
            }
        }
    }

    int result = d[1];
    for (int  i = 2; i <= N; i++) {
        if (result < d[i]) {
            result = d[i];
        }
    }

    cout << result << "\n";

    return 0;
}