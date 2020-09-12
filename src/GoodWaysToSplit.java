import java.util.HashSet;
import java.util.Set;

public class GoodWaysToSplit {

    static int numSplits(String s){
        int goodWays = 0;
        int n = s.length();
        if(n == 0 || s == null)
            return 0;
        int[] prefix = new int[n];
        int[] suffix = new int[n];

        Set<Character> preset = new HashSet<>();
        Set<Character> sufset = new HashSet<>();

        //build the prefix , suffix arrays and the sets
        for(int i = 0; i < n; i++){
            preset.add(s.charAt(i)); //from right to left
            sufset.add(s.charAt(n - i - 1)); //from left to right
            prefix[i] = preset.size(); //directly the size
            suffix[n - i - 1] = sufset.size(); //again left to right
        }

        for(int i = 1; i < n; i++)
            if(prefix[i - 1] == suffix[i])
                goodWays++;

        return goodWays;
    }

    public static void main(String[] args) {
        String s = "acbadbaada";
        System.out.println(numSplits(s));
    }
}
