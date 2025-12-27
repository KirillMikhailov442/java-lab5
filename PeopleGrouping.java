import java.io.IOException;
import java.nio.file.Files;
import java.util.*;
import java.util.stream.Collectors;

public class PeopleGrouping {
    public static Map<Integer, List<String>> groupPeopleByNumber(String filePath) throws IOException {
        return Files.lines(java.nio.file.Path.of(filePath))
                .map(line -> line.split(":", 2))
                .filter(parts -> parts.length == 2 && !parts[1].isEmpty())
                .collect(Collectors.groupingBy(
                        parts -> Integer.parseInt(parts[1]),
                        Collectors.mapping(
                                parts -> capitalize(parts[0].trim()),
                                Collectors.toList())));
    }

    private static String capitalize(String name) {
        if (name == null || name.isEmpty()) {
            return name;
        }
        return name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();
    }

    public static void main(String[] args) {
        try {
            Map<Integer, List<String>> result = groupPeopleByNumber("people.txt");
            System.out.println(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}