package gr.codehub.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamTest {
    public static void main(String[] args) {
        List<String> items =
                Arrays.asList(new String[]{"one", "two", "three"});

        Stream<String> stream = items.stream();

        long count = stream
                .map((value) -> { return value.toLowerCase(); })
                .count();

        System.out.println(count);

    }
}
