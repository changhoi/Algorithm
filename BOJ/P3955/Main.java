package DAY04.P3955;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    static int N, A, B;

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        // X : 인당 나눠줄 사탕의 수
        // Y : 사탕 봉지의 수
        // A * x + 1 = B * y
        // Ax + By = C 의 형태로 변환.
        // -Ax + By = 1
        for (int i = 0; i < N; i++) {
            A = sc.nextInt();
            B = sc.nextInt();

            ExtendedGcdResult result = extendedGcd(-A, B);
//          System.out.println(result);
            // D = gcd(A,B)
            // Ax + By = C 일때 C % D == 0 이어야 해를 가질 수 있음 : 베주 항등식
            if (Math.abs(result.gcd) != 1) {
                System.out.println("IMPOSSIBLE");
            } else {
                // x0 = s * C/D
                // y0 = t * C/D
                long y = result.t / result.gcd;
                long x = result.s / result.gcd;
                // x = x0 + B/D * k
                // y = y0 - A/D * k
                while (y <= 0 || x <= 0) {
                    x += B;
                    y -= -A;
                    if (y > 1e9) {
                        break;
                    }
                }
//              System.out.println(y + ", " + x);
                if (y > 1e9) {
                    System.out.println("IMPOSSIBLE");
                } else {
                    System.out.println(y);
                }
            }
        }

    }

    public static ExtendedGcdResult extendedGcd(long a, long b) {
        long s0 = 1, t0 = 0, r0 = a;
        long s1 = 0, t1 = 1, r1 = b;

        long temp;

        while (r1 != 0) {
            long q = r0 / r1;

            temp = r0 - q * r1;
            r0 = r1;
            r1 = temp;

            temp = s0 - q * s1;
            s0 = s1;
            s1 = temp;

            temp = t0 - q * t1;
            t0 = t1;
            t1 = temp;

//          System.out.println(r + ", " + s + ", " + t);
        }

        return new ExtendedGcdResult(s0, t0, r0);
    }
}

class ExtendedGcdResult {
    long s;
    long t;
    long gcd;

    public ExtendedGcdResult(long s, long t, long gcd) {
        super();
        this.s = s;
        this.t = t;
        this.gcd = gcd;
    }

    @Override
    public String toString() {
        return "ExtendedGcdResult [s=" + s + ", t=" + t + ", gcd=" + gcd + "]";
    }

}
