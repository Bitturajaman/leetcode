

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            }
            
            if (c == ')' || c == '}' || c == ']') {
               
                if (stack.isEmpty()) {
                    return false;
                }
                
                // Get top element to verify it matches
                char top = stack.peek();
                if ((c == ')' && top == '(') || 
                    (c == '}' && top == '{') || 
                    (c == ']' && top == '[')) {
                    stack.pop(); // Remove matching opening bracket
                } else {
                    return false; // Mismatched brackets
                }
            }
        }

        // Return true if all brackets were properly matched and popped
        if (stack.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
}