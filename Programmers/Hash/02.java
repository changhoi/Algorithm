package Hash;

class Solution02 {
    public boolean solution(String[] phone_book) {
        int len = phone_book.length;

        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                String standard = phone_book[i];
                String target = phone_book[j];



                if (standard.length() > target.length()) {
                    String temp = standard;
                    standard = target;
                    target = temp;
                }

                if (target.startsWith(standard)) {
                    return false;
                }
            }
        }
        return true;
    }
}