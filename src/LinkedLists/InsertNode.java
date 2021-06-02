package LinkedLists;

import java.io.*;
import java.util.*;


public class InsertNode {

    static class SinglyLinkedListNode {
        public int data;
        public SinglyLinkedListNode next;

        public SinglyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
        }
    }

    static class SinglyLinkedList {
        public SinglyLinkedListNode head;
        public SinglyLinkedListNode tail;

        public SinglyLinkedList() {
            this.head = null;
            this.tail = null;
        }

        public void insertNode(int nodeData) {
            SinglyLinkedListNode node = new SinglyLinkedListNode(nodeData);

            if (this.head == null) {
                this.head = node;
            } else {
                this.tail.next = node;
            }

            this.tail = node;
        }
    }

    public static void printSinglyLinkedList(SinglyLinkedListNode node, String sep, BufferedWriter bufferedWriter) throws IOException {
        while (node != null) {
            bufferedWriter.write(String.valueOf(node.data));

            node = node.next;

            if (node != null) {
                bufferedWriter.write(sep);
            }
        }
    }

    static SinglyLinkedListNode insertNodeAtPosition(SinglyLinkedListNode head, int data, int position) {
        SinglyLinkedListNode node = new SinglyLinkedListNode(data);

        if(position == 0){
            if(head == null){
                head = node;

            } else {
                SinglyLinkedListNode headPrev = head;
                head = node;
                head.next = headPrev;
            }

            return head;
        }

        int it = 0;

        SinglyLinkedListNode iterNode = head;

        while(iterNode.next != null && it < position - 1){
            iterNode = iterNode.next;
            it++;
        }


        SinglyLinkedListNode iterNext = iterNode.next;
        iterNode.next = node;
        iterNode.next.next = iterNext;

        return head;

    }

    private static final Scanner scanner = new Scanner(System.in);}
