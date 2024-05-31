package org.example;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RowTest {

    @Test
    void should_draw_diamond_spike_row() {
        var letters = List.of('A', 'B', 'C');
        var spikeRow = new Row(0, letters).toString();
        assertThat(spikeRow).isEqualTo("  A");
    }

    @Test
    void should_draw_diamond_inside_row() {
        var letters = List.of('A', 'B', 'C');
        var insideRow = new Row(1, letters).toString();
        assertThat(insideRow).isEqualTo(" B B");
    }

    @Test
    void should_draw_diamond_largest_row() {
        var letters = List.of('A', 'B', 'C');
        var insideRow = new Row(2, letters).toString();
        assertThat(insideRow).isEqualTo("C   C");
    }
}