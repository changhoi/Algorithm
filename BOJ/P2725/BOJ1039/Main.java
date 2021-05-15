package BOJ.BOJ1039;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/BOJ/BOJ1039/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        char[] carr = st.nextToken().toCharArray();

        int count = Integer.parseInt(st.nextToken());
        int len = carr.length;

        for (int i = 0; i < count; i++) {
            
        }

        for (int i = 0; i < len; i++) {
            char c = carr[i];
            int val = Integer.parseInt(String.valueOf(c));
        }
    }
}