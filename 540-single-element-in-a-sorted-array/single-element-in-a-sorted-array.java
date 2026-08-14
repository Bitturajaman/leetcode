class Solution {
    public int singleNonDuplicate(int[] nums) {
        int low=0;
        int high=nums.length-1;
        int mid;
        while(low<high)
        {
            mid=low+(high-low)/2;
            int r=high-mid+1;
            int l=mid-low+1;
            if(nums[mid]==nums[mid+1])
            {
                if(r%2==1)
                {
                    low=mid+2;
                }
                else{
                    high=mid-1;
                }

            }
            else if(nums[mid]==nums[mid-1])
            {
                if(l%2==1)
                {
                    high=mid-2;
                }
                else{
                    low=mid+1;
                }

            }
            else{
                return nums[mid];
            }
        }
        return nums[low];
        
    }
}