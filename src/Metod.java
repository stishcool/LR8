import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Scientist {
    String lastName;
    int birthYear;
    String gender;
    String field;

    public Scientist(String lastName, int birthYear, String gender, String field) {
        this.lastName = lastName;
        this.birthYear = birthYear;
        this.gender = gender;
        this.field = field;
    }
}

public class Metod {
    public static void main(String[] args) {
        Scientist[] scientists = {
                new Scientist("Ycheniy1", 1967, "female", "physics"),
                new Scientist("Ycheniy2", 1979, "male", "physics"),
                new Scientist("Ycheniy3", 1912, "male", "computer science"),
                new Scientist("Ycheniy4", 1920, "female", "chemistry"),
                new Scientist("Ycheniy5", 1942, "female", "physics"),
                new Scientist("Ycheniy6", 1915, "female", "computer science")
        };
        poisk(scientists, 2, "physics");
    }

    private static void poisk(Scientist[] scientists, int n, String field) {
        List<String> femSc = Arrays.stream(scientists)
                .filter(scientist -> "female".equals(scientist.gender) && field.equals(scientist.field))
                .sorted((s1, s2) -> Integer.compare(s2.birthYear, s1.birthYear))
                .limit(n)
                .map(scientist -> scientist.lastName)
                .collect(Collectors.toList());

        System.out.println(n + " ученых зовут: " + String.join("; ", femSc));
    }
}
