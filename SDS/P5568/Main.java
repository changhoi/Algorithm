package P5568;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
    static int[] arr;
    static boolean[] visited;
    static Set<String> comb = new HashSet<>();

    static void play(int depth, String state) {
        if (depth == 0) {
            comb.add(state);
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            play(depth - 1, state + arr[i]);
            visited[i] = false;
        }
    }

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/P5568/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        arr = new int[n];
        visited = new boolean[n];
        int k = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            int v = Integer.parseInt(br.readLine());
            arr[i] = v;
        }

        play(k, "");
        System.out.println(comb.size());
    }
}
