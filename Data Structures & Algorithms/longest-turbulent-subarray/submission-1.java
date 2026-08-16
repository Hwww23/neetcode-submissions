class Solution {
    public int maxTurbulenceSize(int[] arr) {
        int max = 1;
        int curr = 1;
        int prev = 0;

        for (int i = 1; i < arr.length; i++) {
            int dir = Integer.compare(arr[i], arr[i - 1]);

            if (dir == 0) {
                curr = 1;
            } else if (dir == -prev) {
                curr++;
            } else {
                curr = 2;
            }

            max = Math.max(max, curr);
            prev = dir;
        }

        return max;
    }
}