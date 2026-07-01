class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        
        // 1. CRITICAL: Sort the array first so the two-pointer approach works
        Arrays.sort(nums);
        
        for (int f = 0; f < nums.length; f++) {
            // Optimization: If the first number is greater than 0, 
            // three positive numbers can never sum to 0.
            if (nums[f] > 0) {
                break;
            }
            
            // Skip duplicate values for the first element to avoid duplicate triplets
            if (f == 0 || nums[f] != nums[f - 1]) {
                twoSum(f, nums, res);
            }
        }
        
        return res;
    }

    // Helper method to find pairs that sum to -nums[f]
    private void twoSum(int f, int[] nums, List<List<Integer>> res) {
        int i = f + 1;
        int j = nums.length - 1;
        
        while (i < j) {
            int sum = nums[f] + nums[i] + nums[j];
            
            if (sum > 0) {
                j--; // Sum is too large, move the right pointer left
            } else if (sum < 0) {
                i++; // Sum is too small, move the left pointer right
            } else {
                // Found a valid triplet
                res.add(Arrays.asList(nums[f], nums[i], nums[j]));
                i++;
                j--;
                
                // Skip duplicates for the left pointer
                while (i < j && nums[i] == nums[i - 1]) {
                    i++;
                }
                // Skip duplicates for the right pointer
                while (i < j && nums[j] == nums[j + 1]) {
                    j--;
                }
            }
        }
    }
}