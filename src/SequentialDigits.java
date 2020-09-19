import java.util.ArrayList;
import java.util.List;

public class SequentialDigits {
    /*
    return digits lying between low and high
     */
    public static List<Integer> sequentialDigits(int low, int high) {
        int[] allNums = {12,23,34,45,56,67,78,89, //2 digit
                123,234,345,456,567,678,789, //3 digit
                1234,2345,3456,4567,5678,6789, //4 digit
                12345,23456,34567,45678,56789, //5 digit
                123456,234567,345678,456789, //6 digit
                1234567,2345678,3456789, //7 digit
                12345678,23456789, //8 digit
                123456789}; //9 digit
        List<Integer> result = new ArrayList<>();
        for(int i = 0; i < allNums.length; i++){
            if(allNums[i] < low)
                continue;
            if(allNums[i] > high)
                break;
            result.add(allNums[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        int low = 123;
        int high = 300;
        System.out.println(sequentialDigits(low,high).toString());
    }
}
