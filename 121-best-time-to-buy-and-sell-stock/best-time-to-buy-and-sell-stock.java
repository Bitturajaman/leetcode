class Solution {
    public int maxProfit(int[] prices) {
        int profit=0;
        int n=prices.length;
      
        int min=prices[0];
        if(prices==null||prices.length==0)
        {
            return 0;
        }
        for( int i=1;i<n;i++)
        {
            profit=Math.max(profit,(prices[i]-min));
            min=Math.min(min,prices[i]);
        }
        return profit;
        
    }
}