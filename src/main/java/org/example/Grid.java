package org.example;

import com.google.common.collect.ArrayTable;
import com.google.common.collect.Table;

import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class Grid {

    private final Table<Integer, Integer, String> table;
    private final int minX;
    private final int maxX;
    private final int minY;
    private final int maxY;

    public Grid(int maxX, int maxY) {
        if (maxX <= 0 || maxY <= 0)
            throw new IllegalArgumentException("invalid grid dimensions");
        this.minX = -maxX;
        this.maxX = maxX;
        this.minY = -maxY;
        this.maxY = maxY;
        this.table = ArrayTable.create(
                IntStream.rangeClosed(-maxX, maxX).boxed().collect(toList()),
                IntStream.rangeClosed(-maxY, maxY).boxed().collect(toList())
        );
    }

    public Grid set(int x, int y, String value) {
        if (!contains(x, y)) {
            throw new IllegalArgumentException(String.format("coordinates out of grid: (%d, %d)", x, y));
        }
        table.put(y, x, value);
        return this;
    }

    public String get(int x, int y) {
        return table.get(y, x);
    }

    private boolean contains(int x, int y) {
        return (x <= maxX &&
                x >= minX &&
                y <= maxY &&
                y >= minY);
    }

}
