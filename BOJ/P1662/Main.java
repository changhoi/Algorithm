package P1662;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Main {

    static int[] decoder (char[] list, int startIdx, int repeat) {
        int len = 0;
        int lastIdx = startIdx;

        while (true) {
            if (list[lastIdx] == ')') {
                return new int[] {len * repeat, lastIdx};
            }

            if (list[lastIdx + 1] == '(') {
                int[] decoded = decoder(list, lastIdx + 2, list[lastIdx] - '0');
                len += decoded[0];
                lastIdx = decoded[1] + 1;
                continue;
            }

            len++;
            lastIdx++;
        }
    }

    public static void main (String[] args) throws Exception {
        System.setIn(new FileInputStream("src/P1662/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] line = br.readLine().toCharArray();

        int len = 0;

        for (int i = 0; i < line.length; i++) {
            if (i + 1 < line.length && line[i + 1] == '(') {
                int[] decoded = decoder(line, i + 2, line[i] - '0');
                len += decoded[0];
                i = decoded[1];
                continue;
            }

            len++;
        }



        System.out.println(len);
    }
}
