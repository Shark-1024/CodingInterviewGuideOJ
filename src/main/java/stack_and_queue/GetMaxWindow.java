package stack_and_queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * 生成窗口最大值数组
 * @author hanlin.zhou
 * @date 2021/2/17 17:31
 */
public class GetMaxWindow {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] readLine = bufferedReader.readLine().trim().split(" ");
        String[] readLine1 = bufferedReader.readLine().trim().split(" ");
        int arrLength = Integer.parseInt(readLine[0]);
        int windowSize = Integer.parseInt(readLine[1]);
        Integer[] nums = Arrays.stream(readLine1).map(Integer::parseInt).toArray(Integer[]::new);
        int[] result = getMaxWindow(nums, windowSize);
        Arrays.stream(result).forEach(x-> System.out.print(x + " "));
        bufferedReader.close();
    }

    /**
     * 数组长度 n， 窗口大小 w，则一共产生 n-w+1 个窗口最大值
     * 放入规则：当前比队尾大，队尾就一直弹；队列为空或当前比队尾小，直接放入队尾
     * 弹出规则：队头过期的话就弹出
     */
    private static int[] getMaxWindow(Integer[] nums, int w){
        if (nums == null || w < 1 || w > nums.length){
            return null;
        }
        LinkedList<Integer> qMax = new LinkedList<>();
        int[] result = new int[nums.length-w+1];
        for(int i=0;i<nums.length;i++){
            // 放入规则
            while(!qMax.isEmpty() && nums[i] >= nums[qMax.peekLast()]){
                qMax.pollLast();
            }
            qMax.addLast(i);
            // 弹出规则
            if(!qMax.isEmpty() && qMax.peekFirst().equals(i-w)){
                qMax.pollFirst();
            }
            // 收集结果
            if (i-w+1 >= 0){
                result[i-w+1] = nums[qMax.getFirst()];
            }
        }
        return result;
    }

}
