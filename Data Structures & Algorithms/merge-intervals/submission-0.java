class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, ((a, b) -> a[0] - b[0]));

        int[] prev = intervals[0];
        List<int[]> res = new ArrayList<>();

        for (int[] interval : intervals) {
            if (prev[1] >= interval[0]) {
                int end = Math.max(prev[1], interval[1]);
                prev = new int[] {prev[0], end};
                continue;
            }

            res.add(prev);
            prev = interval;
        }

        res.add(prev);
        return res.toArray(new int[res.size()][2]);
    }
}
