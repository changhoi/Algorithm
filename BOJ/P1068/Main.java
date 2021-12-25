package P1068;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Node {
    int n;
    List<Node> children = new ArrayList<>();

    public Node(int n) {
        this.n = n;
    }

    void setChild(Node n) {
        children.add(n);
    }

    int countLeaf(int end) {
        boolean isLeaf = true;
        for (Node c : children) {
            if (c.n == end) continue;
            isLeaf = false;
            break;
        }
        if (isLeaf) return 1;

        int cnt = 0;
        for (Node c : children) if (c.n != end) cnt += c.countLeaf(end);
        
        return cnt;
    }
}

public class Main {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/P1068/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Node[] nodes = new Node[n];
        for (int i = 0; i < n; i++) nodes[i] = new Node(i);

        Node root = null;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int parent = Integer.parseInt(st.nextToken());
            Node node = nodes[i];
            if (parent == -1) {
                root = node;
                continue;
            }

            Node parentNode = nodes[parent];
            parentNode.setChild(node);
        }

        int end = Integer.parseInt(br.readLine());

        if (root != null && root.n == end) {
            System.out.println(0);
            return;
        }

        System.out.println(root.countLeaf(end));
    }
}
