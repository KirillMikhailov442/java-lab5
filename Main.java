import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int task = 0;
        int subtask = 0;

        while (true) {
            System.out.print("Введите номер задания: ");
            if (scanner.hasNextInt()) {
                task = scanner.nextInt();
                break;
            } else {
                System.out.println("Некорректное число");
                scanner.next();
            }
        }

        while (true) {
            System.out.print("Введите номер задачи: ");
            if (scanner.hasNextInt()) {
                subtask = scanner.nextInt();
                break;
            } else {
                System.out.println("Некорректное число");
                scanner.next();
            }
        }

        if (task == 1 && subtask == 1) {
            Fraction f1 = new Fraction(-3, -4);
            Fraction f2 = new Fraction(3, 4);

            System.out.println(f1);
            System.out.println(f2);

            System.out.println(f1.equals(f2));
            System.out.println(f1.getRealValue());
        }

        else if (task == 2 && subtask == 1) {

        }

        else if (task == 3 && subtask == 4) {
            List<Integer> L = new ArrayList<>(Arrays.asList(1, 2, 3, 2, 4));
            System.out.println("Исходный список: " + L);
            ListInserter.insertAfterFirstOccurrence(L, 2);
            System.out.println("После вставки:   " + L);
        }

        else if (task == 4 && subtask == 6) {
            AbiturientFilter.run();
        }

        else if (task == 5 && subtask == 8) {
            AlphabetChecker.run();
        }

        else if (task == 6 && subtask == 2) {
            List<Integer> list = Arrays.asList(1, 2, 3);
            Queue<Integer> queue = CustomQueue.buildQueueFromList(list);
            System.out.println(queue);
        }

        else if (task == 7 && subtask == 1) {
            List<Point> inputPoints = Arrays.asList(
                    new Point(3, -2),
                    new Point(1, 4),
                    new Point(3, 2),
                    new Point(1, -4),
                    new Point(2, -3),
                    new Point(0, 0),
                    new Point(2, 3));
            Polyline polyline = PolylineBuilder.buildPolyline(inputPoints);
            System.out.println(polyline);
        }

        else if (task == 7 && subtask == 2) {
            try {
                Map<Integer, List<String>> result = PeopleGrouping.groupPeopleByNumber("people.txt");
                System.out.println(result);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
