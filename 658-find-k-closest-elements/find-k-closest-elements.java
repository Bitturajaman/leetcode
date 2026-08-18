class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> list=new ArrayList<>();
        for( int ele:arr)
        {
            list.add(ele);
        }
        Collections.sort(list,(a,b)->{
          int absx=Math.abs(a-x);
          int absy=Math.abs(b-x);
          if(absx==absy)
          {
            return a-b;
          } 
         
            return absx-absy;
          
        });
        List<Integer> res=new ArrayList<>();
        for(int i=0;i<k;i++)
        {
            res.add(list.get(i));
        }
        Collections.sort(res);
        return res;
        
    }
}