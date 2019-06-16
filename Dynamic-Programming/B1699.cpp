#include <iostream>
#include <math.h>

using namespace std;

int d[111111];

int main() {
    int n;
    cin >> n;

    d[1] = 1;
    d[2] = 2;
    d[3] = 3;

    for (int i = 4; i <= n; i++) {
        d[i] = i;
        for (int j = 1; j * j <= i; j++) {
            if (d[i] > d[i - j * j] + 1)
                d[i] = d[i - j * j] + 1;
        }
    }

    cout << d[n] << "\n";

    return 0;
}