package org.example;

public enum Dir {
    L(0),R(1);
private final int val;
    Dir(int i) {val = i;}
    public int getVal() {return val;}
}
