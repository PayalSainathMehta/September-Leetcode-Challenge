public class BuySellWithCooldown {

    //in this question, we can buy, sell then wait for cooldown 1 day then buy sell
    /*
    s0 - buy or rest
    s1 - sell or rest
    s2 - only rest as cooldown
     */
    /*
    state diagram

    s0 -> s0 = rest, s0 -> s1 = buy, hence s1 = -prices[0],
    s1 -> s1 = rest, s1 -> s2 = sell, hence s2 = 0 then s1 = Math.max(s1, s0 - prices[i])
    s2 -> s2 = rest
     */
    static int buySell(int[] prices){
        if(prices.length < 2) //as buy sell cant happen
            return 0;
        int s0 = 0;
        int s1 = -prices[0];
        int s2 = 0;
        for(int i = 1; i < prices.length; i++){
            int last_s2 = s2;
            s2 = s1 + prices[i]; //buying price
            s1 = Math.max(s1, s0 - prices[i]); //profit
            s0 = Math.max(s0, last_s2); //selling price
        }
        return Math.max(s0, s2);
    }

    public static void main(String[] args) {
        int[] prices = {1,2,3,0,2};
        System.out.println(buySell(prices));
    }
}
