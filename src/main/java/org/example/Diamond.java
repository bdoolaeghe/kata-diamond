package org.example;

import java.util.List;

public class Diamond {

    public static void main(String[] args) {
        System.out.println(Diamond.create('C'));
    }

    public static String create(char letter) {
        return new Diamond(letter).toString();
    }

    private Alphabet alphabet = new Alphabet();
    private Grid grid;

    public Diamond(char letter) {
        this.grid = fillGrid(alphabet.lettersUntil(letter));
    }

    private Grid fillGrid(List<Character> letters) {
        var grid = new Grid(letters.size() - 1);
        fillTopLeftCorner(letters, grid);
        grid.mirrorRightToLeft();;
        grid.mirrorTopToBottom();
        return grid;
    }

    private static void fillTopLeftCorner(List<Character> letters, Grid grid) {
        int x = 0;
        int y = letters.size() - 1;
        for (var letter : letters) {
            grid.set(x++, y-- , letter.toString());
        }
    }

    @Override
    public String toString() {
        return grid.toString();
    }
}
