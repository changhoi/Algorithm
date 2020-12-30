package Searching;

import java.util.LinkedList;
import java.util.Queue;

class Node {
    static Node[] nodes;
    boolean visited = false;
    int idx;

    public Node(int idx) {
        this.idx = idx;
        nodes[idx] = this;
    }
}

class Solution02 {
    boolean[][] edges;

    void dfs(Node n) {
        n.visited = true;
        Queue<Node> q = new LinkedList<>();
        for (Node node : Node.nodes) {
            if (node.visited) continue;
            if (edges[n.idx][node.idx]) q.add(node);
        }

        while (!q.isEmpty()) {
           dfs(q.poll());
        }
    }

    public int solution(int n, int[][] computers) {
        edges = new boolean[n][n];
        Node.nodes = new Node[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                edges[i][j] = computers[i][j] == 1;
            }
            new Node(i);
        }

        int network = 0;
        for (Node node : Node.nodes) {
            if (node.visited) continue;

            dfs(node);
            network++;
        }

        return network;
    }
}