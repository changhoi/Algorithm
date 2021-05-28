package P1715;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/P1715/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> q = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            q.add(Integer.parseInt(br.readLine()));
        }

        int sum = 0;
        while(!q.isEmpty()) {
            int a = q.poll();
            if (q.isEmpty()) break;

            int b = q.poll();
            int ab = a + b;
            sum += ab;
            q.add(ab);
        }

        System.out.println(sum);
    }
}
