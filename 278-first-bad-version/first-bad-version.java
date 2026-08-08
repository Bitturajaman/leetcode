/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int low=0;
        int high=n;
        int ans=0;
        int mid;
        while(low<=high)
        {
            mid=low+(high-low)/2;
            if(isBadVersion(mid))
            {
                ans=mid;
                high=mid-1;
            }
            else
            {
                low=mid+1;
            }
        }
        return ans;
        
    }
}