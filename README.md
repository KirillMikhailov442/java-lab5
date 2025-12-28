# Михайлов Кирилл ИТ-4 Лабораторная №5

# Задание 1
## Задача 1
### Текст задачи
 В	 класс	Дробь,	 добавить	интерфейс	на	 два	метода:	 получение	 вещественного	 значения,	 установка	
числителя	и	установка	знаменателя.
Сгенерировать	 такую	 версию	 дроби,	 которая	 будет	 кэшировать	 вычисление	 вещественного	
значения.
Если	 раннее	 в	 вашем	 варианте	 не	 было	 Дроби,	 то	 создайте	 сущность Дробь	 со	 следующими	
особенностями:
* Имеет	числитель:	целое	число
* Имеет	знаменатель:	целое	число
* Дробь	может	быть	создана	с	указанием	числителя	и	знаменателя	
* Может	вернуть	строковое	представление	вида	“числитель/знаменатель”
* Необходимо корректно обрабатывать отрицательные значения. Учтите, что знаменатель не может
быть отрицательным.
* Переопределите	метод	сравнения	объектов	по	состоянию	таким	образом,	чтобы	две	дроби	
считались	одинаковыми	тогда, когда	у	них	одинаковые	значения	числителя	и	знаменателя.

### Алгоритм решения
```java
import java.util.Objects;

public class Fraction implements FractionOperations {
    private int numerator;
    private int denominator;
    private Double cachedRealValue;

    public Fraction(int numerator, int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("Знаменатель не может быть равен нулю.");
        }
        normalizeSign(numerator, denominator);
        this.cachedRealValue = null;
    }

    private void normalizeSign(int num, int den) {
        if (den < 0) {
            this.numerator = -num;
            this.denominator = -den;
        } else {
            this.numerator = num;
            this.denominator = den;
        }
        invalidateCache();
    }

    private void invalidateCache() {
        this.cachedRealValue = null;
    }

    @Override
    public double getRealValue() {
        if (cachedRealValue == null) {
            cachedRealValue = (double) numerator / denominator;
        }
        return cachedRealValue;
    }

    @Override
    public void setNumerator(int numerator) {
        this.numerator = numerator;
        normalizeSign(this.numerator, this.denominator);
    }

    @Override
    public void setDenominator(int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("Знаменатель не может быть равен нулю.");
        }
        this.denominator = denominator;
        normalizeSign(this.numerator, this.denominator);
    }

    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Fraction fraction = (Fraction) o;
        return numerator == fraction.numerator &&
                denominator == fraction.denominator;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numerator, denominator);
    }
}
```

# Задание 2
## Задача 1
### Текст задачи
Количество мяуканий.
Необходимо воспользоваться классом Кот и методом принимающим всех мяукающих из задачи 2.5.4.
Необходимо таким образом передать кота в указанный метод, что бы после окончания его работы
узнать сколько раз мяукал кот за время его работы. На рисунке показан пример работы. Перед вызовом
метода создаем кота, отправляем ссылку на кота в метод, после окончания его работы выводим
количество мяуканий на экран. Кота изменять нельзя.
Если	раннее	в	вашем	варианте	не	было	Кота,	то	создайте	
1. сущность	Кот,	которая	описывается	следующим	образом:
* Имеет	Имя	(строка)
* Для	создания	необходимо	указать	имя	кота.
* Может	быть	приведен	к	текстовой	форме	вида:	“кот:	Имя”
* Может	 помяукать,	 что	 приводит	 к	 выводу	 на	 экран	 следующего	 текста:	“Имя:	мяу!”,	
вызвать	мяуканье	можно	без	параметров.
2. интерфейс	 Мяуканье: разработайте метод, который принимает набор объектов способных
мяукать и вызывает мяуканье у каждого объекта. Мяукающие объекты должны иметь метод со
следующей сигнатурой:
public void meow();

### Алгоритм решения
```java
public interface Meowable {
    void meow();
}

public class MeowUtils {
    public static void makeAllMeow(Collection<Meowable> meowables) {
        for (Meowable m : meowables) {
            m.meow();
        }
    }
}

class CountingCatWrapper implements Meowable {
    private final Cat cat;
    private int meowCount = 0;

    public CountingCatWrapper(Cat cat) {
        this.cat = cat;
    }

    @Override
    public void meow() {
        cat.meow();
        meowCount++;
    }

    public int getMeowCount() {
        return meowCount;
    }
}
```

# Задание 3
## Задача 4
### Текст задачи
Составить	 программу,	 которая	 вставляет	 в	 список	 L	 за	 первым	 вхождением	 элемента	 E	 все	
элементы	списка	L,	если	E	входит	в	L.

### Алгоритм решения
```java
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
```

