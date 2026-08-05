class Solution {
    public double myPow(double x, int n) {
       long bf=n;
       if(x==0){
       return 0.0;
       }
       if(bf<0)
       {
        x=1/x;
        bf=-bf;
       }
       double ans=1;
       while(bf>0){
       if(bf%2==1)
       {
        ans*=x;
       }
       x*=x;
       bf/=2;
       }
       return ans;
        
    }
}