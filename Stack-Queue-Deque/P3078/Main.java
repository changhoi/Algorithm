package P3078;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/P3078/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        long ans = 0;
        HashMap<Integer, Long> map = new HashMap<>();
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            String s = br.readLine();
            int len = s.length();
            if (queue.size() > K) {
                int val = queue.poll();
                long cnt = map.get(val);
                map.put(val, cnt - 1);
            }

            if (map.containsKey(len)) {
                long val = map.get(len);
                map.put(len, val + 1);
                ans += val;
            } else {
                map.put(len, 1L);
            }
            queue.add(len);
        }

        System.out.println(ans);
    }
}
