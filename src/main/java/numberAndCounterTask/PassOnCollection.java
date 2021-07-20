package numberAndCounterTask;

import java.util.*;

public class PassOnCollection {
    public static void getElementAndCounter(ArrayList<Integer> data) {
        HashMap<Integer, Integer> numbers = new HashMap<>();
        for (int i : data) {
            if (numbers.containsKey(i)) {
                numbers.put(i, numbers.get(i) + 1);
            } else {
                numbers.put(i, 1);
            }
        }

        numbers.forEach((a, b) -> System.out.println(a + " : " + b));
    }

    public static void main(String[] args) {
        ArrayList<Integer> data = new ArrayList<>(Arrays.asList(4, 5, -6, 4, 5, 3, 4, 2, 4, 5, 7));
        getElementAndCounter(data);
    }
}
