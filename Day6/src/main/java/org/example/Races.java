package org.example;

import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.Math.*;

public class Races {
    private final ArrayList<Double> times;
    private final ArrayList<Double> distances;
    private final ArrayList<Double> range;
    public Races(String times, String distances){
        this.times = new ArrayList<>();this.distances = new ArrayList<>();this.range = new ArrayList<>();
        StringBuilder tS = new StringBuilder(); StringBuilder dS = new StringBuilder();
        populate(this.times,times,tS);populate(this.distances,distances,dS);

        for (int i = 0; i < this.times.size();i++){System.out.printf("%f",findDurations(i));}

        System.out.println(tS);
        this.distances.add(Double.valueOf(tS.toString()));
        this.times.add(Double.valueOf(dS.toString()));
        System.out.printf("%f\n\n",durationOf(this.times.get(this.times.size()-1),this.distances.get(this.distances.size()-1)));
    }
    private void populate(ArrayList<Double> list, String values,StringBuilder sb){
        Scanner sc = new Scanner(values);
        while (sc.hasNext()){
        while (!sc.hasNextInt()){sc.next();}
        int n = sc.nextInt();
        sb.append(n);
        list.add((double) n);}
    }
    private double durationOf(double d, double t){
        double hvalue = ceil((t+sqrt((t*t)- (4*d)))/2) ;
        double lvalue = floor((t-sqrt((t*t)- (4*d)))/2) ;
        System.out.printf("d: %f t: %f hv: %f lv: %f\n",d,t,hvalue, lvalue);
        return abs(hvalue - lvalue)-1;
    }
    private void calculateDuration(int n){
        range.set(n,durationOf(distances.get(n),times.get(n)));
    }
    public double findDurations(int n){
        if (range.size()-1 <= n) {
            range.add((double) 0);
            calculateDuration(n);}
        return range.get(n);
    }
    public void getN(){
        double n = 1;
        for (double i: range){n = n*i;}
        System.out.printf("%f\n\n",n);
    }
}
