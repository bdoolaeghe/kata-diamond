package org.example.diamond;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class AlphabetTest {

    Alphabet alphabet = new Alphabet();

    @Test
    void should_generate_letters_until_A() {
        assertThat(alphabet.lettersUntil('A')).isEqualTo(List.of('A'));
    }

    @Test
    void should_generate_letters_until_C() {
        assertThat(alphabet.lettersUntil('C')).containsExactly('A', 'B', 'C');
    }

    @Test
    void should_generate_letters_until_Z() {
        assertThat(alphabet.lettersUntil('Z')
                .stream()
                .map(String::valueOf)
                .collect(Collectors.joining()))
                .isEqualTo("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
    }

    @Test
    void should_raise_error_when_not_a_supported_letter() {
        assertThatThrownBy(() -> alphabet.lettersUntil('1'))
                .isInstanceOf(IllegalArgumentException.class);
    }
}