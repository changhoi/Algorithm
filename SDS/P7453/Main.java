package P7453;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static long[][] arr;
    static long[] ab, cd;


    static int upper(int l, int r, long target) {
        while (l < r) {
            int mid = (l + r) / 2;
            if (cd[mid] <= target) l = mid + 1;
            else r = mid;
        }

        return r;
    }

    static int lower(int l, int r, long target) {
        while (l < r) {
            int mid = (l + r) / 2;
            if (cd[mid] < target) l = mid + 1;
            else r = mid;
        }

        return r;
    }

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/P7453/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        arr = new long[n][4];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Long.parseLong(st.nextToken());
            arr[i][1] = Long.parseLong(st.nextToken());
            arr[i][2] = Long.parseLong(st.nextToken());
            arr[i][3] = Long.parseLong(st.nextToken());
        }

        ab = new long[n * n];
        cd = new long[n * n];

        int idx = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                ab[idx] = arr[i][0] + arr[j][1];
                cd[idx] = arr[i][2] + arr[j][3];
                idx++;
            }
        }
        Arrays.sort(ab);
        Arrays.sort(cd);

        long ans = 0;
        for (long v : ab) ans += upper(0, cd.length, -v) - lower(0, cd.length, -v);

        bw.write(ans + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
