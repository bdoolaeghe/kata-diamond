package org.example;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class GridTest {

    @Test
    void should_set_and_get_in_grid() {
        var grid = new Grid(2, 2);
        grid.set(1,2, "a value");
        assertThat(grid.get(1, 2)).isEqualTo("a value");
    }

    @Test
    void should_fail_setting_out_of_grid() {
        var grid = new Grid(2, 2);
        assertThatThrownBy(() -> grid.set(100,100, "a value")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void should_default_cell_to_null() {
        var grid = new Grid(1, 1);
        assertThat(grid.get(0, 0)).isNull();
    }
}