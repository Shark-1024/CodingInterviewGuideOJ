package stack_and_queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * input:
 *
 * 6
 * push 3
 * push 2
 * push 1
 * getMin
 * pop
 * getMin
 *
 * @author hanlin.zhou
 * @date 2021/2/16 13:31
 */
public class GetMinStack {

    public static void main(String[]args) throws IOException {
        BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
        long sum = Integer.parseInt(b.readLine());
        MyStack myStack = new MyStack();
        for (int i=0;i<sum;i++) {
            String[] inputLine = b.readLine().trim().split(" ");
            String operate = inputLine[0];
            Long num = inputLine.length > 1 ? Long.parseLong(inputLine[1]) : null;
            myStack.handleOperate(operate, num);
        }
        b.close();
    }

}


class MyStack{

    private Stack<Long> dataStack;
    private Stack<Long> minStack;

    MyStack(){
        dataStack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(Long num){
        dataStack.push(num);
        if (minStack.isEmpty() || num <= minStack.peek()){
            minStack.push(num);
        }
    }

    public Long pop(){
        Long popNum = dataStack.pop();
        if (popNum.equals(minStack.peek())){
            minStack.pop();
        }
        return popNum;
    }

    public Long getMin(){
        return minStack.peek();
    }

    public void handleOperate(String operate, Long num){
        switch (operate){
            case "push":
                push(num);
                break;
            case "pop":
                pop();
                break;
            case "getMin":
                System.out.println(getMin());
                break;
        }
    }
}

class MyStack2{
    private Stack<Long> dataStack;
    private Stack<Long> minStack;

    MyStack2(){
        dataStack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(Long num){
        dataStack.push(num);
        if (minStack.isEmpty() || num <= minStack.peek()){
            minStack.push(num);
        } else {
            minStack.push(minStack.peek());
        }
    }

    public Long pop(){
        minStack.pop();
        return dataStack.pop();
    }

    public Long getMin(){
        return minStack.peek();
    }

    public void handleOperate(String operate, Long num){
        switch (operate){
            case "push":
                push(num);
                break;
            case "pop":
                pop();
                break;
            case "getMin":
                System.out.println(getMin());
                break;
        }
    }
}
