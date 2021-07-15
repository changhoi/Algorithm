package P1197;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Edge implements Comparable<Edge> {
    int weight;
    int from, to;

    @Override
    public int compareTo(Edge o) {
        return Integer.compare(this.weight, o.weight);
    }

    public Edge(int from, int to, int weight) {
        this.from = from;
        this.to = to;
        this.weight = weight;
    }
}

class Node {
    int idx;
    int root;

    public Node(int idx) {
        this.idx = idx;
        this.root = idx;
    }
}

public class Main {
    static Node[] nodes;

    static int find(Node n) {
        if (n.idx == n.root) return n.root;
        return n.root = find(nodes[n.root]);
    }

    static boolean onGraph(Edge e) {
        Node a = nodes[e.from];
        Node b = nodes[e.to];

        int aRoot = find(a);
        int bRoot = find(b);
        return aRoot == bRoot;
    }

    static void union(Edge e) {
        Node a = nodes[e.from];
        Node b = nodes[e.to];

        int aRoot = find(a);
        int bRoot = find(b);

        if (aRoot == bRoot) return;
        nodes[bRoot].root = nodes[aRoot].root;
    }

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/P1197/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        nodes = new Node[V];

        for (int i = 0; i < V; i++) nodes[i] = new Node(i);
        int E = Integer.parseInt(st.nextToken());

        PriorityQueue<Edge> queue = new PriorityQueue<>();

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken()) - 1;
            int B = Integer.parseInt(st.nextToken()) - 1;
            int C = Integer.parseInt(st.nextToken());  // 가중치
            queue.add(new Edge(A, B, C));
        }
        int ans = 0;
        while (!queue.isEmpty()) {
            Edge e = queue.poll();
            if (onGraph(e)) continue;
            ans += e.weight;
            union(e);
        }

        System.out.println(ans);
    }
}
