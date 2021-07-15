package P1922;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node {
    int n;
    Node root;

    public Node(int n) {
        this.n = n;
        this.root = this;
    }
}

class Edge implements Comparable<Edge> {
    Node a, b;
    int weight;

    public Edge(Node a, Node b, int weight) {
        this.a = a;
        this.b = b;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge o) {
        return Integer.compare(this.weight, o.weight);
    }
}

public class Main {
    static HashMap<Integer, Node> nodes = new HashMap<>();

    static Node getNode(int n) {
        if (nodes.containsKey(n)) return nodes.get(n);
        Node node = new Node(n);
        nodes.put(n, node);
        return node;
    }

    static boolean onGraph(Node a, Node b) {
        Node aRoot = find(a);
        Node bRoot = find(b);
        return aRoot.n == bRoot.n;
    }

    static void union(Node a, Node b) {
        Node aRoot = find(a);
        Node bRoot = find(b);
        if (aRoot.n == bRoot.n) return;
        bRoot.root = aRoot;
    }

    static Node find(Node node) {
        if (node.root.n == node.n) return node;
        return node.root = find(node.root);
    }

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/P1922/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        PriorityQueue<Edge> queue = new PriorityQueue<>();
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            Node a = getNode(Integer.parseInt(st.nextToken()));
            Node b = getNode(Integer.parseInt(st.nextToken()));
            int c = Integer.parseInt(st.nextToken());
            Edge e = new Edge(a, b, c);

            queue.add(e);
        }
        int ans = 0;

        while (!queue.isEmpty()) {
            Edge e = queue.poll();
            if (onGraph(e.a, e.b)) continue;
            ans += e.weight;
            union(e.a, e.b);
        }
        System.out.println(ans);
    }
}
