import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class Task3 {
    public static ArrayList<Integer> Swap(ArrayList<Integer> arr) {
        if (arr == null || arr.size() <= 1) return arr;

        Deque<Integer> stackQueue = new ArrayDeque<>();
        stackQueue.addFirst(arr.get(0));

        for (int i = 1; i < arr.size(); i++) {
            stackQueue.addFirst(arr.get(i));

            if (i != arr.size() - 1) {
                int last = stackQueue.removeLast();
                stackQueue.addFirst(last);
            }
        }

        ArrayList<Integer> result = new ArrayList<>(stackQueue);
        return result;
    }
}