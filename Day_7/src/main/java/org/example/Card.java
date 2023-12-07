package org.example;

public enum Card {


    TWO(2),THREE(3),FOUR(4),FIVE(5),SIX(6),SEVEN(7),EIGHT(8),NINE(9),
    TEN('T',10),JACK('J',11),QUEEN('Q',12),KING('K',13),ACE ('A',14);
    private final char c;
    private final int val;

    Card(int i){
        this.c = (char) (i+'0');
        this.val = i;
    }
    Card(char c, int i){
        this.c = c;
        this.val = i;
    }


    public static Card fromChar(char c) {
        for (Card ca : values()){
            if (ca.c == c){return ca;}
        }
        return null;
    }
    public  char getChar(){
        return this.c;
    }

    public int getVal() {return this.val;
    }
}
