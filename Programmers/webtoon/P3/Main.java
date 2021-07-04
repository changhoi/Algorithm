package webtoon.P3;

public class Main {
    static char[] sarr, tarr, stack;
    static int top = 0;

    static public boolean isMatch() {
        int len = tarr.length;
        for (int i = 1; i <= len; i++) {
            if(stack[top - i] != tarr[len - i]) return false;
        }
        return true;
    }

    static public int solution(String s, String t) {
        sarr = s.toCharArray();
        tarr = t.toCharArray();
        stack = new char[sarr.length];

        int ans = 0;
        for (char c : sarr) {
            stack[top++] = c;
            if (isMatch()) {
                System.out.println("MATCH!");
                top -= tarr.length;
                ans++;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        solution("aabcbcd", "abc");
    }
}
