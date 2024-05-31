package org.example.diamond;

import java.util.List;

class Alphabet {

    private final List<Character> alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".chars()
            .mapToObj(c -> (char) c)
            .toList();

    List<Character> lettersUntil(char lastLetter) {
        if (!alphabet.contains(lastLetter)) {
            throw new IllegalArgumentException(String.format("Invalid last letter: %s", lastLetter));
        }
        return alphabet.subList(0, alphabet.indexOf(lastLetter) + 1 );
    }

}
