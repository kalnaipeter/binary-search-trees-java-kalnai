package com.codecool.javabst;

import java.util.List;

// Skeleton for the Binary search tree. Feel free to modify this class.
public class BinarySearchTree {

    private static Node root;

    public static void build(List<Integer> elements) {
        // TODO construct a binary search tree here
        root = CreateNodeOfTheTree(elements,0,elements.size()-1);
    }

    public static Node CreateNodeOfTheTree(List<Integer> elements,int start,int end){
        if (start > end){
            return null;
        }

        int midElement = (start + end)/2;
        Node currentNode = new Node(elements.get(midElement));

        currentNode.setLeft(CreateNodeOfTheTree(elements,start,midElement-1));
        currentNode.setRight(CreateNodeOfTheTree(elements,midElement+1,end));
        return currentNode;
    }

    public boolean search(Integer toFind) {
        Node currentNode = root;

        while (currentNode != null){
            if (currentNode.getKey() == toFind){
                return true;
            }else if(currentNode.getKey() > toFind){
                currentNode = currentNode.getLeft();
            }else if(currentNode.getKey() < toFind){
                currentNode = currentNode.getRight();
            }
        }
        // TODO return true if the element has been found, false if its not in the tree.
        return false;
    }

    public void add(Integer toAdd) {
        root = addNodeToRoot(toAdd,root);
        // TODO adds an element. Throws an error if it exist.
    }

    public Node addNodeToRoot(Integer toAdd,Node root){
        if (root == null){
            return new Node(toAdd);
        }

        if (toAdd > root.getKey()){
            root.setRight(addNodeToRoot(toAdd,root.getRight()));
        }
        else if (toAdd < root.getKey()){
            root.setLeft(addNodeToRoot(toAdd,root.getLeft()));
        }
        return root;
    }

    public void remove(Integer toRemove){
        root = removeNodeFromRoot(root,toRemove);
    }

    public Node removeNodeFromRoot(Node root,Integer toRemove) {
        if (root == null){
            return null;
        }
        if (toRemove > root.getKey()){
            root.setRight(removeNodeFromRoot(root.getRight(),toRemove));
        }else if (toRemove < root.getKey()){
            root.setLeft(removeNodeFromRoot(root.getLeft(),toRemove));
        }
        else {
            if (root.getLeft() == null)
                return root.getRight();
            else if (root.getRight() == null)
                return root.getLeft();

            //reorder the tree if there is two children
            root.setKey(minValue(root.getRight()));
            root.setRight(removeNodeFromRoot(root.getRight(), root.getKey()));
        }
        return root;
        // TODO removes an element. Throws an error if its not on the tree.
    }

    int minValue(Node root)
    {
        int minv = root.getKey();
        while (root.getLeft() != null)
        {
            minv = root.getLeft().getKey();
            root = root.getLeft();
        }
        return minv;
    }


}
