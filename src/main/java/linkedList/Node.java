package linkedList;

/**
 * @author hanlin.zhou
 * @date 2021/2/17 22:00
 */
public class Node {
    public int value;
    public Node last;
    public Node next;

    Node(int data){
        this.value = data;
    }

    /**
     * 从该节点开始打印
     */
    public void print(){
        StringBuilder sb = new StringBuilder();
        sb.append(this.value).append(" ");
        Node cur = this.next;
        while(cur != null){
            sb.append(cur.value).append(" ");
            cur = cur.next;
        }
        System.out.println(sb.toString());
    }

    /**
     * 根据传入字符数组构建链表，返回头节点
     */
    public static Node buildLinkedList(String[] arr){
        Node head = new Node(-1);
        Node cur = head;
        for (String s : arr) {
            cur.next = new Node(Integer.parseInt(s));
            cur = cur.next;
        }
        return head.next;
    }

    /**
     * 构建长度为 len 的环形单链表
     * 编号为 1 -- len
     * 返回 编号为 1 的节点
     */
    public static Node buildCycleLinkedList(int len){
        Node head = new Node(-1);
        Node cur = head;
        for (int i=1;i<=len;i++) {
            cur.next = new Node(i);
            cur = cur.next;
        }
        cur.next = head.next;
        return head.next;
    }

}
