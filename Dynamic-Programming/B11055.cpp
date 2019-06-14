#include <iostream>

using namespace std;

int d[1111];

int main() {

    int N;
    cin >> N;

    int a[N + 1];

    for (int i = 1; i <= N; i++) {
        cin >> a[i];
    }

    for (int i = 1; i <= N; i++) {
        d[i] = a[i];
        for (int j = i - 1; j >= 1; j--) {
            if (a[i] > a[j] && d[i] < d[j] + a[i]) {
                d[i] = d[j] + a[i];
            }
        }
    }

    long long result = 0;

    for (int i = 1; i <= N; i++) {
        if (d[i] > result)
            result = d[i];
    }

    cout << result << "\n";
    return 0;
}