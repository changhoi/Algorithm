#include <cstdio>
#include <iostream>
#include <queue>

using namespace std;

int arr[111][111];
int dist[111][111];

int dx[] = {1, -1, 0, 0};
int dy[] = {0, 0, 1, -1};

int main() {
    int N, M;
    cin >> N >> M;

    for (int i = 1; i <= N; i++) {
        for (int j = 1; j <= M; j++) {
            scanf("%1d", &arr[i][j]);
        }
    }

    queue<pair<int,int>> q;
    q.push(make_pair(1, 1));
    dist[1][1] = 1;

    while(!q.empty()) {
        int x = q.front().first;
        int y = q.front().second;
        q.pop();

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx > 0 && nx <= N && ny > 0 && ny <= M) {
                if (dist[nx][ny] == 0 && arr[nx][ny] == 1) {
                    dist[nx][ny] = dist[x][y] + 1;
                    q.push(make_pair(nx, ny));
                }
            }
        }

    }
    cout << dist[N][M] << endl;

    return 0;
}