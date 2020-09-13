import java.util.Arrays;
import java.util.PriorityQueue;

public class MaxSubarrayOfLengthK {

    private static int[] maxSubarray(int[] nums, int k) {
        if(nums.length == 0 || nums == null || nums.length == k)
            return nums;
        int n = nums.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        for(int i = 0; i <= n - k; i++)
            pq.offer(new int[]{nums[i], i});
        int index = pq.poll()[1];
        return Arrays.copyOfRange(nums, index, index + k);
    }

    public static void main(String[] args) {
        int[] nums = {1, 4, 3, 2, 5};
        System.out.println(Arrays.toString(maxSubarray(nums, 4)));
    }

}
