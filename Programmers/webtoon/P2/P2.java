package webtoon.P2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P2 {
    static public String[] solution(String s) {
        List<String> list = new ArrayList<>();
        char[] sarr = s.toCharArray();
        int top = sarr.length - 1;
        int end = top;
        int head = 0;
        int len = 0;

        while (true) {
            if (top < (sarr.length + 1) / 2) {
                String rest = String.valueOf(sarr, head, end - head + 1);
                if(rest.length() > 0) list.add(list.size() / 2, rest);
                break;
            }
            if (sarr[head] == sarr[top]) {
                String forward = String.valueOf(sarr, head, len + 1);
                String backward = String.valueOf(sarr, top, len + 1);

                if (forward.equals(backward)) {
                    list.add(list.size() / 2, forward);
                    list.add(list.size() / 2, forward);
                    top--;
                    end = top;
                    head += len + 1;
                    len = 0;
                    continue;
                }
            }
            top--;
            len++;
        }

        String[] ans = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution("aa")));
    }
}
