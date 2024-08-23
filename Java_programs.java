
import java.util.*;
import java.util.Arrays;
import java.util.List;
import java.util.Collection;
import java.util.stream.Collectors;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.HashMap;
import java.util.stream.*;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.StringJoiner;
import java.util.Comparator;

public class Java_programs {
    public static void main(String[] arrgs) {


        List<Integer> l1 = Arrays.asList(14, 892, 14, 112, 621, 112, 21, 15, 19, 823);
        //Find First elemet occurance
        List<Integer> first_num = l1.stream().findFirst().stream().collect(Collectors.toList());
        System.out.println(first_num);
        // find the total numbers
        long Total_num = l1.stream().count();
        System.out.println(Total_num);
        // find the elements start with one
        List<Integer> first_seq = l1.stream().filter(n -> String.valueOf(n).startsWith("1")).collect(Collectors.toList());
        System.out.println(first_seq);
        // find the element is even
        List<Integer> even_num = l1.stream().filter(n -> n % 2 == 0).collect(Collectors.toList());
        System.out.println(even_num);

        // Sorted all all values in
        List<Integer> sorted_num = l1.stream()
                .sorted()
                .collect(Collectors.toList());

        System.out.println(sorted_num);
        //sorting a list of employees based on their salary(ascending order).

        List<Integer> sorted_Desc = l1.stream()
                .sorted((a, b) -> b.compareTo(a))
                .collect(Collectors.toList());
        System.out.println(sorted_Desc);

        List<Integer> Without_Dup_num = l1.stream().distinct().collect(Collectors.toList());
        // finding duplicate numbers in list
        System.out.println(Without_Dup_num);
        Set<Integer> set = new HashSet();
        l1.stream()
                .filter(n -> !set.add(n))
                .forEach(System.out::println);
        //find the Max values
        Optional<Integer> max_num = l1.stream().max(Integer::compare);
        System.out.println(max_num);
        // Count Occurrence of each character in String using Java 8

        String input = "vinaykumaraluri";
        Map<String, Long> string_occur = Arrays.stream(input.split("")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(string_occur);

        List<String> list1 = Arrays.asList("A", "B", "C");
        List<String> list2 = Arrays.asList("D", "E", "F");
        //
        Stream<String> combinedStream = Stream.concat(list1.stream(), list2.stream());
        //
        combinedStream.forEach(System.out::print);

        // length greter than 5
        List<String> strings = Arrays.asList("Java", "Python", "JavaScript", "C#", "Ruby", "Scala", "Kotlin");

        long count = strings.stream()
                .filter(s -> s.length() > 5)
                .count();
        System.out.println(count);
        // joing using delimiter
        StringJoiner sj = new StringJoiner(", ", "[", "]");
        sj.add("John")
                .add("Doe")
                .add("Jane");

        String result = sj.toString();
        System.out.println(result); // Output: [John, Doe, Jane]

        // String input
        String in = "2,3,34,,5,5,4,3,3,3";

        Map<String, Long> counts = Arrays.stream(in.split(","))
                .filter(s -> !s.isEmpty())
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        counts.forEach((key, value) -> System.out.println(key + "-" + value));
        // thread creation
        Thread thread = new Thread(() -> {
            System.out.println("Thread running...");
        });

        thread.start();
        // lower to upper case
        List<String> countries = Arrays.asList("USA", "Japan", "France", "Germany", "Italy", "U.K.", "Canada");

        String res = countries.stream()
                .map(String::toUpperCase)
                .collect(Collectors.joining(", "));

        System.out.println("Joined and uppercase countries: " + res);

        //squaring the numbers
        List<Integer> num = Arrays.asList(9, 10, 3, 4, 7, 3, 4);

        List<Integer> squares = num.stream()
                .distinct()
                .map(n -> n * n)
                .collect(Collectors.toList());

        System.out.println("Squares of distinct numbers: " + squares);

        List<Integer> numbers = Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29);


        // Min value
        OptionalInt min = numbers.stream().mapToInt(Integer::intValue).min();
        int minValue = min.orElseThrow(() -> new RuntimeException("List is empty"));
        System.out.println(minValue);
        // Max value
        OptionalInt max = numbers.stream().mapToInt(Integer::intValue).max();
        int maxValue = max.orElseThrow(() -> new RuntimeException(" List is empty Average  knew"));
        System.out.println(maxValue);


        //repeated
        String str1 = "abcdefgghijk";

        Optional<Character> firstRepeated = str1.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.toCollection(LinkedHashSet::new))
                .stream()
                .filter(c -> str1.indexOf(c) != str1.lastIndexOf(c))
                .findFirst();

        firstRepeated.ifPresent(System.out::println);

        // non repeated
        Optional<Character> firstNonRepeated = str1.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(c -> c, LinkedHashMap::new, Collectors.counting()))
                .entrySet().stream()
                .filter(entry -> entry.getValue() == 1L)
                .map(Map.Entry::getKey)
                .findFirst();

        firstNonRepeated.ifPresent(System.out::println);


            //toggled string
       String str4 = "telCo";
       String venkat=str4.chars()
               .mapToObj(c -> {  c =Character.isUpperCase(c) ? Character.toLowerCase(c) : Character.toUpperCase(c);
                   return String.valueOf((char) c);
               })
               .collect(Collectors.joining());
               System.out.println(venkat);

          //first most repeated word in a sentence using Java 8

        String sentence = "Java is a programming language. Java is widely used for backend development.";

        if (sentence == null || sentence.trim().isEmpty()) {
            System.out.println(""); // Handle null or empty sentence case
        }

        // Split sentence into words, convert to lowercase, and collect into a map with word counts
        Map<String, Long> wordCountMap = Stream.of(sentence.toLowerCase().split("\\s+"))
                .collect(Collectors.groupingBy(word -> word, Collectors.counting()));

        // Find the word with the maximum count

        String mostRepeatedWord = wordCountMap.entrySet().stream()
                .max(Comparator.comparing(Map.Entry::getValue))
                .map(Map.Entry::getKey)
                .orElse("");

          System.out.println(mostRepeatedWord);


        // duplicate count list
                List<String> names = Arrays.asList("Java", "Spring", "JPA", "Java", "Cloud", "JPA");
                Map<String, Long> namesCount = names.stream().filter(x -> Collections.frequency(names, x) > 1)
                        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
                System.out.println(namesCount);

        int i[] = { 4, 5, 13, 22 };
        int j[] = { 0, 9, 3, 7, 12, 11 };
        List<Integer> sortedList= Stream.concat(Arrays.stream(i).boxed(), Arrays.stream(j).boxed()).sorted()
                .collect(Collectors.toList());
        System.out.println(sortedList);

        List<Integer> oddList = Arrays.asList(1, 3, 5, 7, 9, 11);
        List<Integer> evenList = Arrays.asList(2, 4, 6, 8, 10);
        List<List<Integer>> listOfList = Arrays.asList(oddList, evenList);
        System.out.println(listOfList);
        List<Integer> flatList = listOfList.stream().flatMap(list -> list.stream()).collect(Collectors.toList());

        System.out.println(flatList);

        String input2 = "Java Stream API is very good concept";

        char firstNotRepetedChar = input2.chars().mapToObj(x -> Character.toUpperCase((char) x))//converting the object format
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))// find duplicate freq in linkedHashMap
                .entrySet().stream().filter(x -> x.getValue() == 1L)
                .map(x -> x.getKey()).findFirst().get();//filtering the freq which is not first time

        System.out.println("First non repeated char  : " + firstNotRepetedChar);

    }

}
