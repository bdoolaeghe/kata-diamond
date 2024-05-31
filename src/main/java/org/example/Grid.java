package org.example;

import com.google.common.collect.ArrayTable;
import com.google.common.collect.Table;

import java.util.Optional;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class Grid {

    private final Table<Integer, Integer, String> table;
    private final int minX;
    private final int maxX;
    private final int minY;
    private final int maxY;

    public Grid(int maxXAndY) {
        this(maxXAndY, maxXAndY);
    }

    public Grid(int maxX, int maxY) {
        if (maxX < 0 || maxY < 0)
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
        table.put(y, x, value);
        return this;
    }

    public String get(int x, int y) {
        return table.get(y, x);
    }

    @Override
    public String toString() {
        var gridBuffer = new StringBuilder();
        for (int y = maxY; y >= minY; y--) {
            var rowBuffer = new StringBuilder();
            for (int x = minX; x <= maxX; x++) {
                var value = get(x, y);
                rowBuffer.append(Optional.ofNullable(value).orElse(" "));
            }
            gridBuffer.append(rowBuffer.toString().stripTrailing());
            gridBuffer.append("\n");
        }
        return gridBuffer.toString();
    }
}
