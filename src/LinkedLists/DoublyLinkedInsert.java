package LinkedLists;

import java.io.*;
import java.util.*;


public class DoublyLinkedInsert {

    static class DoublyLinkedListNode {
        public int data;
        public DoublyLinkedListNode next;
        public DoublyLinkedListNode prev;

        public DoublyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
            this.prev = null;
        }
    }

    static class DoublyLinkedList {
        public DoublyLinkedListNode head;
        public DoublyLinkedListNode tail;

        public DoublyLinkedList() {
            this.head = null;
            this.tail = null;
        }

        public void insertNode(int nodeData) {
            DoublyLinkedListNode node = new DoublyLinkedListNode(nodeData);

            if (this.head == null) {
                this.head = node;
            } else {
                this.tail.next = node;
                node.prev = this.tail;
            }

            this.tail = node;
        }
    }

    public static void printDoublyLinkedList(DoublyLinkedListNode node, String sep, BufferedWriter bufferedWriter) throws IOException {
        while (node != null) {
            bufferedWriter.write(String.valueOf(node.data));

            node = node.next;

            if (node != null) {
                bufferedWriter.write(sep);
            }
        }
    }

    static DoublyLinkedListNode sortedInsert(DoublyLinkedListNode head, int data) {
        DoublyLinkedListNode iter = head;
        DoublyLinkedListNode node = new DoublyLinkedListNode(data);

        if(iter.data >= data){
            head = node;
            head.next = iter;
            node.next.prev = head;

            return head;
        }

        DoublyLinkedListNode iterPrev  = head;
        while(iter != null && iter.data < data){
            if(iter.next == null){
                iterPrev = iter;
            }

            iter = iter.next;
        }

        if(iter == null){
            System.out.println("here");
            System.out.println(iterPrev.data);
            iter = node;
            iter.prev = iterPrev;
            iter.prev.next = iter;
            iter.next = null;
            return head;
        }


        iterPrev = iter.prev;
        iter.prev = node;
        iter.prev.prev = iterPrev;
        iter.prev.prev.next = node;
        iter.prev.next = iter;

        return head;

    }

    private static final Scanner scanner = new Scanner(System.in);