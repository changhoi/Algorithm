package P2407;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
    static BigInteger combination(int n, int m) {
        BigInteger a = BigInteger.ONE;
        BigInteger b = BigInteger.ONE;
        for (int i = 0; i < m; i++) {
            a = a.multiply(new BigInteger(String.valueOf(n - i)));
            b = b.multiply(new BigInteger(String.valueOf(i + 1)));
        }

        return a.divide(b);
    }

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/P2407/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        System.out.println(combination(n, m));
    }
}
