package org.example;

import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;

public class Diamond {

    private static Alphabet alphabet = new Alphabet();

    private final char lastLetter;
    private final List<Character> letters;
    private final int cardinality;
    private final int diamondHeight;
    private final String view;

    public Diamond(char lastLetter) {
        this.lastLetter = lastLetter;
        this.letters =  alphabet.lettersUntil(lastLetter);
        this.cardinality = letters.size();
        this.diamondHeight = 2 * cardinality - 1;
        this.view = toView(computeDiamondRows());
    }

    public static Diamond create(char lastLetter) {
        return new Diamond(lastLetter);
    }

    @Override
    public String toString() {
        return view;
    }

    private Row[] computeDiamondRows() {
        var rows = new Row[diamondHeight];
        for (int rowIndex = 0; rowIndex < cardinality; rowIndex++) {
            var letter = letters.get(rowIndex);
            var row = new Row(letter, rowIndex, cardinality);
            rows[rowIndex] = row;
            rows[diamondHeight - (rowIndex + 1)] = row;
        }
        return rows;
    }

    private static String toView(Row[] rows) {
        return Stream.of(rows)
                .map(row -> row + "\n")
                .collect(joining());
    }

}
