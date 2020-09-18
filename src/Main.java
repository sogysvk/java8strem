import entity.Person;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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
                .sorted()
                .forEach(System.out::println);


        List<Person> persons =
                Arrays.asList(
                        new Person("Max", 18),
                        new Person("Peter", 23),
                        new Person("Pamela", 23),
                        new Person("David", 12));

        List<Person> filtered =
                persons
                        .stream()
                        .filter(p -> p.getName().startsWith("P"))
                        .collect(Collectors.toList());

        System.out.println(filtered);
        System.out.println();

        Person result =
                persons
                        .stream()
                        .reduce(new Person("", 0), (p1, p2) -> {
                            p1.setAge(p1.getAge() + p2.getAge());
                            p1.setName(p1.getName() + p2.getName());
                            return p1;
                        });

        System.out.format("name=%s; age=%s", result.getName(), result.getAge());
        Integer ageSum = persons
                .stream()
                .reduce(0,
                        (sum, p) -> {
                            System.out.format("accumulator: sum=%s; person=%s\n", sum, p);
                            return sum += p.getAge();
                        },
                        (sum1, sum2) -> {
                            System.out.format("combiner: sum1=%s; sum2=%s\n", sum1, sum2);
                            return sum1 + sum2;
                        });


    }
}