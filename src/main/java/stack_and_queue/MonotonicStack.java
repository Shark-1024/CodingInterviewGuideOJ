package stack_and_queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * 单调栈结构
 * @author hanlin.zhou
 * @date 2021/2/17 18:14
 */
public class MonotonicStack {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int arrLength = Integer.parseInt(bufferedReader.readLine());
        String[] readLine = bufferedReader.readLine().trim().split(" ");
        Integer[] nums = Arrays.stream(readLine).map(Integer::parseInt).toArray(Integer[]::new);
        bufferedReader.close();
        int[][] nearLess = maybeRepeatGetNearLess(nums);
        StringBuilder sb = new StringBuilder();
        for (int i=0;i<nearLess.length;i++){
            sb.append(nearLess[i][0] + " "+ nearLess[i][1] + "\n");
        }
        System.out.println(sb.toString());
    }

    /**
     * 单调栈结构:没有重复值的数组求左右最第一个小的位置
     */
    private static int[][] getNearLess(Integer[] nums){
        int[][] result = new int[nums.length][2];
        Stack<Integer> monoStack = new Stack<>();
        for (int i=0;i<nums.length;i++){
            while(!monoStack.isEmpty() && nums[monoStack.peek()] > nums[i]){
                int cur = monoStack.pop();
                result[cur][0] = monoStack.isEmpty() ? -1 : monoStack.peek();
                result[cur][1] = i;
            }
            monoStack.push(i);
        }
        // 清算阶段
        while(!monoStack.isEmpty()){
            int cur = monoStack.pop();
            result[cur][0] = monoStack.isEmpty() ? -1 : monoStack.peek();
            result[cur][1] = -1;
        }
        return result;
    }

    /**
     * 单调栈结构:有重复值的数组求左右最第一个小的位置
     */
    private static int[][] maybeRepeatGetNearLess(Integer[] nums){
        int[][] result = new int[nums.length][2];
        Stack<List<Integer>> monoStack = new Stack<>();
        for (int i=0;i<nums.length;i++){
            while(!monoStack.isEmpty() && nums[monoStack.peek().get(0)] > nums[i]){
                List<Integer> curList = monoStack.pop();
                int leftLessIndex = monoStack.isEmpty() ? -1 : monoStack.peek().get(monoStack.peek().size()-1);
                for(int n : curList){
                    result[n][0] = leftLessIndex;
                    result[n][1] = i;
                }
            }
            // 相等时放在一起压入
            if(!monoStack.isEmpty() && nums[i].equals(nums[monoStack.peek().get(0)])){
                monoStack.peek().add(i);
            } else {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(i);
                monoStack.push(list);
            }
        }
        // 清算阶段
        while(!monoStack.isEmpty()){
            List<Integer> pop = monoStack.pop();
            for (int cur : pop){
                result[cur][0] = monoStack.isEmpty() ? -1 : monoStack.peek().get(monoStack.peek().size()-1);
                result[cur][1] = -1;
            }
        }
        return result;
    }

}
