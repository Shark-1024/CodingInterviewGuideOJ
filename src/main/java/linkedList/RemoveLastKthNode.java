package linkedList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author hanlin.zhou
 * @date 2021/2/18 16:41
 */
public class RemoveLastKthNode {

    public static void main(String[] args) throws IOException {
        BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
        String[] readLine1 = b.readLine().trim().split(" ");
        String[] readLine2 = b.readLine().trim().split(" ");
        b.close();
        int k = Integer.parseInt(readLine1[1]);
        Node newHead = removeLastKthNode(Node.buildLinkedList(readLine2), k);
        if (newHead != null){
            newHead.print();
        }
    }

    private static Node removeLastKthNode(Node head, int k){
        Node cur = head;
        while (cur != null){
            --k;
            cur = cur.next;
        }
        if (k == 0){
            return head.next;
        } else if(k>0) {
            return null;
        } else {
            cur = head;
            while (++k != 0){
                cur = cur.next;
            }
            // cur 此时为 要移除得节点得前一个节点
            Node newNext = cur.next.next;
            cur.next = newNext;
            if (newNext != null){
                newNext.last = cur;
            }
        }
        return head;
    }

}
