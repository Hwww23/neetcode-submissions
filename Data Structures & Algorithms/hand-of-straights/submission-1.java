class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) return false;

        TreeMap<Integer, Integer> tm = new TreeMap<>();
        for (int i : hand) {
            tm.put(i, tm.getOrDefault(i, 0) + 1);
        }

        while (!tm.isEmpty()) {
            int start = tm.firstKey();

            for (int i = start; i < start + groupSize; i++) {
                if (tm.get(i) == null) return false;

                tm.put(i, tm.get(i) - 1);
                if (tm.get(i) == 0) {
                    tm.remove(i);
                }
            }
        }

        return true;
    }
}
