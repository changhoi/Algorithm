package P1629;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int C;

    static int multiply(long a, long b) {
        long ret = (a * b) % C;
        return (int) ret;
    }

    static int solution(int A, int B) {
        if (B <= 1) return A;
        int half = solution(A, B / 2);

        if (B % 2 == 1) return multiply(multiply(half, half), A);
        return multiply(half, half);
    }

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/P1629/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        if (B == 1) {
            System.out.println(A % C);
            return;
        }

        System.out.println(solution(A, B));
    }
}
