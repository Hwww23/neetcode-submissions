class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        PriorityQueue<int[]> board = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        PriorityQueue<int[]> alight = new PriorityQueue<>((a, b) -> a[1] - b[1]);

        for (int[] trip : trips) {
            board.offer(trip);
        }

        int cap = 0;
        while (!board.isEmpty()) {
            while (!alight.isEmpty() && board.peek()[1] >= alight.peek()[1]) {
                cap -= alight.poll()[0];
            }

            int[] node = board.poll();

            if (cap + node[0] > capacity) return false;

            alight.offer(new int[] {node[0], node[2]});
            cap += node[0];
        }

        return true;
    }
}