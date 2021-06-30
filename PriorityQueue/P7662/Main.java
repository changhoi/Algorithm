package P7662;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.TreeMap;

class PQ {
    private TreeMap<Integer, Integer> map = new TreeMap<>();

    void push(int v) {
        map.put(v, map.getOrDefault(v, 0) + 1);
    }

    void pop(int d) {
        if (map.isEmpty()) return;
        int val = d == 1 ? map.lastKey() : map.firstKey();
        int cnt = map.get(val);

        if (cnt == 1) {
            map.remove(val);
        } else {
            map.put(val, cnt - 1);
        }
    }

    boolean isEmpty() {
        return map.isEmpty();
    }

    int getMax() {
        return map.lastKey();
    }

    int getMin() {
        return map.firstKey();
    }
}

public class Main {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/P7662/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int K = Integer.parseInt(br.readLine());
            PQ q = new PQ();

            for (int j = 0; j < K; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String command = st.nextToken();
                int val = Integer.parseInt(st.nextToken());
                if (command.equals("I")) q.push(val);
                else q.pop(val);
            }
            if (q.isEmpty()) System.out.println("EMPTY");
            else System.out.println(q.getMax() + " " + q.getMin());
        }
    }
}
