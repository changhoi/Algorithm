package DAY03.P9663;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Main {
    static int N;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/DAY03/P9663/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

    }
}

/**
 * s
 */
