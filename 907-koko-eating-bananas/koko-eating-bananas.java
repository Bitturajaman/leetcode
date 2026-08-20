class Solution {
    public boolean ispossible(int[] piles, int speed, int h) {
        long totalhr = 0;
        for (int pile : piles) {
            // Calculate ceil(pile / speed) using integer arithmetic to avoid floating-point inaccuracy
            totalhr += (pile + speed - 1) / speed;
        }
        return totalhr <= h;
    }

    public int minEatingSpeed(int[] piles, int h) {
        int max = Integer.MIN_VALUE;
        for (int pile : piles) {
            max = Math.max(max, pile);
        }

        int low = 1;      // Koko must eat at least 1 banana per hour
        int high = max;   // Maximum speed needed is the size of the largest pile

        while (low < high) {
            int mid = low + (high - low) / 2;
            if (ispossible(piles, mid, h)) {
                high = mid;      // Mid speed is workable, try to find a smaller one
            } else {
                low = mid + 1;   // Speed too slow, must increase
            }
        }
        return low;
    }
}