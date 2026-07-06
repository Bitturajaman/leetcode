

class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        long sum = 0;
        long max = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int dup = 0;

        // 1. Build the first window of size K
        for (int i = 0; i < k; i++) {
            sum += nums[i];
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            
            // If this element now appears twice, it's a duplicate
            if (map.get(nums[i]) == 2) {
                dup++;
            }
        }

        // If the first window has no duplicates, update max
        if (dup == 0) {
            max = Math.max(max, sum);
        }

        // 2. Slide the window across the rest of the array
        for (int i = k; i < nums.length; i++) {
            int numToAdd = nums[i];
            int numToRemove = nums[i - k];

            // --- ADD NEW ELEMENT (Right side of window) ---
            sum += numToAdd;
            map.put(numToAdd, map.getOrDefault(numToAdd, 0) + 1);
            if (map.get(numToAdd) == 2) {
                dup++; // It just became a duplicate
            }

            // --- REMOVE OLD ELEMENT (Left side of window) ---
            sum -= numToRemove;
            if (map.get(numToRemove) == 2) {
                dup--; // It was a duplicate, but reducing it makes it unique again
            }
            
            // Decrement its count in the map
            map.put(numToRemove, map.get(numToRemove) - 1);
            if (map.get(numToRemove) == 0) {
                map.remove(numToRemove); // Clean up map if count hits 0
            }

            // --- CHECK WINDOW VALIDITY ---
            if (dup == 0) {
                max = Math.max(max, sum);
            }
        }

        return max;
    }
}