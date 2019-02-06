import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<String> listOfStrings =
                Arrays.asList("a1", "a2", "c2", "c1", "b3", "b2", "b1");

        System.out.println("start with c and sorted");
        listOfStrings
                .stream()
                .filter(s -> s.startsWith("c"))
                .map(String::toUpperCase)
                .sorted()
                .forEach(System.out::println);

        System.out.println("\ncontains 1 and sorted");
        listOfStrings
                .stream()
                .filter(a -> a.contains("1"))
                .sorted()
                .forEach(System.out::println);

        List<String> listOf = Arrays.asList("c6", "a3", "a1", "b2", "a8", "a2", "a5", "a7");
        System.out.println("\nfirst in list");
        listOf
                .stream()
                .findFirst()
                .ifPresent(System.out::println);

        System.out.println("\nfind any parallel stream");
        listOf
                .parallelStream()
                .findAny()
                .ifPresent(System.out::println);

        System.out.println("\nshow list parallel stream");
        listOf
                .parallelStream()
                .forEach(System.out::println);
    }
}