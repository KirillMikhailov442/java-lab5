import java.util.Collection;

public class MeowUtils {
    public static void makeAllMeow(Collection<Meowable> meowables) {
        for (Meowable m : meowables) {
            m.meow();
        }
    }
}