package P1655;

import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/P1655/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();


        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(br.readLine());
            if (maxHeap.size() == 0) {
                maxHeap.add(n);
                bw.write(n + "\n");
            } else {
                if (maxHeap.size() > minHeap.size()) minHeap.add(n);
                else maxHeap.add(n);
                if (maxHeap.peek() > minHeap.peek()) {
                    int max = maxHeap.poll();
                    int min = minHeap.poll();
                    minHeap.add(max);
                    maxHeap.add(min);
                }
                bw.write(maxHeap.peek() + "\n");
            }
        }

        bw.flush();
        bw.close();
    }
}
