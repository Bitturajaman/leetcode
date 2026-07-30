class Solution {
    public String removeDuplicates(String s) {
        Stack<Character> stack=new Stack<>();
        for(int i=0;i<s.length();i++)
        
        {
            char c=s.charAt(i);
            if(!stack.isEmpty()&& stack.peek()==c)
            {
                stack.pop();
            }
            else{
                stack.push(c);
            }
        }
         StringBuilder sb=new StringBuilder();
        while(!stack.isEmpty()){
       
        sb.append(stack.pop());
        }
        sb.reverse();
        return sb.toString();
        
    }
}