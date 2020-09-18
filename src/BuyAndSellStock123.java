public class BuyAndSellStock123 {

    static int buySellAtmostOne(int[] prices){
        //we can do atmost one transaction, maximize profit in that one.
        //so maximize sellprice - buyprice
        int buyPrice = Integer.MAX_VALUE;
        int profit = 0;
        for(int i = 0; i < prices.length; i++){
            if(prices[i] < buyPrice)
                buyPrice = prices[i];
            else if(prices[i] - buyPrice > profit)
                profit = prices[i] - buyPrice;
        }
        return profit;
    }

    static int buySellAnyMuch(int[] prices){
        //in this we shall find the smallest buy price and the largest sell price in a consecutive range.
        int buy, sell, profit = 0;
        int n = prices.length - 1;
        for(int i = 0; i < n; i++){
            //continue incrementing till smaller found
            while(i < n && prices[i] >= prices[i + 1])
                i++;
            buy = prices[i];

            //continue incrementing till larger found
            while(i < n && prices[i] < prices[i + 1])
                i++;
            sell = prices[i];

            profit += sell - buy;
        }
        return profit;
    }

    static int buySellAtmostTwo(int[] prices){
        //perform atmost two transactions
        //buy -> sell must be followed by buy -> sell

        int t1buy = Integer.MAX_VALUE;
        int t2buy = Integer.MAX_VALUE;
        int t1profit = 0;
        int t2profit = 0;
        for(int curPrice: prices){
            t1buy = Math.min(t1buy, curPrice); //minimum for buying
            t1profit = Math.max(t1profit, curPrice - t1buy); //maximum for profit

            t2buy = Math.min(t2buy, curPrice - t1profit); //next buy must be after buy->sell
            t2profit = Math.max(t2profit, curPrice - t2buy);
        }
        return t2profit;
    }

    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        System.out.println(buySellAtmostOne(prices));
        System.out.println(buySellAnyMuch(prices));
        int[] prices2 = {3,3,5,0,0,3,1,4};
        System.out.println(buySellAtmostTwo(prices2));
    }
}
