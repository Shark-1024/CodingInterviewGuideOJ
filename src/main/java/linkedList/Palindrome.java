package linkedList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * 判断链表是否为回文结构
 * @author hanlin.zhou
 * @date 2021/2/26 0:03
 */
public class Palindrome {

    public static void main(String[] args) throws IOException {
        BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
        int len = Integer.parseInt(b.readLine());
        String[] readLine = b.readLine().trim().split(" ");
        b.close();
        System.out.println(isPalindromeByStack(Node.buildLinkedList(readLine)));
    }

    private static boolean isPalindromeByStack(Node head){
        Node cur = head;
        Stack<Node> stack = new Stack<>();
        while(cur != null){
            stack.push(cur);
            cur = cur.next;
        }
        while(head != null){
            if (head.value != stack.pop().value){
                return false;
            }
            head = head.next;
        }
        return true;
    }

}