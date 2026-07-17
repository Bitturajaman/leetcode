

class Solution {
    // Fixed logic: True if max of starts <= min of ends
    public boolean isoverlap(int[] int1, int[] int2) {
        return Math.max(int1[0], int2[0]) <= Math.min(int1[1], int2[1]);
    }

    public int[][] merge(int[][] intervals) {
        List<int[]> list = new ArrayList<>();
        for (int[] interval : intervals) {
            list.add(interval);
        }

        boolean flag = true;
        
        // Keep looping as long as we successfully merged something in the last pass
        while (flag) {
            flag = false;
            
            for (int i = 0; i < list.size(); i++) {
                int j = i + 1;
                while (j < list.size()) {
                    int[] int1 = list.get(i);
                    int[] int2 = list.get(j);
                    
                    if (isoverlap(int1, int2)) {
                        int1[0] = Math.min(int1[0], int2[0]);
                        int1[1] = Math.max(int1[1], int2[1]);
                        list.remove(j); // Shrinks the list size
                        flag = true;    // Signal that we need another pass
                    } else {
                        j++; // Only increment if we didn't remove the element at index j
                    }
                }
            }
        }

        // Convert the final list back into a 2D array
        return list.toArray(new int[list.size()][]);
    }
}