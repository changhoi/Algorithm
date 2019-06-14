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
        d[i] = 1;
        for (int j = i - 1; j > 0; j--) {
            if (a[i] < a[j] && d[i] < d[j] + 1)
                d[i] = d[j] + 1;
        }
    }
    cout << "\n";

    int result = 0;
    for (int i = 1; i <= N; i++) {
        if (result < d[i])
            result = d[i];
    }

    cout << result << "\n";

    return 0;
}