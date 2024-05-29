package org.example;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class DiamondTest {

    @Test
    void should_create_single_char_diamond() {
        assertThat(Diamond.create('A')).isEqualTo("A");
    }

    @Test
    void should_create_small_diamond_with_C() {
        assertThat(Diamond.create('C')).isEqualTo(
        """
                  A
                 B B
                C   C
                 B B
                  A
                """
        );
    }

    @Test
    void should_create_big_diamond_with_D() {
        assertThat(Diamond.create('D')).isEqualTo(
        """
                   A
                  B B
                 C   C
                D     D
                 C   C
                  B B
                   A
                """
        );
    }

    @Test
    void should_not_support_non_alphabetic_letter_as_input() {
        assertThatThrownBy(() -> Diamond.create('1'))
                .isInstanceOf(RuntimeException.class);
    }
}