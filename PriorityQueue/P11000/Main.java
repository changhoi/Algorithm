package P11000;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Class implements Comparable<Class> {
    int start, end;

    public Class(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Class o) {
        return Integer.compare(this.start, o.start);
    }
}

public class Main {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/P11000/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        List<Class> classes = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            classes.add(new Class(start, end));
        }

        classes.sort(Class::compareTo);

        PriorityQueue<Integer> rooms = new PriorityQueue<>();
        Class firstClass = classes.remove(0);
        rooms.add(firstClass.end);
        for (Class c : classes) {
            if (c.start >= rooms.peek()) {
                rooms.poll();
            }
            rooms.add(c.end);
        }

        System.out.println(rooms.size());
    }
}
