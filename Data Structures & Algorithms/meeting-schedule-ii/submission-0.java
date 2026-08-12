/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        Collections.sort(intervals, (a, b) -> a.start - b.start);
        PriorityQueue<Integer> q = new PriorityQueue<>((a, b) -> a - b);
        int max = 0;

        for (Interval interval : intervals) {
            while (!q.isEmpty() && q.peek() <= interval.start) {
                q.poll();
            }
            
            q.offer(interval.end);
            max = Math.max(max, q.size());
        }

        return max;
    }
}
