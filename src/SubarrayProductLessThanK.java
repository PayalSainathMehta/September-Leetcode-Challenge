public class SubarrayProductLessThanK {

    static int getProduct(int[] nums, int k){
        if(k <= 1)
            return 0;
        int count = 0;
        int left = 0, right = 0;
        int p = 1;
        while(right < nums.length){
            p *= nums[right];
            while(p >= k){
                p /= nums[left];
                left++;
            }

            count += right - left + 1;
            right++;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {10,5,2,6};
        int k = 100;
        System.out.println(getProduct(nums, k));
    }

}
