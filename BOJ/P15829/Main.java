package P15829;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Main {
    static long M = 1234567891;
    static long r = 31;

    static long hashing(char[] arr) {
        long sum = 0;

        for (int i = 0; i < arr.length;i ++) {
            long val = arr[i] - 'a' + 1;
            for (int j = 0; j < i; j++) {
                val *= r;
                val %= M;
            }

            sum += val;
            sum %= M;
        }

        return sum % M;
    }

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/P15829/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int L = Integer.parseInt(br.readLine());
        char[] arr= br.readLine().toCharArray();

        System.out.println(hashing(arr));
    }
}
