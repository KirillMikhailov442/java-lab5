import java.util.*;

public class CustomQueue {
    public static Queue<Integer> buildQueueFromList(List<Integer> list) {
        Queue<Integer> queue = new LinkedList<>();

        for (Integer item : list) {
            queue.offer(item);
        }

        for (int i = list.size() - 1; i >= 0; i--) {
            queue.offer(list.get(i));
        }

        return queue;
    }
}
