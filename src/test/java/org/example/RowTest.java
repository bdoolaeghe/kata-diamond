package org.example;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RowTest {

    @Test
    void should_draw_diamond_spike_row() {
        var spikeRow = new Row('A', 0, 2).toString();
        assertThat(spikeRow).isEqualTo(" A");
    }

    @Test
    void should_draw_diamond_inside_row() {
        var insideRow = new Row('B', 1, 3).toString();
        assertThat(insideRow).isEqualTo(" B B");
    }

    @Test
    void should_draw_diamond_largest_inside_row() {
        var insideRow = new Row('B', 1, 2).toString();
        assertThat(insideRow).isEqualTo("B B");
    }
}