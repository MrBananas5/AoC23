package org.example;

public class Hand2 extends  Hand{ //part 2

    public Hand2(String s) {
        super(s);
    }
    protected int[] countUp(){ //does the counting differently
        int[] counts = new int[]{0,0}; Card q = null;
        for (Card c: cards){
            if (c != Card.JACK) { //does not count jokers (jacks)
                q = doCount(counts,c,q);
            }
        }
        counts[0] += count(Card.JACK); //adds the jack to the most popular card
        return counts;
    }
    protected boolean compareCards(Hand hand) {
        for (int i = 0;i<5;i++){
            if (cards[i] == Card.JACK && hand.getAt(i) != Card.JACK){return false;}//compares jack values differently (this is me being lazy)
            if (hand.getAt(i) == Card.JACK && cards[i] != Card.JACK){return true;}
            if (cards[i].getVal() > hand.getAt(i).getVal()){return true;}
            if (cards[i].getVal() < hand.getAt(i).getVal()){return false;}
        }
        return false;
    }
}
