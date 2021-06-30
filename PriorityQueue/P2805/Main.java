package P2805;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/P2805/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int t = Integer.parseInt(st.nextToken());
            queue.add(t);
        }

        int top = queue.poll();
        int cnt = 1;
        int scope = top;
        int length = 0;
        while(!queue.isEmpty()) {
            scope = queue.poll();
            if (length + (top - scope) * cnt > M) break;
            length += (top - scope) * cnt;
            top = scope;
            cnt++;

        }

        double left = Math.ceil((M - length) / (double) cnt);
        System.out.println(top - (int) left);
    }
}
