import java.util.LinkedList;
import java.util.Queue;

public class MovingAverage {

    /** Initialize your data structure here. */
    Queue<Integer> queue;
    int capacity;
    int currSum;

    //Note: we will store in queue only number of elements as specified by size
    MovingAverage(int size){
        queue = new LinkedList<>();
        capacity = size;
        currSum = 0;
    }

    double next(int val){
        currSum += val;
        queue.offer(val);

        if(queue.size() > capacity)
            currSum -= queue.poll(); //because of window size - take avg of only elements in the sliding window

        return currSum * 1.0 / queue.size();  // return currSum as float then divide by size to get average
    }

    public static void main(String[] args) {
        int size = 3;
        MovingAverage obj = new MovingAverage(size);
        System.out.println(obj.next(2));
        System.out.println(obj.next(3));
        System.out.println(obj.next(5));
    }
}
