#include <iostream>

using namespace std;

/**
 * d[i][j]는 2 * (i - 1) 열에서 얻을 수 있는 최대 점수
 * j = 0 뜯지 않음, j = 1 위, j = 2 아래
 */

int d[100001][3];

int max_value(int arr[], int length) {
    int max = arr[0];
    for (int i = 1; i < length; i++) {
        if (max < arr[i]) {
            max = arr[i];
        }
    }

    return max;
}

int main() {
    int T;
    cin >> T;
    while (T--) {
        int n;
        cin >> n;
        int a[2][n];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < n; j++) {
                cin >> a[i][j];
            }
        }

        d[0][0] = 0;
        d[0][1] = a[0][0];
        d[0][2] = a[1][0];

        for (int i = 1; i < n; i++) {
            int zero[3] = {d[i - 1][0], d[i - 1][1], d[i - 1][2]};
            int one[2] = {d[i - 1][0], d[i - 1][2]};
            int two[2] = {d[i - 1][0], d[i - 1][1]};
            d[i][0] = max_value(zero, 3);
            d[i][1] = max_value(one, 2) + a[0][i];
            d[i][2] = max_value(two, 2) + a[1][i];
        }
        int candidate[3] = {d[n - 1][0], d[n - 1][1], d[n - 1][2]};
        int result = max_value(candidate, 3);

        cout << result << "\n";
    }

    return 0;
}