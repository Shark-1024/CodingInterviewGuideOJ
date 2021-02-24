package linkedList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 环形单链表的约瑟夫环问题
 * @author hanlin.zhou
 * @date 2021/2/24 16:05
 */
public class JosephusKill {

    public static void main(String[] args) throws IOException {
        BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
        String[] readLine = b.readLine().trim().split(" ");
        // 链表的总长度
        int len = Integer.parseInt(readLine[0]);
        // 需要 kill 的编号
        int m = Integer.parseInt(readLine[1]);
        b.close();
        Node aliveNode = kill(Node.buildCycleLinkedList(len), m);
        if (aliveNode != null){
            System.out.println(aliveNode.value);
        }
    }

    /**
     * @param head 编号为 1 的节点
     * @param m 需要 kill 的编号
     * @return 最后存活的节点
     */
    private static Node kill(Node head, int m){
        if (head == null || head == head.next || m < 1){
            return head;
        }
        // 编号
        int dead = 0;
        // head 的上一个节点
        Node last = head;
        while (last.next != head){
            last = last.next;
        }
        while(head.next != head){
            if (++dead == m){
                // kill 节点并重新编号
                last.next = head.next;
                dead = 0;
            } else{
                last = last.next;
            }
            head = last.next;
        }
        return head;
    }

}
