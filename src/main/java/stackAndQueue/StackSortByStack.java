package stackAndQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * @author hanlin.zhou
 * @date 2021/2/16 18:15
 */
public class StackSortByStack {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        long numCount = Long.parseLong(bufferedReader.readLine());
        String[] readLine = bufferedReader.readLine().trim().split(" ");
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<numCount;i++){
            stack.push(Integer.parseInt(readLine[i]));
        }
        sortByStack(stack);
        bufferedReader.close();
        // output
        while(!stack.isEmpty()){
            System.out.print(stack.pop()+" ");
        }
    }

    private static void sortByStack(Stack<Integer> stack){
        Stack<Integer> helpStack = new Stack<>();
        while(!stack.isEmpty()){
            int cur = stack.pop();
            while(!helpStack.isEmpty() && cur > helpStack.peek()){
                stack.push(helpStack.pop());
            }
            helpStack.push(cur);
        }
        // 倒回
        while(!helpStack.isEmpty()){
            stack.push(helpStack.pop());
        }
    }

    // 一种错误写法：cur中暂存的值会丢失
    private static void wrongSortByStack(Stack<Integer> stack){
        Stack<Integer> helpStack = new Stack<>();
        while(!stack.isEmpty()){
            int cur = stack.pop();
            if (helpStack.isEmpty() || cur <= helpStack.peek()){
                helpStack.push(cur);
            }else {
                while (!helpStack.isEmpty() && cur > helpStack.peek()){
                    stack.push(helpStack.pop());
                }
            }
        }
        // 倒回
        while(!helpStack.isEmpty()){
            stack.push(helpStack.pop());
        }
    }
}
