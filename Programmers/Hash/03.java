package Hash;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

class Solution03 {
    public int solution(String[][] clothes) {
        HashMap<String, Integer> m = new HashMap<String, Integer>();
        for (String[] cloth: clothes) {
            String cloth_type = cloth[1];
            if (m.containsKey(cloth_type)) {
                int count = m.get(cloth_type);
                m.put(cloth_type, count + 1);
            } else {
                m.put(cloth_type, 1);
            }
        }

        AtomicInteger answer = new AtomicInteger(1);
        m.forEach((cloth_type, count) -> {
            answer.updateAndGet(v -> v * (count + 1));
        });

        answer.updateAndGet(v -> v - 1);

        return answer.get();
    }
}