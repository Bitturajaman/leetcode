class Solution {
    public boolean isHappy(int n) {
        int fast = n;
        int slow = n;
        
        do {
            slow = check(slow);
            fast = check(check(fast));
        } while (fast != 1 && slow != fast);
        
        return fast == 1;
    }

    private int check(int n) {
        int sum = 0;
        while (n > 0) {
            int rem = n % 10;
            sum += rem * rem;
            n /= 10;
        }
        return sum;
    }
}