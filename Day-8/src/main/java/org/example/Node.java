package org.example;

import java.util.Scanner;

public class Node {
    private final String name;
    private final String[] sChildren;
    private final Node[] children;
    public Node(String line){
        Scanner sc = new Scanner(line);
        name = sc.next();
        sc.next();
        sChildren = new String[]{sc.next(),sc.next()}; //going to use this later to find the child nodes
        sChildren[1] = sChildren[1].replace(")","");
        sChildren[0] = sChildren[0].replace("(","").replace(",",""); //formatting
        //System.out.printf("%s %s %s\n",name, sChildren[0], sChildren[1]);
        children = new Node[]{null, null}; //initisialising this here
    }
    public void attach(Node[] nodes){//has this node find its child nodes in nodes
        for (int i = 0; i< children.length;i++) {
            for (Node node : nodes) {
                if (node.getName().equals(this.sChildren[i])){children[i] = node;}
            }
        }
    }

    String getName() {
        return name;
    }
    public Node getChild(Dir d){return children[d.getVal()];} //finds the left or right child
}
