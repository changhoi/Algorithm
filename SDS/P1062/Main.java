package P1062;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static boolean[] learn = new boolean[26];
    static List<char[]> words = new ArrayList<>();
    static int max = 0;

    static void dfs(int K, int idx) {

        learn[idx] = true;
        if (K - 1 == 0) max = Math.max(max, availableWords());
        else {
            for (int i = idx + 1; i < 26; i++) {
                if (!learn[i]) dfs(K - 1, i);
            }
        }
        learn[idx] = false;
    }

    static int availableWords() {
        int cnt = 0;
        for (char[] word : words) {
            boolean able = true;
            for (char w : word) {
                if (!learn[w - 'a']) {
                    able = false;
                    break;
                }
            }
            if (able) cnt++;
        }
        return cnt;
    }

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/P1062/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        learn['a' - 'a'] = true;
        learn['n' - 'a'] = true;
        learn['t' - 'a'] = true;
        learn['i' - 'a'] = true;
        learn['c' - 'a'] = true;

        K -= 5;
        if (K < 0) {
            System.out.println(0);
            return;
        }

        for (int i = 0; i < N; i++) {
            char[] word = br.readLine().toCharArray();
            words.add(word);
        }

        max = availableWords();
        if (K == 0) {
            System.out.println(max);
            return;
        }

        for (int i = 0; i < 26; i++) {
            if (!learn[i]) dfs(K, i);
        }
        System.out.println(max);
    }
}
