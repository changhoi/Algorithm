package P3190;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static String direction = "right";
    static int[][] board;
    static int[] snakeHead = {1, 1};
    static Queue<int[]>  snakeTail = new LinkedList<>();

    static void print (int answer) {
        System.out.println("********************************");
        System.out.println("DIRECTION: " + direction);
        for (int[] b : board) {
            for(int t : b) {
                System.out.print(String.format("%4d", t));
            }
            System.out.println();
        }
        System.out.println("Seconds: " + answer);
        System.out.println("********************************");
    }

    static void forward() {
        if (Objects.equals(direction, "right")) snakeHead[1] += 1;
        if (Objects.equals(direction, "left")) snakeHead[1] -= 1;
        if (Objects.equals(direction, "up")) snakeHead[0] -= 1;
        if (Objects.equals(direction, "down")) snakeHead[0] += 1;
    }

    static int check() {
        int x = snakeHead[0];
        int y = snakeHead[1];
        int ret = board[x][y];
        board[x][y] = -1;

        return ret;
    }

    static void shrink() throws Exception {
        if (snakeTail.isEmpty()) throw new Exception();
        int[] location = snakeTail.poll();
        board[location[0]][location[1]] = 0;
    }



    static void updateDirection(String handle) {
        if (Objects.equals(handle, "L")) {
            if (Objects.equals(direction, "right")) direction = "up";
            else if (Objects.equals(direction, "left")) direction = "down";
            else if (Objects.equals(direction, "up")) direction = "left";
            else if (Objects.equals(direction, "down")) direction = "right";
            return;
        }

        if (Objects.equals(direction, "right")) direction = "down";
        else if (Objects.equals(direction, "left")) direction = "up";
        else if (Objects.equals(direction, "up")) direction = "right";
        else if (Objects.equals(direction, "down")) direction = "left";
    }

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/P3190/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());

        board = new int[N + 2][N + 2];

        for (int i = 0; i < N + 2; i++) {
            board[0][i] = -1;
            board[N + 1][i] = -1;
            board[i][0] = -1;
            board[i][N + 1] = -1;
        }

        for (int i = 0; i < K; i++) {
            String[] location = br.readLine().split(" ");
            int x = Integer.parseInt(location[0]);
            int y = Integer.parseInt(location[1]);
            board[x][y] = 1;
        }

        board[1][1] = -1;
        snakeTail.add(new int[]{1, 1});

        int answer = 0;

        int L = Integer.parseInt(br.readLine());

        for(int i = 0; i < L; i++) {
            String[] command = br.readLine().split(" ");

            int seconds = Integer.parseInt(command[0]);

            while (seconds > answer) {
                answer++;
                forward();
                int boardValue = check();
                if (boardValue == -1) {
                    System.out.println(answer);
                    return;
                }

                if (boardValue == 0) {
                    shrink();
                }

                snakeTail.add(Arrays.copyOf(snakeHead, 2));

                print(answer);
            }
            updateDirection(command[1]);
        }

        while (true) {
            answer++;
            forward();
            int boardValue = check();
            if (boardValue == -1) {
                System.out.println(answer);
                return;
            }

            if (boardValue == 0) {
                shrink();
            }

            snakeTail.add(Arrays.copyOf(snakeHead, 2));
            print(answer);
        }
    }

}
