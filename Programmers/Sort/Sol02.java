package Sort;

import java.util.*;

class Solution02 {
    static char[] makeCharArray(String s) {
        char[] carr = s.toCharArray();
        char[] ret = new char[4];

        for (int i = 0; i < 4; i++) {
            ret[i] = carr[i % carr.length];
        }

        return ret;
    }

    public String solution(int[] numbers) {
        List<String> list = new ArrayList<String>();
        for (int n : numbers) {
            list.add(Integer.toString(n));
        }

        list.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                char[] s1 = makeCharArray(o1);
                char[] s2 = makeCharArray(o2);

                for (int i = 0; i < 4; i++) {
                    int val1 = Integer.parseInt(String.valueOf(s1[i]));
                    int val2 = Integer.parseInt(String.valueOf(s2[i]));
                    if (val1 > val2) return -1;
                    else if (val1 < val2) return 1;
                }

                return 0;
            }
        });

        if (list.get(0).equals("0")) return "0";

        StringBuilder answer = new StringBuilder();
        for (String s : list) {
            answer.append(s);
        }

        return answer.toString();
    }
}