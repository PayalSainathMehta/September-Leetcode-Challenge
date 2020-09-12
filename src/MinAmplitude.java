import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class MinAmplitude {

    static int getMinAmplitude(int[] nums){
        if(nums.length <= 4)
            return 0;
        PriorityQueue<Integer> maxQ = new PriorityQueue<>();
        PriorityQueue<Integer> minQ = new PriorityQueue<>(Collections.reverseOrder());

        for(int n: nums){
            maxQ.add(n);
            if(maxQ.size() > 4)
                maxQ.poll();
            minQ.add(n);
            if(minQ.size() > 4)
                minQ.poll();
        }
        //MAXQ = 3,4,5,8
        //MINQ = 4,3,-1,-1
        List<Integer> maxList = new ArrayList<>();
        while(!maxQ.isEmpty())
            maxList.add(maxQ.poll());

        List<Integer> minList = new ArrayList<>();
        while(!minQ.isEmpty())
            minList.add(minQ.poll());

        System.out.println(maxList.toString()); // [3,4,5,8]
        System.out.println(minList.toString()); // [4,3,-1,-1]
        int ans = Integer.MAX_VALUE;
        for(int i = 0; i <= 3; i++) {
            ans = Math.min(ans, maxList.get(i) - minList.get(3-i)); // 3 - (-1), 4 - (-1), 5 - 3, 8 - 4
        }
        return ans; // 5 - 3
    }

    public static void main(String[] args) {
        int[] nums = {-1, 3, -1, 8, 5, 4};
        System.out.println(getMinAmplitude(nums));
    }
}
