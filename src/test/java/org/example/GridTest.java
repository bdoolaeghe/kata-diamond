package org.example;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class GridTest {

    @Nested
    class SetGet {

        @Test
        void should_set_and_get_in_grid() {
            var grid = new Grid(2, 2);
            grid.set(1, 2, "a value");
            assertThat(grid.get(1, 2)).isEqualTo("a value");
        }

        @Test
        void should_fail_setting_out_of_grid() {
            var grid = new Grid(2, 2);
            assertThatThrownBy(() -> grid.set(100, 100, "a value")).isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        void should_default_cell_to_null() {
            var grid = new Grid(1, 1);
            assertThat(grid.get(0, 0)).isNull();
        }

    }

    @Nested
    class ToString {

        @Test
        void should_toString_a_filled_grid() {
            var grid = new Grid(1, 1);
            grid.set(0, 1, "A");
            grid.set(-1, 0, "B");
            grid.set(1, 0, "B");
            grid.set(0, -1, "A");
            assertThat(grid.toString()).isEqualTo(
                    """
                     A
                    B B
                     A
                    """);
        }
    }

}