import java.util.ArrayList;
import java.util.List;

public class ListInserter {
    public static <T> void insertAfterFirstOccurrence(List<T> L, T E) {
        int index = L.indexOf(E);
        if (index == -1) {
            return;
        }
        List<T> originalCopy = new ArrayList<>(L);
        L.addAll(index + 1, originalCopy);
    }
}
