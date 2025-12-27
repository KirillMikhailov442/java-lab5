import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class AbiturientFilter {
    public static void run() {
        Scanner scanner = new Scanner(System.in);
        PrintWriter writer = null;

        try {
            if (!scanner.hasNextInt()) {
                System.err.println("Ошибка: первая строка должна содержать целое число N.");
                return;
            }
            int n = scanner.nextInt();
            if (n < 0 || n > 500) {
                System.err.println("Ошибка: N должно быть от 0 до 500.");
                return;
            }
            scanner.nextLine();

            writer = new PrintWriter(new FileWriter("output.txt"));

            for (int i = 0; i < n; i++) {
                if (!scanner.hasNextLine()) {
                    System.err.println("Ошибка: не хватает данных. Ожидалось " + n + " строк, получено " + i + ".");
                    break;
                }

                String line = scanner.nextLine().trim();
                if (line.isEmpty()) {
                    System.err.println("Предупреждение: пропущена пустая строка (номер " + (i + 1) + ").");
                    continue;
                }

                String[] tokens = line.split("\\s+");

                if (tokens.length < 4) {
                    System.err.println("Ошибка в строке " + (i + 1) + ": недостаточно данных.");
                    continue;
                }

                String lastName = tokens[0];
                String firstName = tokens[1];

                if (tokens.length != 5) {
                    System.err.println("Ошибка в строке " + (i + 1) + ": должно быть ровно 3 балла.");
                    continue;
                }

                int[] scores = new int[3];
                boolean valid = true;

                for (int j = 0; j < 3; j++) {
                    try {
                        scores[j] = Integer.parseInt(tokens[2 + j]);
                        if (scores[j] < 0 || scores[j] > 100) {
                            System.err.println(
                                    "Ошибка в строке " + (i + 1) + ": балл " + (j + 1) + " вне диапазона [0, 100].");
                            valid = false;
                            break;
                        }
                    } catch (NumberFormatException e) {
                        System.err.println(
                                "Ошибка в строке " + (i + 1) + ": балл " + (j + 1) + " не является целым числом.");
                        valid = false;
                        break;
                    }
                }

                if (!valid) {
                    continue;
                }

                if (scores[0] >= 30 && scores[1] >= 30 && scores[2] >= 30) {
                    int total = scores[0] + scores[1] + scores[2];
                    if (total >= 140) {
                        writer.println(lastName + " " + firstName);
                    }
                }
            }

        } catch (IOException e) {
            System.err.println("Ошибка при работе с файлом: " + e.getMessage());
        } finally {
            if (writer != null) {
                writer.close();
            }
            scanner.close();
        }
    }
}