package P3425;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Main {
    static List<String> commands = new ArrayList<>();
    static Stack<Long> stack;
    static long MAX = (long) Math.pow(10, 9);
    static long MIN = -MAX;

    static void numX(long x) {
        stack.add(x);
    }

    static void pop() throws Exception {
        if (stack.isEmpty()) throw new Exception();
        stack.pop();
    }

    static void inv() throws Exception {
        if (stack.isEmpty()) throw new Exception();
        Long v = stack.pop();
        stack.add(-v);
    }

    static void dup() throws Exception {
        if (stack.isEmpty()) throw new Exception();
        stack.add(stack.peek());
    }

    static void swp() throws Exception {
        if (stack.size() < 2) throw new Exception();
        long v1 = stack.pop();
        long v2 = stack.pop();

        stack.add(v1);
        stack.add(v2);
    }

    static void add() throws Exception {
        if (stack.size() < 2) throw new Exception();
        long v1 = stack.pop();
        long v2 = stack.pop();
        stack.add(v1 + v2);
    }

    static void sub() throws Exception {
        if (stack.size() < 2) throw new Exception();
        long v1 = stack.pop();
        long v2 = stack.pop();
        stack.add(v2 - v1);
    }

    static void mul() throws Exception {
        if (stack.size() < 2) throw new Exception();
        long v1 = stack.pop();
        long v2 = stack.pop();
        stack.add(v2 * v1);
    }

    static void div() throws Exception {
        if (stack.size() < 2) throw new Exception();
        long v1 = stack.pop();
        long v2 = stack.pop();
        stack.add(v2 / v1);
    }

    static void mod() throws Exception {
        if (stack.size() < 2) throw new Exception();
        long v1 = stack.pop();
        long v2 = stack.pop();
        stack.add(v2 % v1);
    }


    static void operate(long n) {
        stack = new Stack<>();
        stack.add(n);
        try {
            for (String c : commands) {
                if (c.startsWith("NUM")) {
                    String[] num = c.split(" ");
                    numX(Integer.parseInt(num[1]));
                } else if (c.equals("POP")) {
                    pop();
                } else if (c.equals("INV")) {
                    inv();
                } else if (c.equals("DUP")) {
                    dup();
                } else if (c.equals("SWP")) {
                    swp();
                } else if (c.equals("ADD")) {
                    add();
                } else if (c.equals("SUB")) {
                    sub();
                } else if (c.equals("MUL")) {
                    mul();
                } else if (c.equals("DIV")) {
                    div();
                } else if (c.equals("MOD")) {
                    mod();
                }
            }
            if (stack.size() >= 2) throw new Exception();
            long v = stack.pop();
            if (v > MAX || v < MIN) throw new Exception();
            System.out.println(v);
        } catch (Exception e) {
            System.out.println("ERROR");
        }
    }

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/P3425/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean numInput = false;
        while (true) {
            String c = br.readLine();
            if (c.equals("QUIT")) break;
            if (c.equals("END")) {
                numInput = true;
                continue;
            }
            if (c.equals("")) {
                numInput = false;
                commands = new ArrayList<>();
                System.out.println();
            } else if (numInput) {
                int n = Integer.parseInt(c);
                for (int i = 0; i < n; i++) {
                    Long num = Long.parseLong(br.readLine());
                    operate(num);
                }
            } else {
                commands.add(c);
            }
        }

    }
}
