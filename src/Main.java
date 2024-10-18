import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scientist[] scientists = {
                new Scientist("Ycheniy1", 1060, "female", "physics"),
                new Scientist("Ycheniy2", 1915, "female", "computer science"),
                new Scientist("Ycheniy3", 2000, "female", "physics"),
                new Scientist("Ycheniy4", 1920, "female", "physics"),
                new Scientist("Ycheniy800", 800, "female", "physics"),
                new Scientist("Ycheniy5", 1920, "female", "pe"),

                new Scientist("Ycheniy6", 1005, "male", "physics"), //5
                new Scientist("Ycheniy7", 1979, "male", "foreign language"),
                new Scientist("Ycheniy8", 1001, "male", "physics"), //1
                new Scientist("Ycheniy9", 1912, "male", "computer science"),
                new Scientist("Ycheniy10", 1008, "male", "physics") //8
        };

        String fieldOfScience = "physics";
        int N = 3;

        System.out.println(N + " ученых зовут: " + String.join(", ",
                Arrays.stream(scientists)
                        .filter(s -> s.getGender().equals("female") && s.getField().equals(fieldOfScience))
                        .sorted(Comparator.comparingInt(Scientist::getBirthYear))
                        .limit(N)
                        .sorted(Comparator.comparingInt(Scientist::getBirthYear).reversed())
                        .map(Scientist::getLastName)
                        .collect(Collectors.toList())) + ";");
                        //самого большого возраста и в порядке уменьшения года рождения +


        String[] words = {"Арбуз", "Яблоко", "Банан", "Дыня", "Дыня", "Банан", "Арбуз", "Яблоко", "Банан", "Арбуз"};

        System.out.println("Самое частое слово (последнее по алфавитному порядку): " +
                Arrays.stream(words)
                        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                        .entrySet().stream()
                        .sorted((Comparator.comparing((Map.Entry<String, Long> e) -> e.getValue()).reversed())
                        .thenComparing(Map.Entry::getKey, Comparator.reverseOrder()))
                        .map(Map.Entry::getKey)
                        .findFirst()
                        .orElse(null)
                        //упростить +
        );
    }
}