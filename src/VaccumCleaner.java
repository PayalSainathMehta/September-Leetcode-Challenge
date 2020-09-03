public class VaccumCleaner {

    static boolean backToOriginal(String s){
        if(s.length() == 0 || s == null)
            return true;
        int count = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == 'U')
                count++;
            else if(s.charAt(i) == 'D')
                count--;
            else if(s.charAt(i) == 'R')
                count = count + 2;
            else
                count = count - 2;
        }
        if(count == 0)
            return true;
        return false;
    }

    public static void main(String[] args) {
        String s = "RUULLDRD";
        System.out.println(backToOriginal(s));
    }
}
