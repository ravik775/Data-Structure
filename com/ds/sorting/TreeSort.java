package com.ds.sorting;

import java.util.Stack;

import static com.ds.sorting.SortTest.test;

public class TreeSort {

    static class Node{
        int data;
        Node left, right;

    };

    public static void sort(int[] data)
    {
        Node head = null;
        for(int data_elem: data)
            head = add(head, data_elem);

        Stack<Node> stack = new Stack<>();
        Node current = head;
        int index = 0;

        while(current != null || stack.empty() == false) {
            //No left nodes to travel
            stack.push(current); //right need to be visited
            current = current.left;

            while(current == null && stack.empty() == false) //at leaf node
            {
                current = stack.pop();
                data[index] = current.data;
                index++;
                current = current.right; //navigate right child as left child is processed
            }
        }

    }

    public static Node add(Node head, int add_elem){
        Node newNode = new Node();
        newNode.data = add_elem;

        if(head == null)
            return newNode;

        Node curr_node = head;
        while( true) // finate loop
        {
            if(curr_node.data > add_elem)
            {
                //should be added at left side
                if (curr_node.left == null)
                {
                    curr_node.left = newNode;
                    return head;
                }
                curr_node = curr_node.left;
            }
            else
            {
                if(curr_node.right == null)
                {
                    curr_node.right = newNode;
                    return head;
                }
                curr_node = curr_node.right;
            }
        }

    }

    public static void main(String... strings)
    {
        test(TreeSort::sort);
    }

}
