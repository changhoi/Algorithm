package P2562;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int maxVal = 0, maxIdx = -1;
        for (int i = 0; i < 9; i++) {
            int val = Integer.parseInt(br.readLine());
            if (maxVal < val) {
                maxIdx = i + 1;
                maxVal = val;
            }
        }

        System.out.println(maxVal);
        System.out.println(maxIdx);
    }
}
