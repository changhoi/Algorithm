package P4256;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[] pre, in;
    static String travel(int ps, int pe, int is, int ie) {
        if (ps > pe) return "";
        if (is == ie) return in[is] + " ";
        int idx = -1;
        for (int i = is; i <= ie; i++) {
            if (pre[ps] == in[i]) {
                idx = i;
                break;
            }
        }

        int left = idx - is;

        return travel(ps + 1, ps + left, is, idx - 1) + travel(ps + left + 1, pe, idx + 1, ie) + in[idx] + " ";
    }



    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/P4256/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine());

        for (int i =0 ;i < tc; i++) {
            n = Integer.parseInt(br.readLine());
            StringTokenizer preStr = new StringTokenizer(br.readLine());
            StringTokenizer inStr = new StringTokenizer(br.readLine());
            pre = new int[n];
            in = new int[n];

            for (int j = 0;j < n; j++) {
                pre[j] = Integer.parseInt(preStr.nextToken());
                in[j] = Integer.parseInt(inStr.nextToken());
            }
            System.out.println(travel(0, n - 1, 0, n - 1).trim());
        }
    }
}
