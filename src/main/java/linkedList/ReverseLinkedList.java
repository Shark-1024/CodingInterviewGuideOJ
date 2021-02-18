package linkedList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 反转单链表和双向链表
 * @author hanlin.zhou
 * @date 2021/2/18 21:59
 */
public class ReverseLinkedList {

    public static void main(String[] args) throws IOException {
        BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
        int singleLength = Integer.parseInt(b.readLine());
        Node singleHead = Node.buildLinkedList(b.readLine().trim().split(" "));
        int doubleLength = Integer.parseInt(b.readLine());
        Node doubleHead = Node.buildLinkedList(b.readLine().trim().split(" "));
        b.close();
        Node newSingleHead = reverseSingle(singleHead);
        Node newDoubleHead = reverseDouble(doubleHead);
        newSingleHead.print();
        newDoubleHead.print();
    }

    private static Node reverseSingle(Node head){
        Node next;
        Node pre = null;
        while(head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    private static Node reverseDouble(Node head){
        Node next;
        Node pre = null;
        while(head != null) {
            next = head.next;
            head.next = pre;
            head.last = next;
            pre = head;
            head = next;
        }
        return pre;
    }

}
