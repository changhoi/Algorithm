package P2252;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

class Student {
    int id;
    List<Integer> front = new ArrayList<>();
    List<Integer> back = new ArrayList<>();

    public Student(int id) {
        this.id = id;
    }
}

public class Main {
    static Student[] students;
    static Queue<Student> queue = new LinkedList<>();

    static void topologySort() {
        StringBuilder sb = new StringBuilder();
        while(!queue.isEmpty()) {
            Student s = queue.poll();
            sb.append(s.id).append(" ");
            for(int b : s.back) {
                students[b - 1].front.remove((Integer) s.id);
                if (students[b - 1].front.isEmpty()) queue.add(students[b - 1]);
            }
        }

        System.out.println(sb.toString().trim());
    }

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/P2252/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        students = new Student[N];

        for (int i = 0; i < N; i ++) {
            students[i] = new Student(i + 1);
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            students[A - 1].back.add(B);
            students[B - 1].front.add(A);
        }

        for (Student s : students) {
            if (s.front.isEmpty()) queue.add(s);
        }

        topologySort();
    }
}
