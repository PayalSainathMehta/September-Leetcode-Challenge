import java.util.HashMap;
import java.util.Map;

public class WordPattern {

    static boolean isFollows(String pattern, String str){
        String[] words = str.split(" ");
        if(words.length != pattern.length())
            return false;
        Map index = new HashMap();
        for(Integer i = 0; i < words.length; i++)
            //we just check if dog has been mapped previously to a char, if yes, we take it and it should match for following occurrences of dog in str
            if(index.put(words[i], i) != index.put(pattern.charAt(i), i))
                return false;
        return true;
    }

    public static void main(String[] args) {
        String pattern = "abba";
        //dog has been mapped to a and cat to b, must follow for complete str
        String str = "dog cat cat dog";
        System.out.println(isFollows(pattern, str));
    }
}
