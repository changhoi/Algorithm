package P10775;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Main {
    static int G, P;
    static int[] gates, planes;

    static boolean setGates(int plane) {
        boolean success = false;
        for (int i = plane - planes[plane]; i > 0; i--) {
            if (gates[i] == 0) {
                gates[i] = plane;
                success = true;
                break;
            }
        }

        return success;
    }

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/P10775/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        G = Integer.parseInt(br.readLine());
        P = Integer.parseInt(br.readLine());

        gates = new int[G + 1];
        planes = new int[G + 1];
        int cnt = 0;

        for (int i = 0; i < P; i++) {
            int plane = Integer.parseInt(br.readLine());
            if (setGates(plane)) {
                cnt++;
                planes[plane]++;
            } else break;
        }

        System.out.println(cnt);
    }
}
