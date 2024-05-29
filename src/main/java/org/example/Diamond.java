package org.example;

import org.apache.commons.lang3.StringUtils;

import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;

public class Diamond {

    private static Alphabet alphabet = new Alphabet();

    public static void main(String[] args) {
        System.out.println(Diamond.create('C'));
    }

    public static String create(char lastLetter) {
        var letters = alphabet.lettersUntil(lastLetter);
        var halfSize = letters.size();
        var size = 2 * halfSize - 1;
        var rows = new String[size];

        if (halfSize == 1) {
            return letters.getFirst().toString();
        } else {
            var firstRow = padLeft(letters.getFirst(), halfSize);
            rows[0] =  firstRow;
            rows[size -1 ] = firstRow;

            for (int i = 1; i < halfSize; i++) {
                var letter = letters.get(i);
                var row = padLeft(letter, halfSize - i) +
                          spaces(2 * i - 1) +
                          letter;
                rows[i] = row;
                rows[size - (i+1)] = row;
            }

            return Stream.of(rows)
                    .map(row -> STR."""
                                    \{row}
                                    """)
                    .collect(joining());
        }
    }

    private static String spaces(int i) {
        return " ".repeat(i);
    }

    private static String padRight(Character c, int length) {
        return String.format("%1$-" + length + "s", String.valueOf(c));
    }

    private static String padLeft(Character c, int length) {
        return StringUtils.leftPad(c.toString(), length);
    }

}
