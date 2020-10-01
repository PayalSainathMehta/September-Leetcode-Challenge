import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MaximumDistanceBetweenArrays {

    public static int maxDistance(List<List<Integer>> arrays) {
        int result = Integer.MIN_VALUE;
        int max = arrays.get(0).get(arrays.get(0).size() - 1); //last element of first array
        int min = arrays.get(0).get(0); //first element of first array

        for(int i = 1; i < arrays.size(); i++){
            result = Math.max(result, Math.abs(arrays.get(i).get(arrays.get(i).size() - 1) - min)); //max - min
            result = Math.max(result, Math.abs(arrays.get(i).get(0) - max)); //min - max
            max = Math.max(max, arrays.get(i).get(arrays.get(i).size() - 1)); //max as last element of ith array
            min = Math.min(min, arrays.get(i).get(0)); //min as first element of ith array
        }
        return result;//finally
    }

    public static void main(String[] args) {
        Integer[][] arrays = {{1,2,3},{4,5},{1,2,3}};
        int result = maxDistance(Arrays.stream(arrays).map(Arrays::asList).collect(Collectors.toList()));
        System.out.println(result);
    }
}
