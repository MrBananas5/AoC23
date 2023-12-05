package org.example;

import java.util.ArrayList;

public class Dictionary {
    private final Iden [] is;
    private final ArrayList<double[]> searchers;

    public Dictionary (Iden k1, Iden k2){
        searchers = new ArrayList<double[]>();
        this.is = new Iden[]{k1,k2};
    }

    public void link(double k1, double k2,double l){
        searchers.add(new double[]{k1,k2,l});
    }
    public double get(double i, int k){ // gets the equivalent of i in key p
        for (double[] d: searchers){
            if (d[1-k] <= i &&  i <d[1-k] +d[2]){
                return d[k] + (i - d[1-k]);
            }
        }
    return i;}

    public String names(){return is[0].name()+ is[1].name();}

    public Iden name(int i) {
        return is[i];
    }
}
