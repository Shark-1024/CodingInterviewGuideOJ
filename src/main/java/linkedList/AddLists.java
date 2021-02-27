package linkedList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * 相加两个单链表
 * @author hanlin.zhou
 * @date 2021/2/28 0:23
 */
public class AddLists {

    public static void main(String[] args) throws IOException {
        BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
        String[] readLine = b.readLine().trim().split(" ");
        int len = Integer.parseInt(readLine[0]);
        int len1 = Integer.parseInt(readLine[1]);
        Node head = Node.buildLinkedList(b.readLine().trim().split(" "));
        Node head1 = Node.buildLinkedList(b.readLine().trim().split(" "));
        b.close();
        addLists(head, head1).print();
    }

    private static Node addLists(Node head, Node head1){
        Node cur = head;
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> stack1 = new Stack<>();
        while(cur != null){
            stack.push(cur.value);
            cur = cur.next;
        }
        cur = head1;
        while(cur != null){
            stack1.push(cur.value);
            cur = cur.next;
        }
        int sum = 0;
        int ca = 0;
        Node node = null;
        Node pre = null;
        while (!stack.isEmpty() || !stack1.isEmpty()){
            sum = (stack.isEmpty() ? 0 : stack.pop()) + (stack1.isEmpty() ? 0 : stack1.pop()) + ca;
            pre = node;
            node = new Node(sum % 10);
            node.next = pre;
            ca = sum/10;
        }
        if (ca == 1){
            pre = node;
            node = new Node(1);
            node.next = pre;
        }
        return node;
    }

}
