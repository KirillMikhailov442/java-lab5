import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Set;

public class AlphabetChecker {
    public static void run() {
        String filePath = "alphabetInput.txt";

        Set<Character> russianAlphabet = new HashSet<>();
        for (char c = 'а'; c <= 'я'; c++) {
            russianAlphabet.add(c);
        }
        russianAlphabet.add('ё');

        Set<Character> foundLetters = new HashSet<>();

        try {
            String content = Files.readString(Paths.get(filePath));

            for (char c : content.toLowerCase().toCharArray()) {
                if (russianAlphabet.contains(c)) {
                    foundLetters.add(c);
                }
            }

            int missingCount = 0;
            for (char letter : russianAlphabet) {
                if (!foundLetters.contains(letter)) {
                    missingCount++;
                }
            }
            System.out.println("Количество букв русского алфавита, не встречающихся в тексте: " + missingCount);

        } catch (IOException e) {
            System.err.println("Ошибка при чтении файла: " + e.getMessage());
        }
    }
}