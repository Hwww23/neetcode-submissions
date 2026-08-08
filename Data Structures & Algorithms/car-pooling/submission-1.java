class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        Arrays.sort(trips, (a, b) -> a[1] - b[1]);
        PriorityQueue<int[]> alight = new PriorityQueue<>((a, b) -> a[1] - b[1]);

        int cap = 0;
        for (int[] trip : trips) {
            while (!alight.isEmpty() && trip[1] >= alight.peek()[1]) {
                cap -= alight.poll()[0];
            }

            if (cap + trip[0] > capacity) return false;

            alight.offer(new int[] {trip[0], trip[2]});
            cap += trip[0];
        }

        return true;
    }
}