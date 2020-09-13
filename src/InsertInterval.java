import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertInterval {
    public static int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();
        int start = newInterval[0];
        int end = newInterval[1];
        int i = 0;

        //add initial not overlapping
        while(i < intervals.length && intervals[i][1] < start)
            res.add(intervals[i++]);

        //merging indices
        while(i < intervals.length && intervals[i][0] <= end)
        {
            start = Math.min(start, intervals[i][0]);
            end = Math.max(end, intervals[i][1]);
            i++;
        }
        res.add(new int[]{start, end});

        //add remaining
        while(i < intervals.length)
            res.add(intervals[i++]);

        //conversion from arraylist to array
        int[][] result = new int[res.size()][2];//as only start, end in each array
        for(int k = 0; k < res.size(); k++){
            result[k][0] = res.get(k)[0];
            result[k][1] = res.get(k)[1];
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] intervals = {{1,3},{6,9}};
        int[] newInterval = {2,5};
        System.out.println(Arrays.deepToString(insert(intervals, newInterval)));
    }
}
