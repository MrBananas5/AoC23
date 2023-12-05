package org.example;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import static org.example.Iden.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        ArrayList <double[]> seeds = new ArrayList<>();
        Scanner sc = new Scanner(new File("C:/Users/pek14/Documents/Advent of Code/AoC23/day5/src/main/java/org/example/input5.txt"));
        for (int i = 0;i < 11;i++){
            if (sc.hasNextDouble()){seeds.add(new double[]{sc.nextDouble(),sc.nextDouble()});}
            else{sc.next();}}
        for (double[] i:seeds){System.out.println(i[0]);}
        Almanac alma = new Almanac(sc);
        double n = -1;
        for (double[] i:seeds){
            System.out.println(i[1]);
            for (double j = i[0];j< i[0]+i[1];j++){
                double d = alma.get(SEED, LOCATION, j);
                //System.out.printf("seed: %f location: %f\n", j, d);// Output using string formatting.
                if (n != -1) {
                    if (d < n) {
                        n = d;
                    }
                } else {
                    n = alma.get(SEED, LOCATION, j);
                }
            }
        }
        System.out.printf("%f\n", n);// Output using string formatting.
    }

}