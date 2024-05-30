package org.example;

import org.apache.commons.lang3.StringUtils;

public record Row(char letter, int rowIndex, int diamondCardinality) {

    @Override
    public String toString() {
        if (letter == 'A') {
            return diamondSpikeRow();
        } else {
            return diamondInsideRow();
        }
    }

    private String diamondInsideRow() {
        return leftPad(letter, diamondCardinality - rowIndex) +
               spaces(2 * rowIndex - 1) +
               letter;
    }

    private String diamondSpikeRow() {
        return leftPad(letter, diamondCardinality);
    }

    private static String spaces(int i) {
        return " ".repeat(i);
    }

    private static String leftPad(Character c, int length) {
        return StringUtils.leftPad(c.toString(), length);
    }
}
