class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);

        int rem = 0;
        int currEnd = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < currEnd) {
                rem++;
            } else {
                currEnd = intervals[i][1];
            }
        }

        return rem;
    }
}
