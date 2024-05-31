package org.example.diamond;

import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;

public class Diamond {

    private static Alphabet alphabet = new Alphabet();

    private final List<Character> letters;
    private final Row[] rows;

    public Diamond(char letter) {
        this.letters = alphabet.lettersUntil(letter);
        this.rows = new Row[height()];
        fillRows();
    }

    public static Diamond create(char lastLetter) {
        return new Diamond(lastLetter);
    }

    private int height() {
        return 2 * cardinality() - 1;
    }

    private int cardinality() {
        return letters.size();
    }

    private void fillRows() {
        for (int letterIndex = 0; letterIndex < cardinality(); letterIndex++) {
            var row = new Row(letterIndex, letters);
            setAndMirror(letterIndex, row);
        }
    }

    private void setAndMirror(int index, Row row) {
        rows[index] = row;
        rows[height() - (index + 1)] = row;
    }

    @Override
    public String toString() {
        return Stream.of(rows)
                .map(row -> row + "\n")
                .collect(joining());
    }
}
