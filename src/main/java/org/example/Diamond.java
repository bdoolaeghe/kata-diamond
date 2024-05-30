package org.example;

import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;

public class Diamond {

    private static Alphabet alphabet = new Alphabet();

    private final char lastLetter;
    private final List<Character> letters;
    private final int cardinality;
    private final int diamondHeight;
    private final String[] rows;
    private final String view;

    public Diamond(char lastLetter) {
        this.lastLetter = lastLetter;
        this.letters =  alphabet.lettersUntil(lastLetter);
        this.cardinality = letters.size();
        this.diamondHeight = 2 * cardinality - 1;
        this.rows = new String[diamondHeight];
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
        if (letters.size() == 1) {
            return computeSingleRowDiamond(lastLetter);
        } else {
            return computeMultipleRowDiamond(letters);
        }
    }

    private String computeSingleRowDiamond(Character letter) {
        return letter.toString();
    }

    private String computeMultipleRowDiamond(List<Character> letters) {
        fillDiamondSpikes(letters.getFirst(), cardinality, rows);
        fillDiamondInside(letters, rows);
        return toView(rows);
    }

    private void fillDiamondInside(List<Character> letters, String[] rows) {
        for (int rowIndex = 1; rowIndex < cardinality; rowIndex++) {
            var letter = letters.get(rowIndex);
            var innerRow = createInnerRow(letter, cardinality, rowIndex);
            rows[rowIndex] = innerRow;
            rows[diamondHeight - (rowIndex + 1)] = innerRow;
        }
    }

    private String createInnerRow(Character letter, int cardinality, int rowIndex) {
        return leftPad(letter, cardinality - rowIndex) +
               spaces(2 * rowIndex - 1) +
               letter;
    }

    private void fillDiamondSpikes(Character letter, int leftPadding, String[] rows) {
        var spikeRow = createSpikeRow(letter, leftPadding);
        rows[0] =  spikeRow;
        rows[diamondHeight - 1 ] = spikeRow;
    }

    private String createSpikeRow(Character letter, int leftPadding) {
        return leftPad(letter, leftPadding);
    }

    private static String spaces(int i) {
        return " ".repeat(i);
    }

    private static String leftPad(Character c, int length) {
        return StringUtils.leftPad(c.toString(), length);
    }

    private static String toView(String[] rows) {
        return Stream.of(rows)
                .map(row -> row + "\n")
                .collect(joining());
    }

}
