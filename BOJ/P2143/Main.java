package DAY02.P2143;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

    static long T;
    static int N, M;
    static long[] inputA, inputB;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src\\DAY02\\P2143\\input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Long.parseLong(br.readLine());
        N = Integer.parseInt(br.readLine());
        inputA = new long[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            inputA[i] = Long.parseLong(st.nextToken());
        }

        M = Integer.parseInt(br.readLine());
        inputB = new long[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            inputB[i] = Long.parseLong(st.nextToken());
        }

        System.out.println(Arrays.toString(inputA));
        System.out.println(Arrays.toString(inputB));

        List<Long> subA = new ArrayList<>();
        List<Long> subB = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            long sum = inputA[i];
            subA.add(sum);
            for (int j = i + 1; j < N; j++) {
                sum += inputA[j];
                subA.add(sum);
            }
        }

//      System.out.println(subA);

        for (int i = 0; i < M; i++) {
            long sum = inputB[i];
            subB.add(sum);
            for (int j = i + 1; j < M; j++) {
                sum += inputB[j];
                subB.add(sum);
            }
        }

//      Collections.sort(subA);
        Collections.sort(subB);

        long result = 0;

        for (int i = 0; i < subA.size(); i++) {
            int lower = lowerBound(subB, 0, subB.size(), T - subA.get(i));
            int upper = upperBound(subB, 0, subB.size(), T - subA.get(i));
            result += (upper - lower);
        }
        System.out.println(result);
    }

    static int upperBound(List<Long> list, int left, int right, long target) {
        int mid = 0;
        while (left < right) {
            mid = (left + right) / 2;
            if (list.get(mid) <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return right;
    }

    static int lowerBound(List<Long> list, int left, int right, long target) {
        int mid = 0;
        while (left < right) {
            mid = (left + right) / 2;
            if (list.get(mid) < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return right;
    }
}