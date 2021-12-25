package P1005;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static void setList(List<Integer>[][] lists, String[] rules) {
        for (String r : rules) {
            StringTokenizer st = new StringTokenizer(r);
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;

            lists[a][1].add(b);
            lists[b][0].add(a);
        }
    }

    static void solution(int n, int[] buildings, String[] rules, int w) {
        List<Integer>[][] lists = new ArrayList[n][2];
        for (int i = 0; i < n; i++) {
            lists[i][0] = new ArrayList<>(); // to
            lists[i][1] = new ArrayList<>(); // from
        }
        setList(lists, rules);

        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.comparingInt(a -> buildings[a]));
        int[] consumed = new int[n];
        for (int i = 0; i < n; i++) {
            if (lists[i][0].isEmpty()) queue.add(i);
        }

        while (!queue.isEmpty()) {
            int idx = queue.poll();
            for (int next : lists[idx][1]) {
                lists[next][0].remove((Integer) idx);
                consumed[next] = Math.max(consumed[idx] + buildings[idx], consumed[next]);
                if (lists[next][0].isEmpty()) queue.add(next);
            }

            if (idx != w - 1) continue;

            System.out.println(buildings[idx] + consumed[idx]);
            break;
        }
    }

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/P1005/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            int[] buildings = new int[n];
            for (int j = 0; j < n; j++) buildings[j] = Integer.parseInt(st.nextToken());

            String[] rules = new String[k];
            for (int j = 0; j < k; j++) rules[j] = br.readLine();
            int w = Integer.parseInt(br.readLine());
            solution(n, buildings, rules, w);
        }
    }
}

