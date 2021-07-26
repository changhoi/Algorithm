package P2352;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static List<Integer> dp = new ArrayList<>();

    static int upper(int val) {
        int l = 0, r = dp.size();
        while (l < r) {
            int mid = (l + r) / 2;
            if (dp.get(mid) < val) l = mid + 1;
            else r = mid;
        }
        return l;
    }

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/P2352/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        dp.add(0);
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i++) {
            int val = Integer.parseInt(st.nextToken());
            int idx = upper(val);
            if (idx == dp.size()) dp.add(val);
            else dp.set(idx, val);
        }

        System.out.println(dp.size() - 1);
    }
}
