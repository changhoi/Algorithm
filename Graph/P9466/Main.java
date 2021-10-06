package P9466;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    static boolean[] visited;
    static int answer;

    static int search(int idx, int[] arr, Set<Integer> line) {
        int val = arr[idx];
        visited[idx] = true;
        if (line.contains(val)) return val;
        if (val == idx) return -1;
        if (visited[val]) {
            answer++;
            return -1;
        }

        line.add(idx);

        int ret = search(val, arr, line);
        if (ret == -1) answer++;
        else if (ret == idx) ret = -1;

        return ret;
    }

    static void solution(int n, int[] arr) {
        visited = new boolean[n + 1];
        answer = 0;

        for (int i = 1; i <= n; i++) {
            if (visited[i]) continue;
            search(i, arr, new HashSet<>());
        }
        System.out.println(answer);
    }

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/P9466/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] arr = new int[n + 1];
            for (int j = 1; j <= n; j++) arr[j] = Integer.parseInt(st.nextToken());
            solution(n, arr);
        }
    }
}
