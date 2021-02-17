package linkedList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 合并两个有序的单链表
 * @author hanlin.zhou
 * @date 2021/2/17 22:09
 */
public class MergeOrderedLinkedList {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int len1 = Integer.parseInt(bufferedReader.readLine());
        String[] readLine1 = bufferedReader.readLine().trim().split(" ");
        int len2 = Integer.parseInt(bufferedReader.readLine());
        String[] readLine2 = bufferedReader.readLine().trim().split(" ");
        bufferedReader.close();
        Node head1 = Node.buildLinkedList(readLine1);
        Node head2 = Node.buildLinkedList(readLine2);
        Node merge = merge(head1, head2);
        merge.print();
    }

    private static Node merge(Node head1, Node head2){
        Node newHead = new Node(-1);
        Node cur = newHead;
        while (head1 != null || head2 != null){
            if(head1 != null && head2 != null){
                if(head1.value < head2.value){
                    cur.next = new Node(head1.value);
                    head1 = head1.next;
                } else {
                    cur.next = new Node(head2.value);
                    head2 = head2.next;
                }
            } else {
                if(head1 == null){
                    cur.next = new Node(head2.value);
                    head2 = head2.next;
                } else {
                    cur.next = new Node(head1.value);
                    head1 = head1.next;
                }
            }
            cur = cur.next;
        }
        return newHead.next;
    }
}
