import java.util.ArrayList;
import java.util.List;

public class PartitionLabels {

    public static List<Integer> partitionLabels(String S) {
        List<Integer> result = new ArrayList<>();
        if(S.length() == 0 || S == null)
            return result;
        //this will be to store the last occurence of a character
        //it will be stored as howFar[a] = 8, howFar[j] = 23...so on
        int[] howFar = new int[26];
        //traverse once to store the last occurrences of all chars.
        for(int i = 0; i < S.length(); i++)
            howFar[S.charAt(i) - 'a'] = i;
        //now compute start and last and the string length will be given as last - start + 1
        //computing start is easy as it will be reset every time last matches with the index
        //start is then last + 1
        int start = 0, last = 0;
        //second traversal to compute actual string lengths.
        //last will be computed as the maximum of last or howFar the character went.
        for(int i = 0; i < S.length(); i++) {
            last = Math.max(last, howFar[S.charAt(i) - 'a']);
            //if last is equal to i that means we have found our substring and we add its length
            if(last == i){
                result.add(last - start + 1);
                start = last + 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String s = "ababcbacadefegdehijhklij";
        System.out.println(partitionLabels(s).toString());
    }
}
