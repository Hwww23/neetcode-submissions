class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int l = 0;
        int r = 0;

        for (int w : weights) {
            l = Math.max(l, w);
            r += w;
        }

        while (l < r) {
            int mid = l + (r - l) / 2;

            int day = processDays(mid, weights);

            if (day > days) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }

        return l;
    }

    private int processDays(int mid, int[] weights) {
        int day = 1;
        int curr = 0;

        for (int w : weights) {
            curr += w;
            
            if (curr > mid) {
                day++;
                curr = w;
            }
        }
        return day;
    }
}