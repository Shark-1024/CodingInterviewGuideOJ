import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * 用两个栈组成的队列:add poll peek
 * @author hanlin.zhou
 * @date 2021/2/17 0:41
 */
public class TwoStackQueue {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int operateCount = Integer.parseInt(bufferedReader.readLine());
        MyTwoStackQueue twoStackQueue = new MyTwoStackQueue();
        for (int i=0;i<operateCount;i++){
            String[] readLine = bufferedReader.readLine().trim().split(" ");
            twoStackQueue.handleInput(readLine);
        }
        bufferedReader.close();
    }

}

class MyTwoStackQueue{
    private Stack<Integer> pushStack;
    private Stack<Integer> popStack;

    MyTwoStackQueue(){
        this.pushStack = new Stack<>();
        this.popStack = new Stack<>();
    }

    public void handleInput(String[] readLine){
        String operate = readLine[0];
        switch (operate){
            case "add":
                add(Integer.parseInt(readLine[1]));
                break;
            case "poll":
                poll();
                break;
            case "peek":
                System.out.println(peek());
                break;
        }
    }

    public void add(Integer num){
        pushStack.push(num);
        transfer();
    }

    public Integer poll(){
        if(isEmpty()){
            return null;
        }
        transfer();
        return popStack.pop();
    }

    public Integer peek(){
        if(isEmpty()){
            return null;
        }
        transfer();
        return popStack.peek();
    }

    private void transfer(){
        if(popStack.isEmpty()){
            while(!pushStack.isEmpty()){
                popStack.push(pushStack.pop());
            }
        }
    }

    private boolean isEmpty(){
        return pushStack.isEmpty() && popStack.isEmpty();
    }

}
