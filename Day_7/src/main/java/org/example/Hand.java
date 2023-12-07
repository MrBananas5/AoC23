package org.example;

import java.util.Scanner;

public class Hand {
    private final Card[] cards;
    private final int bid;
    private final int type;
    public Hand(String s){
        cards = new Card[]{null,null,null,null,null};
        int[] counts = new int[]{0,0};
        char[] a = s.toCharArray();
        Card q = null;
        for (int i =0; i<5;i++){
            cards[i] = Card.fromChar(a[i]);
        }
        Scanner sc = new Scanner(s);
        sc.next();
        bid = sc.nextInt();
        for (Card c: cards){
            int n = count(c);
            if (counts[0] < n){counts[0] = n;q=c;}
            else if (counts[1] < n && q.getVal() != c.getVal()) {
                    counts[1] = n;
                }

        }

        switch (counts[0]) {
            case 5 -> type = 6;
            case 4 -> type = 5;
            case 3 -> {
                    if (counts[1] == 2) {type = 4;break;}
                    type = 3;
                }
                case 2 -> {
                    if (counts[1] == 2) {type = 2;break;}
                    type = 1;
                }
                default -> type = 0;
            }

    }
    private int count(Card c){
        int n = 0;
        for (Card ca: cards){
            if (c == ca){n++;}
        }
        return n;
    }

    public int getBid(){return bid;}
    public String getHand(){
        return String.format("%c%c%c%c%c",cards[0].getChar(),cards[1].getChar(),cards[2].getChar(),cards[3].getChar(),cards[4].getChar());
    }
    public int getValue( ){
        return (Card.values().length * type) + cards[0].getVal();
    }
    public int getValue( int i){
        return (Card.values().length * type) + cards[i].getVal();
    }
    public Card getAt(int i){return cards[i];}
    public int getType(){return type;}
    public boolean compare(Hand hand) {
        if (type > hand.getType()){return true;}
        if (type < hand.getType()){return false;}
        for (int i = 0;i<5;i++){
            if (cards[i].getVal() > hand.getAt(i).getVal()){return true;}
            if (cards[i].getVal() < hand.getAt(i).getVal()){return false;}
        }
        return false;
    }
}
