#include <iostream>

using namespace std;

int d[1111][2];

/**
 * d[i][0]: a[i]를 오른쪽 끝으로한 증가 수열
 * d[i][1]: a[i]를 왼쪽 끝으로 한 (왼쪽이 가장 큰) 증가 수열
 * @return
 */

int main() {
    int N;
    cin >> N;

    int a[N + 1];

    for (int i = 1; i <= N; i++) {
        cin >> a[i];
    }

    for (int i = 1; i <= N; i++) {
        d[i][0] = 1;
        for (int j = i - 1; j > 0; j--) {
            if (a[j] < a[i] && d[i][0] < d[j][0] + 1)
                d[i][0] = d[j][0] + 1;
        }
    }

    for (int i = N; i > 0; i--) {
        d[i][1] = 1;
        for (int j = i + 1; j <= N; j++) {
            if (a[j] < a[i] && d[i][1] < d[j][1] + 1)
                d[i][1] = d[j][1] + 1;
        }
    }

    int result = 0;

    for (int i = 1; i <= N; i++) {
        int temp = d[i][0] + d[i][1] - 1;
        if ( temp > result)
            result = temp;
    }

    cout << result << "\n";
    return 0;
}