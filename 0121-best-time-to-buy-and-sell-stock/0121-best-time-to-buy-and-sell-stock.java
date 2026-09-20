class Solution {
    public int maxProfit(int[] prices) {
    //     int s =0 ;
    //     int n = prices.length;
    //     int b = prices[0];
    //     for(int i= 1 ; i<=n-1;i++){
    //         if(b >= prices[i]){
    //             b = prices[i];
    //         }
    //         else if(b<prices[i]){
    //             s = Math.max(s , prices[i]-b);
    //         }
    //     }
    // return s;
        int min_value = Integer.MAX_VALUE;
        int profit = 0;
        for (int i = 0; i < prices.length; i++){
            min_value = Math.min(min_value, prices[i]);
            profit = Math.max(profit, prices[i] - min_value);
        }

        return profit;
    }
}