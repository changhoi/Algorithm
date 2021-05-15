package DAY03.P1927;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    static int N;

    static int command, param1, param2;

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        MinHeap2 mh = new MinHeap2();

        for (int i = 0; i < N; i++) {
            int input = sc.nextInt();
            if (input == 0) {
                System.out.println(mh.delete());
            } else {
                mh.insert(input);
            }
        }
    }
}

class MinHeap2 {
    List<Integer> heap;

    public MinHeap2() {
        heap = new ArrayList<>();
        heap.add(0);
    }

    public void insert(int val) {
        heap.add(val);
        int current = heap.size() - 1;
        int parent = current / 2;
        while (true) {
            if (parent == 0 || heap.get(parent) <= heap.get(current)) {
                break;
            }

            int temp = heap.get(parent);
            heap.set(parent, heap.get(current));
            heap.set(current, temp);

            current = parent;
            parent = current / 2;
        }
    }

    public int delete() {
        if (heap.size() == 1) {
            return 0;
        }

        int top = heap.get(1);
        heap.set(1, heap.get(heap.size() - 1));
        heap.remove(heap.size() - 1);

        int currentPos = 1;
        while (true) {
            int leftPos = currentPos * 2;
            int rightPos = currentPos * 2 + 1;

            if(leftPos >= heap.size()) {
                break;
            }

            int minValue = heap.get(leftPos);
            int minPos = leftPos;

            if(rightPos < heap.size() && minValue >= heap.get(rightPos)) {
                minValue = heap.get(rightPos);
                minPos = rightPos;
            }

            if (heap.get(currentPos) > minValue) {
                int temp = heap.get(currentPos);
                heap.set(currentPos, heap.get(minPos));
                heap.set(minPos, temp);
                currentPos = minPos;
            } else {
                break;
            }
        }

        return top;
    }
}
