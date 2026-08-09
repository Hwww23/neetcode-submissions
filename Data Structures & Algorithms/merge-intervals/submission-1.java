class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, ((a, b) -> a[0] - b[0]));

        int[] prev = intervals[0];
        List<int[]> res = new ArrayList<>();

        for (int i = 1; i < intervals.length; i++) {
            int[] curr = intervals[i];
            
            if (prev[1] >= curr[0]) {
                prev[1] = Math.max(prev[1], curr[1]);
            } else {
                res.add(prev);
                prev = curr;
            }
        }

        res.add(prev);
        return res.toArray(new int[res.size()][2]);
    }
}
