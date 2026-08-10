class Solution {
    public int mySqrt(int x) {

        int low=1;
        int high=x;
        int mid;
        int ans=0;
        while(low<=high)
        {
            mid=low+(high-low)/2;
            long val=(long) mid*mid;
            if(val>x)
            {
            high=mid-1;
                

            }
            else{
            ans=mid;
            low=mid+1;
            }
           
            
        }
        return ans;
        
    }
}