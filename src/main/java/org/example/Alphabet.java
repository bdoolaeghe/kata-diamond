package org.example;

import java.util.List;

public class Alphabet {

    private final List<Character> alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".chars()
            .mapToObj(c -> (char) c)
            .toList();

    public List<Character> lettersUntil(char lastLetter) {
        if (!alphabet.contains(lastLetter)) {
            throw new IllegalArgumentException("Invalid last letter: " + lastLetter);
        }
        return alphabet.subList(0, alphabet.indexOf(lastLetter) + 1 );
    }

}
