import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

/**
 * 单调栈结构:没有重复值的数组求左右最第一个小的位置
 * @author hanlin.zhou
 * @date 2021/2/17 18:14
 */
public class MonotonicStack {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int arrLength = Integer.parseInt(bufferedReader.readLine());
        String[] readLine = bufferedReader.readLine().trim().split(" ");
        Integer[] nums = Arrays.stream(readLine).map(Integer::parseInt).toArray(Integer[]::new);
        int[][] nearLess = getNearLess(nums);
        for (int i=0;i<nearLess.length;i++){
            System.out.println(nearLess[i][0] + " "+ nearLess[i][1]);
        }
        bufferedReader.close();
    }

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

}
