package LinkedLists;

import java.io.*;
import java.util.*;

public class ReverseList {

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

    static DoublyLinkedListNode reverse(DoublyLinkedListNode head) {
        DoublyLinkedListNode iter = head;
        int size = 0;

        while(iter.next != null){
            iter = iter.next;
            size ++;
        }

        DoublyLinkedListNode end = iter;
        DoublyLinkedListNode begin = head;



        for(int i = 0; i <= size/2; ++i){
            int begData = begin.data;
            begin.data = end.data;
            end.data = begData;
            end = end.prev;
            begin = begin.next;
        }

        return head;


    }

    private static final Scanner scanner = new Scanner(System.in);