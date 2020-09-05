import java.math.BigInteger;

public class AddBinary {

    static String addBinary(String a, String b){
        StringBuilder sb = new StringBuilder();
        //start from end
        int i = a.length() - 1, j = b.length() -1, carry = 0, sum;
        while (i >= 0 || j >= 0) { //till first char
            sum = carry; //currently zero
            if (j >= 0) //choose second digit
                sum += b.charAt(j--) - '0'; //add it to sum
            if (i >= 0)
                sum += a.charAt(i--) - '0'; //same for first
            sb.append(sum % 2); //add remainder
            carry = sum / 2; //add carry
        }
        if (carry != 0)
            sb.append(carry);
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        String b1 = "11";
        String b2 = "1";
        System.out.println(addBinary(b1, b2));
    }
}
