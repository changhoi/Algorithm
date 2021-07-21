package P12015;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] A;
    static List<Integer> X;

    static int upper(int x) {
        int l = 0, r = X.size();
        while (l < r) {
            int mid = (l + r) / 2;
            int val = X.get(mid);
            if (val < x) {
                l = mid + 1;
            } else r = mid;
        }

        return r;
    }

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/P12015/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        A = new int[N + 1];
        X = new ArrayList<>();
        X.add(0);
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i++) A[i] = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= N; i++) {
            int a = A[i];
            int idx = upper(a);
            if (X.size() == idx) X.add(a);
            else X.set(idx, a);
        }

        System.out.println(X.size() - 1);
    }
}
