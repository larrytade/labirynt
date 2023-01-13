package com.company.Exe.Mitko.puzzle;

public class Main {
    public static void main(String[] args) {
        Point start = new Point(1,6);
        Mitko mitko = new Mitko();
        mitko.solve(start);
    }
}