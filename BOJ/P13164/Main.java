package P13164;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/P13164/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        if (n <= k) {
            System.out.println(0);
            return;
        }

        List<Integer> children = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) children.add(Integer.parseInt(st.nextToken()));

        children.sort(null);

        PriorityQueue<Integer> dist = new PriorityQueue<>(Comparator.reverseOrder());
        for(int i = 0; i < n - 1; i++) dist.add(children.get(i + 1) - children.get(i));

        while(--k > 0) dist.poll();

        int ans = 0;
        while(!dist.isEmpty()) ans += dist.poll();

        System.out.println(ans);
    }
}
