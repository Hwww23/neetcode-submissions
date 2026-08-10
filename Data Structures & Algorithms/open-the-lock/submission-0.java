class Solution {
    public int openLock(String[] deadends, String target) {
        HashSet<String> deadend = new HashSet<>(Arrays.asList(deadends));
        HashSet<String> visited = new HashSet<>();

        if (deadend.contains("0000")) return -1;

        Queue<String> q = new LinkedList<>();
        q.offer("0000");
        visited.add("0000");

        int turn = 0;
        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                String curr = q.poll();

                if (curr.equals(target)) return turn;

                for (int j = 0; j < 4; j++) {
                    String up = turn(curr, j, 1);
                    String down = turn(curr, j, -1);

                    if (!deadend.contains(up) && visited.add(up)) {
                        q.offer(up);
                    }

                    if (!deadend.contains(down) && visited.add(down)) {
                        q.offer(down);
                    }
                }
            }
            turn++;
        }

        return -1;
    }

    private String turn(String s, int idx, int dir) {
        char[] chars = s.toCharArray();

        int digit = chars[idx] - '0';
        digit = (digit + dir + 10) % 10;

        chars[idx] = (char) (digit + '0');

        return new String(chars);
    }
}