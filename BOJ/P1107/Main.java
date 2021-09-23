package P1107;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static boolean[] broken;
    static int origin;
    static int approximateNum = Integer.MAX_VALUE;

    static boolean buildable(int num) {
        if (num == 0) return !broken[num];

        while (num > 0) {
            if (broken[num % 10]) return false;
            num /= 10;
        }

        return true;
    }

    static void setApproximateNum(int n) {
        int digit = Integer.toString(n).length();
        approximateNum = Math.min(digit + Math.abs(n - origin), approximateNum);
    }

    static void getApproximateNum() {
        if (buildable(origin)) {
            setApproximateNum(origin);
            return;
        }

        for (int i = origin + 1; i <= 1000000; i++) {
            if (!buildable(i)) continue;
            setApproximateNum(i);
            break;
        }

        for (int i = origin - 1; i >= 0; i--) {
            if (!buildable(i)) continue;
            setApproximateNum(i);
            break;
        }
    }

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/P1107/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String n = br.readLine();
        origin = Integer.parseInt(n);
        int m = Integer.parseInt(br.readLine());
        broken = new boolean[10];
        if (m > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < m; i++) broken[Integer.parseInt(st.nextToken())] = true;
        }

        // 직접 버튼 올리기
        // 변경 후 올리기

        int direct = Math.abs(origin - 100);
        if (m == 10) {
            System.out.println(direct);
            return;
        }
        getApproximateNum();
        System.out.println(Math.min(direct, approximateNum));
    }
}
