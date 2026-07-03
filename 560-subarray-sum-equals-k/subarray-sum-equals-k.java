class Solution {
    public int subarraySum(int[] nums, int k) {
        int sum=0;
        int ans=0;
        HashMap<Integer,Integer>map=new HashMap<>();
        for(int num:nums)
        {
            sum+=num;
            if(sum==k)
            {
                ans++;
            }
           if (map.containsKey(sum - k))
            {
                ans += map.get(sum - k);
            }
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return ans;
        
    }
}