package P11725;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

    static int N;

    static class Node {
        int idx, parent;

        public Node(int idx) {
            this.idx = idx;
            this.parent = -1;
        }
    }

    static LinkedList<Integer>[] edges;
    static Node[] nodes;
    static boolean[] visited;

    static void setParent(int node, int parent) {
        visited[node] = true;
        nodes[node].parent = parent;
        edges[node].remove((Integer) parent);

        while (!edges[node].isEmpty()) {
            int to = edges[node].pop();
            if (visited[to]) continue;
            setParent(to, node);
        }

        visited[node] = false;
    }

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/P11725/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        edges = new LinkedList[N];
        nodes = new Node[N];
        visited = new boolean[N];
        for (int i = 0; i < N; i++) {
            nodes[i] = new Node(i);
            edges[i] = new LinkedList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            edges[a].add(b);
            edges[b].add(a);
        }

        for (int i : edges[0]) {
            setParent(i, 0);
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i < N; i++) {
            Node n = nodes[i];
            sb.append(n.parent + 1).append("\n");
        }
        System.out.println(sb.toString().trim());
    }
}
