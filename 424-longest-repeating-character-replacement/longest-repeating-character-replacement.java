class Solution {
    public int characterReplacement(String s, int k) {
        int i = 0, j = 0;
        int maxc = 0; 
        int maxLength = 0; // 1. Use a separate variable for the max window length
        int[] count = new int[26];

        while (j < s.length()) { // Fixed typo
            char c = s.charAt(j); // Fixed syntax [] -> ()
            count[c - 'A'] += 1;
            maxc = Math.max(maxc, count[c - 'A']);
            
            // 2. Change 'while' to 'if'. We only ever need to shrink the window by 1 step 
            // at a time to maintain our maximum valid size.
            if ((j - i + 1) - maxc > k) {
                char d = s.charAt(i); // Fixed syntax [] -> ()
                count[d - 'A'] -= 1;
                i++;
                // 3. REMOVED the broken loop. Leaving maxc alone here is completely fine!
            }
            
            // 4. Track your result in maxLength instead of overwriting maxc
            maxLength = Math.max(maxLength, j - i + 1);
            j++;
        }
        return maxLength;
    }
}