# Задание 4
## Задача 6
### Текст задачи
В	 некотором	 вузе	 абитуриенты	 проходили	 предварительное	 тестирование,	 по	 результатам	
которого	 они	 могут	 быть	 допущены	 к	 сдаче	 вступительных	 экзаменов	 в	 первом	 потоке.	
Тестирование	проводится	по	трём	предметам,	по	каждому	предмету	абитуриент	может	набрать	
от	 0	 100	 баллов.	 При	 этом	 к	 сдаче	 экзаменов	 в	 первом	 потоке	 допускаются	 абитуриенты,	
набравшие	 по	 результатам	 тестирования	 не	 менее	 30	 баллов	 по	 каждому	 из	 трёх	 предметов,	
причём	 сумма	 баллов	 должна	 быть	 не	 менее	 140.	 На	 вход	 программы	 подаются	 сведения	 о	
результатах	 предварительного	 тестирования.	 Известно,	 что	 общее	 количество	 участников	
тестирования	не	превосходит	500.
В	 первой	 строке	 вводится	 количество	 абитуриентов,	 принимавших	 участие	 в	 тестировании,	N.	
Далее	следуют	N строк,	имеющих	следующий	формат:
<Фамилия><Имя><Баллы>
Здесь	<Фамилия> – строка,	состоящая	не	более	чем	из	20	символов;	<Имя> – строка,	состоящая	не	
более	 чем	 из	 15	 символов,	 <Баллы> – строка,	 содержащая	 два	 целых	 числа,	 разделенных	
пробелом	 – баллы,	 полученные	 на	 тестировании	 по	 каждому	 из	 трёх	 предметов.	 При	 этом	
<Фамилия> и	<Имя>,	<Имя> и	<Баллы> разделены	одним	пробелом.	Пример	входной	строки:
Романов	Вельямин	48	39	55
Напишите	программу,	которая	будет	выводить	на	экран	фамилии	и	имена	абитуриентов,	
допущенных	 к	 сдаче	 экзаменов	 в	 пер

### Алгоритм решения
```java
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
```

# Задание 5
## Задача 8
### Текст задачи
Файл	содержит	текст	на	русском	языке.	Сколько	букв	русского	алфавита	не	встречается	в	этом	
тексте?

### Алгоритм решения
```java
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
```

# Задание 6
## Задача 2
### Текст задачи
По	 списку	 L	 построить	 очередь (например,	 по	 списку	 из	 элементов	 1,	 2,	 3	 требуется	 построить	
очередь	из	элементов	1,	2,	3,	3,	2,	1).

### Алгоритм решения
```java
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
```

# Задание 7
## Задача 1
### Текст задачи
Необходимо	написать	стрим:
Дан	 набор	 объектов	 типа	 Point,	 необходимо	 взять	 все	 Point	 в	 разных	 координатах,	 убрать	 с	
одинаковыми	X,Y, отсортировать	по	X,	отрицательные	Y	сделать	положительными	и	собрать	это	
все	в	ломаную	(объект	типа	Polyline)
Если	раннее	в	вашем	варианте	не	было	задание	с	классом	Point и	Polyline,	то	написать	их:
1. класс	Point:
• Координата	Х:	число.		
• Координата	Y:	число.
• Может	возвращать	текстовое	представление	вида	“{X;Y}”.
2. класс	Line (Линия),	расположенная на	двумерной	плоскости,	которая	описывается:
• Координата	начала:	Точка
• Координата	конца:	Точка
• Может	возвращать	текстовое	представление	вида	“Линия	от	{X1;Y1}	до	{X2;Y2}”
3. класс	 Polyline (Ломаная),	 которая	 будет	 представлять	 собой	 ломаную	 линию.	 Ломаная	
линия	представляет	собой	набор	следующих	характеристик:		
• Имеет	массив	Точек,	через	которые	линия	проходит.
• Может	 быть	 приведена	 к	 строковой	 форме	 вида	 “Линия	 [Т1,T2,…,TN]”,	 где	 TN	 – это	
результат	приведения	к	строке	Точки	с	номером	N

### Алгоритм решения
```java
import java.util.*;
import java.util.stream.Collectors;

public class PolylineBuilder {
    public static Polyline buildPolyline(List<Point> points) {
        List<Point> result = points.stream()
                .distinct()
                .map(p -> new Point(p.getX(), Math.abs(p.getY())))
                .distinct()
                .sorted(Comparator.comparingDouble(Point::getX))
                .collect(Collectors.toList());

        return new Polyline(result);
    }

}
```

## Задача 2
### Текст решения
Дан	текстовый	файл	со строками, содержащими	имя	человека	и	его	номер	в	следующей	форме:
Вася:5
Петя:3
Аня:5
Номера	людей	могут	повторяться. У	каких-то	людей	может	не	быть	номера.
Необходимо	написать	стрим выполняющую	следующее:
читаются	 все	 люди	 из	 файла,	 все	 имена	 приводится	 к	 нижнему	 регистру,	 но	 с	 первой	 буквой	 в	
верхнем	регистре,	убираем	из	перечня	всех	людей	без	номеров,	а	имена	оставшихся	группируются	
по	их	номеру:
[5:[Вася,	Аня],	3:[Петя]]

### Алгоритм решения
```java
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
```