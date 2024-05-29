package org.example;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DiamondTest {

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
}