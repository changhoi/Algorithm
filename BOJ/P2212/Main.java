package P2212;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, k;
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/P2212/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());

        if (n <= k) {
            System.out.println(0);
            return;
        }

        List<Integer> sensor = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) sensor.add(Integer.parseInt(st.nextToken()));
        sensor.sort(null);

        PriorityQueue<Integer> dist =  new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < n - 1; i++) dist.add(sensor.get(i + 1) - sensor.get(i));
        while(--k > 0) dist.poll();
        int ans = 0;
        while(!dist.isEmpty()) ans += dist.poll();
        System.out.println(ans);
    }
}
