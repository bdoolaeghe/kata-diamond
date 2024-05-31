package org.example.diamond;

import java.util.List;

record Row(int letterIndex, List<Character> letters) {

    @Override
    public String toString() {
        if (letterIndex == 0) {
            return diamondSpikeRow();
        } else {
            return diamondInsideRow();
        }
    }

    private String diamondInsideRow() {
        var letter = letters.get(letterIndex);
        var leftPadding = letters.size() - letterIndex - 1;
        var middlePadding = 2 * letterIndex - 1;
        return spaces(leftPadding) +
               letter +
               spaces(middlePadding) +
               letter;
    }

    private String diamondSpikeRow() {
        var letter = letters.get(letterIndex);
        var leftPadding = letters.size() - 1;
        return spaces(leftPadding) + letter;
    }

    private static String spaces(int i) {
        return " ".repeat(i);
    }

}
