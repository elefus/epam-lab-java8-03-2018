package streams.part2.exercise;

import org.junit.Test;

import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;
import static org.junit.Assert.assertEquals;

public class Exercise3 {

    @Test
    public void createLimitedStringWithOddNumbersSeparatedBySpaces() {
        int countNumbers = 10;

        String result = Stream.iterate(1, val -> val + 2)
                                .limit(countNumbers)
                                .mapToInt(Integer::valueOf)
                                .mapToObj(String::valueOf)
                                .collect(joining(" "));;

        assertEquals("1 3 5 7 9 11 13 15 17 19", result);
    }

    @Test
    public void extractEvenNumberedCharactersToNewString() {
        String source = "abcdefghijklm";

        String result = IntStream.range(0, source.length())
                                                 .filter(index -> index % 2 == 0)
                                                 .map(source::charAt)
                                                 .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                                                 .toString();

        assertEquals("acegikm", result);
    }
}
