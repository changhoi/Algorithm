package P2143;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] A, B;
    static List<Long> sumA = new ArrayList<>(), sumB = new ArrayList<>();

    static void init(List<Long> sArr, int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            long sum = 0;
            for (int j = i; j < arr.length; j++) {
                sum += arr[j];
                sArr.add(sum);
            }
        }

        sArr.sort(null);
    }

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/P2143/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());

        A = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());

        B = new int[m];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }

        init(sumA, A);
        init(sumB, B);

        long ans = 0;

        int l = 0, r = sumB.size() - 1;
        while (l < sumA.size() && r >= 0) {
            long aValue = sumA.get(l);
            long bValue = sumB.get(r);
            long v = aValue + bValue;
            if (v > t) r--;
            else if (v < t) l++;
            else {
                long cnt1 = 1, cnt2 = 1;
                while (l < sumA.size() - 1) {
                    long l1 = sumA.get(l);
                    long l2 = sumA.get(l + 1);
                    if (l1 != l2) break;
                    l++;
                    cnt1++;
                }

                while (r > 0) {
                    long r1 = sumB.get(r);
                    long r2 = sumB.get(r - 1);
                    if (r1 != r2) break;
                    r--;
                    cnt2++;
                }

                ans += cnt1 * cnt2;
                l++;
                r--;
            }

        }

        System.out.println(ans);
    }
}
