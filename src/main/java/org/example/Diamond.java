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
    private final Row[] rows;
    private final String view;

    public Diamond(char lastLetter) {
        this.lastLetter = lastLetter;
        this.letters =  alphabet.lettersUntil(lastLetter);
        this.cardinality = letters.size();
        this.diamondHeight = 2 * cardinality - 1;
        this.rows = new Row[diamondHeight];
        this.view = computeDiamondView();
    }

    public static Diamond create(char lastLetter) {
        return new Diamond(lastLetter);
    }

    @Override
    public String toString() {
        return view;
    }

    private String computeDiamondView() {
        if (lastLetter == 'A') {
            return computeSingleRowDiamond(lastLetter);
        } else {
            return computeMultipleRowDiamond(letters);
        }
    }

    private String computeSingleRowDiamond(Character letter) {
        return letter.toString();
    }

    private String computeMultipleRowDiamond(List<Character> letters) {
        fillDiamondSpikes(letters.getFirst(), rows);
        fillDiamondInside(letters, rows);
        return toView(rows);
    }

    private void fillDiamondInside(List<Character> letters, Row[] rows) {
        for (int rowIndex = 1; rowIndex < cardinality; rowIndex++) {
            var letter = letters.get(rowIndex);
            var innerRow = new Row(letter, rowIndex, cardinality);
            rows[rowIndex] = innerRow;
            rows[diamondHeight - (rowIndex + 1)] = innerRow;
        }
    }

    private void fillDiamondSpikes(Character letter, Row[] rows) {
        var spikeRow = new Row(letter, 0, cardinality);
        rows[0] =  spikeRow;
        rows[diamondHeight - 1 ] = spikeRow;
    }


    private static String toView(Row[] rows) {
        return Stream.of(rows)
                .map(row -> row + "\n")
                .collect(joining());
    }

}
