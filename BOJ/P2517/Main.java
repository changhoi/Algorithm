package DAY02.P2517;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int N;
    static int nums[] = { 8, 2, 8, 10, 7, 1, 9, 4, 15 };
    static int temp[] = new int[nums.length];
    static Runner[] runners;
    static Runner[] temp2;

    static int[] ranks; // [1, 2, 3, 4, 5, 6, 7, 8] ranks[runner.position] -= count;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/DAY02/mergeSort/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        runners = new Runner[N];
        temp2 = new Runner[N];
        ranks = new int[N];
        for (int i = 0; i < N; i++) {
            runners[i] = new Runner(Long.parseLong(br.readLine()), i);
            ranks[i] = i + 1;
        }
        System.out.println(Arrays.toString(runners));
        System.out.println(Arrays.toString(ranks));
        mergeSort(0, N - 1);
        System.out.println(Arrays.toString(runners));
        System.out.println(Arrays.toString(ranks));
    }

    static void mergeSort(int s, int e) {
        if (s < e) {
            int mid = (s + e) / 2;
            mergeSort(s, mid);
            mergeSort(mid + 1, e);
            merge(s, mid, e);
        }
    }

    static void merge(int s, int m, int e) {
        int p1 = s;
        int p2 = m + 1;
        int k = s;
        while (p1 <= m && p2 <= e) {
            if (runners[p1].value <= runners[p2].value) {
                temp2[k++] = runners[p1++];
            } else {
                int count = p1 - s;
                ranks[runners[p2].position] -= count;
                temp2[k++] = runners[p2++];
            }
        }

        while (p1 <= m) {
            temp2[k++] = runners[p1++];
        }

        while (p2 <= e) {
            int count = p1 - s;
            ranks[runners[p2].position] -= count;
            temp2[k++] = runners[p2++];
        }

        for (int i = s; i <= e; i++) {
            runners[i] = temp2[i];
        }
    }
}

class Runner {
    long value;
    int position; // 최초 시작 시 자기 포지션

    public Runner(long value, int position) {
        super();
        this.value = value;
        this.position = position;
    }

    @Override
    public String toString() {
        return "[value=" + value + ", position=" + position + "]";
    }
}