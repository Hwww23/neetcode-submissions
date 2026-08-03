class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1;
        int r = 1;

        for (int p : piles) {
            r = Math.max(p, r);
        }

        while (l < r) {
            int mid = l + (r - l) / 2;

            int time = processTime(mid, piles);

            if (time > h) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }

        return l;
    }

    private int processTime(int mid, int[] piles) {
        int time = 0;

        for (int p : piles) {
            time += Math.ceil((double) p / mid);
        }

        return time;
    }
}
