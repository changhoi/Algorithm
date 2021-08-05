package P6236;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] arr;

    static boolean check(int mid) {
        int rest = mid;
        int num = 1;
        for (int a : arr) {
            if (a > rest) {
                rest = mid - a;
                num++;
            } else {
                rest -= a;
            }

            if (num > M) return false;
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/P6236/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        int sum = 0;
        int max = 0;
        for (int i = 0; i < N; i++) {
            int val = Integer.parseInt(br.readLine());
            sum += val;
            max = Math.max(max, val);
            arr[i] = val;
        }

        int l = max, r = sum;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (check(mid)) r = mid - 1;
            else l = mid + 1;
        }
        System.out.println(l);
    }
}
