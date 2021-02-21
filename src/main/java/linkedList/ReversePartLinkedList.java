package linkedList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 反转部分单向链表
 * @author hanlin.zhou
 * @date 2021/2/21 20:02
 */
public class ReversePartLinkedList {

    public static void main(String[] args) throws IOException {
        BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
        int len = Integer.parseInt(b.readLine());
        Node head = Node.buildLinkedList(b.readLine().trim().split(" "));
        String[] readLine = b.readLine().trim().split(" ");
        int from = Integer.parseInt(readLine[0]);
        int to = Integer.parseInt(readLine[1]);
        b.close();
        Node newHead = reversePart(head, from, to);
        newHead.print();
    }

    private static Node reversePart(Node head, int from, int to){
        Node fPre = null;
        Node tPos = null;
        Node cur = head;
        int i = 0;
        while(cur != null){
            ++i;
            fPre = i == from - 1 ? cur : fPre;
            tPos = i == to + 1 ? cur : tPos;
            cur = cur.next;
        }
        if (from > to || from < 1 || to > i){
            return head;
        }
        // part部分的头
        Node partHead = fPre == null ? head : fPre.next;
        // part部分的头的 next
        Node partCur = partHead.next;
        // part头变成part部分最后一个了，连接part部分后面的节点tPos
        partHead.next = tPos;
        Node partNext;
        while(partCur != tPos){
            partNext = partCur.next;
            partCur.next = partHead;
            partHead = partCur;
            partCur = partNext;
        }
        if (fPre != null){
            fPre.next = partHead;
            return head;
        }
        // from 为 1 的情况，返回part部分的头
        return partHead;
    }


}
