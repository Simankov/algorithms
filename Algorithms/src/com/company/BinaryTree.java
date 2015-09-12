package com.company;

/**
 * Created by admin on 05/09/15.
 */
public class BinaryTree {

    Node [] Nodes;
    Node root;
    int counter = 0;

    class Node {
        Node left = null;
        Node right = null;
        Node parent = null;
        int key;


        Node(int key){
            this.key = key;
        }

        Node(Node another){
            setKey(another.key);
            setRight(another.right);
            setLeft(another.left);
            setParent(another.parent);
        }

        public void setLeft(Node left) {
            this.left = left;
        }
        public void setParent(Node parent) {
            this.parent = parent;
        }
        public void setRight(Node right) {
            this.right = right;
        }
        public void setKey(int key) {
            this.key = key;
        }

    }

    BinaryTree(int [] A){

        root = new Node(A[0]);
        Nodes = new Node[A.length];
        Nodes[0] = root;
        for (int i = 1; i<Nodes.length; i++)
            Nodes[i] = new Node(A[i]);


        for (int i = 1; i<Nodes.length; i++){

            if (2*i+1 < Nodes.length)
                Nodes[i].setLeft(Nodes[2*i+1]);
            if (2*i+2 < Nodes.length)
                Nodes[i].setRight(Nodes[2*i+2]);
            Nodes[i].setParent(Nodes[(i - 1) / 2]);

        }


        root.setLeft(Nodes[1]);
        root.setRight(Nodes[2]);
    }

    void printAllKeys(){
        if (root==null) return;
        Node x = Nodes[0];
        System.out.println(root.key);
        do {
            x = Down(x);
            while (x != root && (x.parent.right == null || x.parent.right == x)) {
                System.out.println(x.key);
                x = x.parent;
                counter++;
            }

            if (x != root) {
                System.out.println(x.key);
                x = x.parent.right;
                counter++;
            }

        } while (x!=root);



    }

    Node Down(Node down_node){

        while(down_node.left!=null){
            down_node = down_node.left;
            counter++;
        }
        return down_node;
    }

    public void printCounter(){
        System.out.println(counter);
    }
}
