package P1700;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

class Pair implements Comparable<Pair> {
    int device;
    PriorityQueue<Integer> order = new PriorityQueue<>();

    public Pair(int device) {
        this.device = device;
    }

    @Override
    public int compareTo(Pair o) {
        if (this.order.isEmpty()) return -1;
        if (o.order.isEmpty()) return 1;
        int o1 = this.order.peek();
        int o2 = o.order.peek();

        return Integer.compare(o2, o1);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair pair = (Pair) o;
        return device == pair.device;
    }

    @Override
    public int hashCode() {
        return Objects.hash(device);
    }

    @Override
    public String toString() {
        return "Pair{" +
                "device=" + device +
                ", order=" + order +
                '}';
    }
}

public class Main {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/P1700/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] order = new int[K];
        PriorityQueue<Pair> concent = new PriorityQueue<>();
        HashMap<Integer, Pair> devices = new HashMap<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            int d = Integer.parseInt(st.nextToken());
            order[i] = d;
            if (devices.containsKey(d)) {
                Pair p = devices.get(d);
                p.order.add(i);
            } else {
                Pair p = new Pair(d);
                p.order.add(i);
                devices.put(d, p);
            }
        }

        int ans = 0;

        for (int o : order) {
            Pair p = devices.get(o);
            p.order.poll();

            if (concent.contains(p)) {
                concent.remove(p);
                concent.add(p);
                continue;
            }

            if (concent.size() < N) {
                concent.add(p);
                continue;
            }

            ans++;
            concent.poll();
            concent.add(p);
        }

        System.out.println(ans);
    }
}
