package P2252;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node implements Comparable<Node> {
    List<Integer> in = new ArrayList<>();
    List<Integer> out = new ArrayList<>();
    int val;

    public Node(int val) {
        this.val = val;
    }

    @Override
    public int compareTo(Node o) {
        return this.val - o.val;
    }
}

public class Main {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/P2252/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        List<Node> nodes = new ArrayList<>();
        for (int i = 0; i < N; i++) nodes.add(new Node(i));

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            nodes.get(a).in.add(b);
            nodes.get(b).out.add(b);
        }

        PriorityQueue<Node> candidates = new PriorityQueue<>();

        for (Node n : nodes) if (n.out.size() == 0) candidates.add(n);

        StringBuilder sb = new StringBuilder();
        while (!candidates.isEmpty()) {
            Node n = candidates.poll();
            sb.append(n.val + 1).append(" ");
            for (int next : n.in) {
                Node v = nodes.get(next);
                v.out.remove((Integer) v.val);
                if (v.out.size() == 0) candidates.add(v);
            }
        }

        System.out.println(sb.toString().trim());
    }
}