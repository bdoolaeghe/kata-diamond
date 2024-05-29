package org.example;

import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;

public class Diamond {

    private static Alphabet alphabet = new Alphabet();

    public static void main(String[] args) {
        System.out.println(Diamond.create('C'));
    }

    public static String create(char lastLetter) {
        var letters = alphabet.lettersUntil(lastLetter);

        if (letters.size() == 1) {
            return createSingleRowDiamond(lastLetter);
        } else {
            return createMultipleRowDiamond(letters);
        }
    }

    private static String createSingleRowDiamond(Character letter) {
        return letter.toString();
    }

    private static String createMultipleRowDiamond(List<Character> letters) {
        var cardinality = letters.size();
        var diamondHeight = 2 * cardinality - 1;
        var rows = new String[diamondHeight];

        fillDiamondSpikes(letters.getFirst(), cardinality, rows);
        fillDiamondInside(letters, rows);

        return format(rows);
    }

    private static void fillDiamondInside(List<Character> letters, String[] rows) {
        var cardinality = letters.size();
        var diamondHeight = 2 * cardinality - 1;
        
        for (int rowIndex = 1; rowIndex < cardinality; rowIndex++) {
            var letter = letters.get(rowIndex);
            var innerRow = createInnerRow(letter, cardinality, rowIndex);
            rows[rowIndex] = innerRow;
            rows[diamondHeight - (rowIndex + 1)] = innerRow;
        }
    }

    private static String createInnerRow(Character letter, int cardinality, int rowIndex) {
        return leftPad(letter, cardinality - rowIndex) +
               spaces(2 * rowIndex - 1) +
               letter;
    }

    private static void fillDiamondSpikes(Character letter, int leftPadding, String[] rows) {
        var diamondHeight = 2 * leftPadding - 1;
        var spikeRow = createSpikeRow(letter, leftPadding);
        rows[0] =  spikeRow;
        rows[diamondHeight - 1 ] = spikeRow;
    }

    private static String createSpikeRow(Character letter, int leftPadding) {
        return leftPad(letter, leftPadding);
    }

    private static String format(String[] rows) {
        return Stream.of(rows)
                .map(row -> row + "\n")
                .collect(joining());
    }

    private static String spaces(int i) {
        return " ".repeat(i);
    }

    private static String leftPad(Character c, int length) {
        return StringUtils.leftPad(c.toString(), length);
    }

}
