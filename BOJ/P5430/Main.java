package P5430;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Objects;

public class Main {
    static String solution (char[] commands, String[] arr, int len) {
        boolean reversed = false;

        int head = 0;
        int tail = len - 1;

        for (char c : commands) {
            if (c == 'R') {
                reversed = !reversed;
            } else {
                if (tail < head) return "error";

                if (reversed) {
                    tail--;
                } else {
                    head++;
                }
            }
        }

        StringBuilder ret = new StringBuilder();
        if (reversed) {
            for (int i = tail; i >= head; i--) {
                ret.append(arr[i]);
                if (i != head) ret.append(",");
            }
        } else {
            for (int i = head; i <= tail; i++) {
                ret.append(arr[i]);
                if (i != tail) ret.append(",");
            }
        }

        return ret.toString();
    }

    public static void main (String[]args) throws Exception {
        System.setIn(new FileInputStream("src/P5430/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            char[] commands = br.readLine().toCharArray();
            int len = Integer.parseInt(br.readLine());

            String[] arr = br.readLine().replace("[", "").replace("]", "").split(",");

            String ret = solution(commands, arr, len);

            if (Objects.equals(ret, "error")) System.out.println(ret);
            else {
                System.out.println("[" + ret + "]");
            }
        }
    }
}
