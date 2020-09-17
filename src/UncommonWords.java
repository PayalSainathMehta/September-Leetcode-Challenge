import java.util.*;

public class UncommonWords {

    static String[] getUncommonWords(String A, String B){
        Map<String, Integer> map = new HashMap<>();
        for(String s: (A + " " + B).split(" ")) //add all
            map.put(s, map.getOrDefault(s, 0) + 1);
        List<String> result = new ArrayList<>();
        for(String s: map.keySet())
            if(map.get(s) == 1)
                result.add(s);
        return result.toArray(new String[0]); //to convert arraylist to String[]
    }

    public static void main(String[] args) {
        String sentence1 = "the tortoise beat the hare";
        String sentence2 = "the tortoise lost to the hare";
        System.out.println(Arrays.toString(getUncommonWords(sentence1, sentence2)));
    }
}
