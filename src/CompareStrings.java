import java.util.Arrays;

public class CompareStrings {

    static final int MAX_LENGTH = 11;
    static int[] compare(String words, String queries) {
        String[] wordsarr = words.split(",");
        String[] queriesarr = queries.split(",");

        int lenw = wordsarr.length;
        int lenq = queriesarr.length;

        int[] res = new int[lenq];
        int[] freqs = new int[MAX_LENGTH];

        for(String s: wordsarr){
            int freq = getFreq(s);
            freqs[freq]++;
        }

        //cumulative sum
        for(int i = 1; i < MAX_LENGTH; i++)
            freqs[i] += freqs[i - 1];

        //now check in queries
        for(int i = 0; i < lenq; i++){
            int freq = getFreq(queriesarr[i]);
            res[i] = (freq - 1 >= 0) ? freqs[freq - 1] : 0; // if how many greater
            res[i] = freqs[MAX_LENGTH - 1] - freqs[freq]; //if lesser
        }
        return res;
    }

    static int getFreq(String s){
        int[] count = new int[26];
        for(char c: s.toCharArray()){
            count[c - 'a']++;
        }
        for(int i = 0; i < 26; i++)
            if(count[i] != 0)
                return count[i];

        return 0;
    }

    public static void main(String[] args) {
        String words = "abcd,aabc,bd";
        String queries = "aaa,aa";
        System.out.println(Arrays.toString(compare(words,queries)));
    }
}
