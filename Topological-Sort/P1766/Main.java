package P1766;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Vertex implements Comparable<Vertex>{
    List<Integer> out = new ArrayList<>();
    List<Integer> in = new ArrayList<>();
    int number;

    public Vertex(int number) {
        this.number = number;
    }

    @Override
    public int compareTo(Vertex o) {
        return Integer.compare(this.number, o.number);
    }
}

public class Main {
    static Vertex[] vertices;

    static StringBuilder sb = new StringBuilder();
    static PriorityQueue<Vertex> queue = new PriorityQueue<>();


    static void topologicalSort() {
        while(!queue.isEmpty()) {
            Vertex v = queue.poll();
            sb.append(v.number).append(" ");

            for (int edgeTo : v.out) {
                Vertex target = vertices[edgeTo];
                target.in.remove((Integer) v.number);
                if (target.in.isEmpty()) queue.add(target);
            }
        }


        System.out.print(sb.toString().trim());
    }

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/P1766/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        vertices = new Vertex[N + 1];
        for (int i = 1; i <= N; i++) {
            vertices[i] = new Vertex(i);
        }

        for (int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine());
            int pre = Integer.parseInt(st.nextToken());
            int next = Integer.parseInt(st.nextToken());
            vertices[pre].out.add(next);
            vertices[next].in.add(pre);
        }

        for (int i = 1; i <= N; i++) {
            if (vertices[i].in.isEmpty()) {
                queue.add(vertices[i]);
            }
        }

        topologicalSort();
    }
}
