package org.example;

import java.util.Scanner;

public class Hand { //hand class
    protected final Card[] cards;
    private final int bid;
    private final int type;
    public Hand(String s){
        cards = new Card[]{null,null,null,null,null};//a hand has 5 cards

        char[] a = s.toCharArray();//just breaks into a char array

        for (int i =0; i<5;i++){
            cards[i] = Card.fromChar(a[i]);
        }
        Scanner sc = new Scanner(s);
        sc.next();//skips over the hand
        bid = sc.nextInt();
        int[] counts = countUp();
        switch (counts[0]) {
            case 5 -> type = 6;
            case 4 -> type = 5;
            case 3 -> {
                if (counts[1] == 2) {type = 4;break;}
                type = 3;}
            case 2 -> {
                if (counts[1] == 2) {type = 2;break;}
                type = 1;}
            default -> type = 0;
            }

    }
    protected Card doCount(int[] counts, Card c, Card q){ //do it. do the count.
        int n = count(c);
        if (counts[0] < n){counts[1] = counts [0];counts[0] = n;q=c;} //if n is more than the highest count yet, the second highest is set, as well as the value of the highest card(to prevent them both incorrectly being the same
        else if (counts[1] < n && q.getVal() != c.getVal()) {counts[1] = n;} //if n is higher than the next height card (and they aren't the same value), sets the second-highest card
        return q; //returns q so it can be reassigned
    }
    protected int[] countUp(){  //sets up the counting
        int[] counts = new int[]{0,0}; Card q = null;
        for (Card c: cards){
            q = doCount(counts,c,q);
        }
        return counts;
    }
    protected int count(Card c){ //counts every instance of card c
        int n = 0;
        for (Card ca: cards){
            if (c == ca){n++;}
        }
        return n;
    }

    public int getBid(){return bid;}
    public String getHand(){//for early troubleshooting
        return String.format("%c%c%c%c%c",cards[0].getChar(),cards[1].getChar(),cards[2].getChar(),cards[3].getChar(),cards[4].getChar());
    }
    public Card getAt(int i){return cards[i];} //called so card values can be compared
    public int getType(){return type;}
    public boolean compare(Hand hand) {
        if (type > hand.getType()){return true;} //compares type
        if (type < hand.getType()){return false;}
        return compareCards(hand); //then compares values


    }

    protected boolean compareCards(Hand hand) {
        for (int i = 0;i<5;i++){//compares values
            if (cards[i].getVal() > hand.getAt(i).getVal()){return true;}
            if (cards[i].getVal() < hand.getAt(i).getVal()){return false;}
        }
        return false;
    }
}
