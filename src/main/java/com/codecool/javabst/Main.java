package com.codecool.javabst;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;


public class Main {

    public static void main(String[] args) throws IOException {

        ArrayList<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            numbers.add(i * 2 + 5);
        }

        BinarySearchTree myTree = new BinarySearchTree();
        BinarySearchTree.build(numbers);
        System.out.println(numbers);

        // write some test code here
        myTree.add(20);
        System.out.println(myTree.search(20));

        System.out.println(myTree.search(7)); // should be true
        System.out.println(myTree.search(55)); // should be true
        System.out.println(myTree.search(34535)); // should be false
        System.out.println("done");

        myTree.remove(20);
        System.out.println(myTree.search(20));

    }
}