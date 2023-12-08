package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc= new Scanner(new File("C:/Users/pek14/Documents/Advent of Code/AoC23/Day-8/src/main/java/org/example/input8.txt"));
        char[] cInstructions = sc.nextLine().toCharArray(); //im not using arraylists today.
        Dir [] instructions = new Dir[cInstructions.length] ;

        for (int i = 0; i< cInstructions.length;i++){instructions[i] = Dir.valueOf(String.valueOf(cInstructions[i]));} //converts them to my enum
        sc.nextLine();
        Node[] nodes = new Node[0]; //array to be filled with Node objects
        while (sc.hasNextLine()){
            nodes =  addToArray(nodes,(new Node(sc.nextLine())));
            }
        Node[] active = new Node[0]; //array to be filled with starting positions
        for (Node node: nodes){
            node.attach(nodes); //linking my nodes together
            if (node.getName().charAt(2) == 'A'){ active =  addToArray(active,node); //if it is a starting node - for p1, change to get node "AAA"
                }
        }
        //AFTER TESTING, I HAVE DISCOVERED THAT ALL XXA NODES ARE AS FAR APART FROM XXZ AS IT IS FROM ITSELF
        //IT TAKES 14681 STEPS FROM AAA -> ZZZ AND 14681 STEPS FROM ZZZ -> ZZZ

        int[] dists = new int[active.length]; //the distances from each starting node to the end node = the distance from that end node to itself.
        for (int i = 0; i< active.length ; i++){dists[i] = dist(active[i],instructions);}
        double n =1;
        for (int i: dists){
            System.out.println(i);
            //n = n*i; //work out prime numbers and the lcm (I just used a website lmao)
             }
        System.out.printf("%f",n);
    }
    private static int dist(Node node, Dir[] instructions){//im too lazy to make a map object, so im just having main do it all.
        int n = 0;
        while(true){
            for (Dir d: instructions){
                n++;
                node = node.getChild(d);
                if (node.getName().charAt(2) == 'Z'){ return n;} //for part 1, the string needs to equal "ZZZ" (it does not make any difference)
                    //else{System.out.println(active[i].getName() +" "+ ++j);}
            }
                //if (allThere || j==6){System.out.println(n);return;}
        }
    }


    public static Node[] addToArray(Node[] array, Node obj){
        Node[] nArray = new Node[array.length+1];
        System.arraycopy(array, 0, nArray, 0, array.length);
        nArray[nArray.length-1] = obj;
        return nArray;
    }

}