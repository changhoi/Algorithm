package P10775;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/P10775/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int G = Integer.parseInt(br.readLine());
        int P = Integer.parseInt(br.readLine());
        int[] gates = new int[G + 1];

        int cnt = 0;
        for (int i = 0; i < P; i++) {
            int gi = Integer.parseInt(br.readLine());
            boolean success = false;
            for (int j = gi; j > 0; j--) {
                if (gates[j] == 0) {
                    success = true;
                    gates[j] = gi;
                    break;
                } else continue;
            }
            if (!success) break;
            cnt++;
        }

        System.out.println(cnt);
    }
}
