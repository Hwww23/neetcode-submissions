class Solution {
    public int[] getOrder(int[][] tasks) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for (int i = 0; i < tasks.length; i++) {
            pq.offer(new int[] {tasks[i][0], tasks[i][1], i});
        }

        PriorityQueue<int[]> process = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        int time = 0;
        int[] res = new int[tasks.length];
        int i = 0;
        
        while (!pq.isEmpty() || !process.isEmpty()) {
            if (process.isEmpty() && time < pq.peek()[0]) {
                time = pq.peek()[0];
            }
            
            while (!pq.isEmpty() && time >= pq.peek()[0]) {
                int[] node = pq.poll();
                process.offer(new int[] {node[1], node[2]});
            }

            int[] node = process.poll();
            res[i++] = node[1];
            time += node[0];
        }

        return res;
    }
}