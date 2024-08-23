package kajal;

import java.time.LocalDate;
import java.time.Period;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.Optional;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
public class practice {
    public static void main(String[] args) {

        List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);


        //1. Using Java 8 Stream API to get the last element of the List
        Optional<Integer> optionalLastElement = list1.stream()
                .reduce((first, second) -> second);

        if (optionalLastElement.isPresent()) {
            Integer lastElement = optionalLastElement.get();
            System.out.println("Last element of the List: " + lastElement);


            //2.Write a Java 8 program to find the first non-repeated character in a string.
            Optional<Character> firstNonRepeated = str1.chars()
                    .mapToObj(c -> (char) c)
                    .collect(Collectors.groupingBy(c -> c, LinkedHashMap::new, Collectors.counting()))
                    .entrySet().stream()
                    .filter(entry -> entry.getValue() == 1L)
                    .map(Map.Entry::getKey)
                    .findFirst();




            //3.Write a Java 8 program to calculate the age of a person in years given their birthday
            String birthDate = "1994-01-22";
            LocalDate localBirthDate = LocalDate.parse(birthDate);
            LocalDate currentDate = LocalDate.now();
            Period age = Period.between(localBirthDate, currentDate);
            System.out.println(age.getYears());


            //4.Given a list of strings, write a Java 8 program to find the strings that start with a number.
            List<String> names = Arrays.asList("vinay", "kumar", "123456");
            names.stream().filter(x -> x.matches("^[0-9].*")).forEach(System.out::println);
            System.out.println(names);

            //5.Write a Java 8 program to reverse each word of a given string ‘Hello Capgemini, Good Day!’ using the stream API and lambda expressions.
            String string = "Hello Capgemini, Good Day!";
            String reversedString = Stream.of(string.split("//s")).map(x -> new StringBuilder(x).reverse().toString()).collect(Collectors.joining());
            System.out.println(reversedString);


            //6.Write a Java 8 program to find the sum and average of all elements in an integer array.
            List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
            int sum = integers.stream().reduce(Integer::sum).get();
            OptionalDouble average = integers.stream().mapToInt(Integer::intValue).average();
            System.out.println("The Sum of integers is: " + sum);
            System.out.println("The Average of integers is: " + average);


            //7.Write a Java 8 program to sort a given list of strings according to the increasing order of their length
            List<Integer> sort = Arrays.asList(23, 81, 49, 54, 19, 7, 97, 72, 33, 69);
            sort.stream().sorted((e1, e2) -> e2.compareTo(e1)).forEach(System.out::println);


            //8.Write a Java 8 program to check if two strings are anagrams or not using the stream API and lambda expressions.
            String word = "abcd";
            String anagram = "dcba";
            String s2 = Stream.of(word.split("")).map(String::toUpperCase).sorted().collect(Collectors.joining());

            String s3 = Stream.of(anagram.split("")).map(String::toUpperCase).sorted().collect(Collectors.joining());

            if (s2.equals(s3)) {
                System.out.println("Two strings are anagrams");
            } else {
                System.out.println("Two strings are not anagrams");
            }

            System.out.println("------------------------------------------------------------------------");

            //9.Write a Java 8 program to print the numbers from a given list of integers that are multiples of 5.
            List<Integer> list3 = Arrays.asList(10, 23, 25, 67, 98, 90, 105, 35);
            list3.stream().filter(x -> x % 5 == 0).sorted().forEach(System.out::println);
            System.out.println("---------------------------------------------------------------------------");

            //10.Write a Java 8 program to find the frequency of each character in a given string using the stream API and collectors.
            String St = "I am Java Developer";
            Map<String, Long> string_occur = Arrays.stream(St.split("")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
            System.out.println(string_occur);

        }


    }}