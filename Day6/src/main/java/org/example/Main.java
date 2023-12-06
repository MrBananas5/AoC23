package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        Scanner sc = new Scanner(new File("C:/Users/pek14/Documents/Advent of Code/AoC23/Day6/src/main/java/org/example/input6.txt"));
        Races t = new Races("7  15   30","9  40  200");

        Races r = new Races(sc.nextLine(),sc.nextLine());
    }
}