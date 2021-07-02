package P2920;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[8];
        boolean a = true, b = true;
        for (int i = 0; i < 8; i++) {
            int v = Integer.parseInt(st.nextToken());
            arr[i] = v;

            if (a) {
                a = v == i + 1;
            } else if (b) {
                b = v == 8 - i;
            }

            if (!a && !b) break;
        }

        if (a) System.out.println("ascending");
        else if (b) System.out.println("descending");
        else System.out.println("mixed");
    }
}
