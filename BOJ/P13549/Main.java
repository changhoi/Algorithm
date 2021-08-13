package P13549;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, K;
    static boolean[] visited = new boolean[100001];
    static int[] cnt = new int[100001];
    static boolean valid(int n) {
        return 0 <= n && n <= 100000 && !visited[n];
    }

    static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(N);
        visited[N] = true;
        while(!queue.isEmpty()) {
            int p = queue.poll();
            int[] d = {2 * p, p - 1, p + 1};
            if (p == K) {
                System.out.println(cnt[p]);
                return;
            }
            if (valid(d[0])) {
                queue.add(d[0]);
                cnt[d[0]] = cnt[p];
                visited[d[0]] = true;
            }
            if (valid(d[1])) {
                queue.add(d[1]);
                cnt[d[1]] = cnt[p] + 1;
                visited[d[1]] = true;
            }
            if (valid(d[2])) {
                queue.add(d[2]);
                cnt[d[2]] = cnt[p] + 1;
                visited[d[2]] = true;
            }

        }
    }

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/P13549/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        bfs();
    }
}
