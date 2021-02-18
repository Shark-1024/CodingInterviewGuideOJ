package stackAndQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * 仅用递归函数和栈操作逆序一个栈
 * @author hanlin.zhou
 * @date 2021/2/17 15:59
 */
public class RecursionReverseStack {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(bufferedReader.readLine());
        String[] readLine = bufferedReader.readLine().trim().split(" ");
        Stack<Integer> stack = new Stack<>();
        // 逆序进栈，配合OJ的输出
        for (int i=count-1;i>=0;i--){
            stack.push(Integer.parseInt(readLine[i]));
        }
        recursionReverse(stack);
        while (!stack.isEmpty()){
            System.out.print(stack.pop() + " ");
        }
        bufferedReader.close();
    }


    private static void recursionReverse(Stack<Integer> stack){
        if (stack.isEmpty()){
            return;
        }
        int lastElement = getAndRemoveLastElement(stack);
        recursionReverse(stack);
        stack.push(lastElement);
    }

    /**
     * 返回并移除栈底的元素
     * @param stack
     * @return
     */
    private static int getAndRemoveLastElement(Stack<Integer> stack){
        int cur = stack.pop();
        if (stack.isEmpty()){
            return cur;
        } else {
            int lastElement = getAndRemoveLastElement(stack);
            stack.push(cur);
            return lastElement;
        }
    }

}
