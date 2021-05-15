package BOJ.BOJ1920;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N, M;

    static int getMid (int left, int right) {
        return (left + right) / 2;
    }

    static int binarySearch(ArrayList<Integer> arr, int target) {
        int right = arr.size() - 1;
        int left = 0;
        int mid = getMid(left, right);

        while (true) {

            int cur = arr.get(mid);
            if (cur == target) return 1;
            if (left >= right) return 0;

            if (target > cur) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }

            mid = getMid(left, right);
        }
    }

    public static void main(String[]args) throws IOException {
        System.setIn(new FileInputStream("src/BOJ/BOJ1920/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        ArrayList<Integer> arr = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr.add(Integer.parseInt(st.nextToken()));
        }
        arr.sort(Integer::compareTo);



        M = Integer.parseInt(br.readLine());
        StringTokenizer s = new StringTokenizer(br.readLine());

        for (int i = 0; i < M; i++) {
            System.out.println(binarySearch(arr, Integer.parseInt(s.nextToken())));
        }
    }
}
