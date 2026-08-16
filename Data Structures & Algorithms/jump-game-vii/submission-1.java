class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {
        Queue<Integer> q = new LinkedList<>();
        HashSet<Integer> visited = new HashSet<>();

        q.offer(0);
        visited.add(0);

        while (!q.isEmpty()) {
            int curr = q.poll();

            if (curr == s.length() - 1) return true;

            int start = curr + minJump;
            int end = Math.min(curr + maxJump, s.length() - 1);

            for (int i = start; i <= end; i++) {
                if (s.charAt(i) == '0' && !visited.contains(i)) {
                    q.offer(i);
                    visited.add(i);
                }
            }
        }

        return false;
    }
}