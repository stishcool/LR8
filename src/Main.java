import java.util.Arrays;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        String[] words = {"Apple", "Banana", "Apple", "Banana", "Pineapple", "Melon", "Apple", "Banana", "Watermelon", "Lemon"};

        String result = Arrays.stream(words)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .collect(Collectors.groupingBy(Map.Entry::getValue, Collectors.mapping(Map.Entry::getKey, Collectors.toCollection(TreeSet::new))))
                .entrySet().stream()
                .max(Map.Entry.comparingByKey())
                .map(longTreeSetEntry -> longTreeSetEntry.getValue().last())
                .orElse("");

        System.out.println("Наиболее часто встречающееся слово (последнее по алфавиту): " + result);
    }
}