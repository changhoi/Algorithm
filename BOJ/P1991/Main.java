package DAY03.P1991;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static char[][] tree;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/DAY03/P1991/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        tree = new char[26][2];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            char node = st.nextToken().toCharArray()[0];
            char left = st.nextToken().toCharArray()[0];
            char right = st.nextToken().toCharArray()[0];

            tree[node - 'A'][0] = left;
            tree[node - 'A'][1] = right;
        }

        preOrder('A');
        System.out.println();
        inOrder('A');
        System.out.println();
        postOrder('A');
    }

    static void preOrder(char root) {
        System.out.print(root);
        if (tree[root - 'A'][0] != '.') {
            preOrder(tree[root - 'A'][0]);
        }

        if (tree[root - 'A'][1] != '.') {
            preOrder(tree[root - 'A'][1]);
        }
    }

    static void inOrder(char root) {
        if (tree[root - 'A'][0] != '.') {
            inOrder(tree[root - 'A'][0]);
        }

        System.out.print(root);

        if (tree[root - 'A'][1] != '.') {
            inOrder(tree[root - 'A'][1]);
        }
    }

    static void postOrder(char root) {
        char leftNode = tree[root - 'A'][0];
        char rightNode = tree[root - 'A'][1];

        if (leftNode != '.') {
            postOrder(leftNode);
        }

        if (rightNode != '.') {
            postOrder(rightNode);
        }

        System.out.print(root);
    }
}

