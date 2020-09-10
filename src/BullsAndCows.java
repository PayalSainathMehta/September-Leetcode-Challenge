public class BullsAndCows {

    public static String getHint(String secret, String guess) {
        int bulls = 0, cows = 0;
        int[] numbers = new int[10]; //because digits are 0 to 9
        for(int i = 0; i < secret.length(); i++)
        {
            int s = Character.getNumericValue(secret.charAt(i)); //get the number
            int g = Character.getNumericValue(guess.charAt(i)); //get the number
            if(s == g)
                bulls++; //obviously if same, its a bull
            else //now for cows
            {
                if(numbers[s] < 0)
                    cows++; //whenever we see a number in s, we increment it to keep track
                if(numbers[g] > 0)
                    cows++;
                numbers[s]++; //whenever we see a number in s, we increment it to keep track
                numbers[g]--;
            }
        }
        return bulls + "A" + cows + "B";
    }

    public static void main(String[] args) {
        System.out.println(getHint("1807","7810"));
    }
}
