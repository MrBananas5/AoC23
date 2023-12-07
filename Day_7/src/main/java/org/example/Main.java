package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import static java.util.Collections.swap;

public class Main { //gave up on this later lol
    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<Hand> hands = new ArrayList<>();
        Scanner sc = new Scanner(new File("C:/Users/pek14/Documents/Advent of Code/AoC23/Day_7/src/main/java/org/example/input7.txt"));
        while (sc.hasNextLine()){
            hands.add(new Hand(sc.nextLine()));
        }
        boolean swapped;// me bubble sort
        for (int i =0; i < hands.size()-1;i++) {
            swapped = false;
            for (int j = 0; j < hands.size() - i - 1; j++) {
                if (hands.get(j).compare(hands.get(j+1))) {
                    swap(hands,j, j+1);
                    swapped = true;
                }}
            if (!swapped)
                break;
        }
    int n = 0;
    for (int i =0; i < hands.size();i++) {
        System.out.printf("%s %d %d %d %d\n",hands.get(i).getHand(),  hands.get(i).getBid(),(i+1),(i+1)*hands.get(i).getBid(),hands.get(i).getType());
        n += (i+1)*hands.get(i).getBid();
    }
    System.out.println(n);
}}