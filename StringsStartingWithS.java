
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringsStartingWithS {

    public static void main(String[] args) {

       String[] inputArray = {"apple", "sample", "search", "cat"};


        //List<String> result = Arrays.asList("apple", "sample", "search", "cat").stream()
        List<String> result = Arrays.stream(inputArray)
                .filter(s -> s.startsWith("s"))
                .collect(Collectors.toList());


        System.out.println(result);
    }
}
