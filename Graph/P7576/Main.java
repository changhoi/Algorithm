package P7576;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int m, n;
    static int[][] map, directions = {
            {0, 1},
            {0, -1},
            {1, 0},
            {-1, 0},
    };
    static List<int[]> start;

    static boolean isValid(int x, int y) {
        return 0 <= x && x < m && 0 <= y && y < n;
    }

    static int solution(int left) {
        boolean[][] visited = new boolean[n][m];
        Queue<int[]> queue = new LinkedList<>(start);

        int day = 0;
        while(!queue.isEmpty()) {
            int[] p = queue.poll();
            if (visited[p[0]][p[1]]) continue;
            visited[p[0]][p[1]] = true;
            left--;
            if (p[2] != day) day++;

            for(int[]d : directions) {
                int dy = p[0] + d[0];
                int dx = p[1] + d[1];
                if (isValid(dx, dy) && !visited[dy][dx] && map[dy][dx] == 0) {
                    queue.add(new int[]{dy, dx, p[2] + 1});
                }
            }
        }
        if (left != 0) return -1;
        else return day;
    }

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/P7576/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        int cnt = 0;
        start = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if (map[i][j] == 1) start.add(new int[]{i, j, 0});
                else if(map[i][j] == -1) cnt++;
            }
        }

        System.out.println(solution(m * n - cnt));
    }
}
