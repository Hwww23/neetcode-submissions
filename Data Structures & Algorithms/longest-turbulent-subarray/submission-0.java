class Solution {
    public int maxTurbulenceSize(int[] arr) {
        int max = 1;
        int curr = 1;
        int dir = 0;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[i - 1]) {
                if (dir == 0 || dir == -1) {
                    curr++;
                    max = Math.max(max, curr);
                    dir = 1;
                } else {
                    curr = 2;
                }
            } else if (arr[i] < arr[i - 1]) {
                if (dir == 0 || dir == 1) {
                    curr++;
                    max = Math.max(max, curr);
                    dir = -1;
                } else {
                    curr = 2;
                }
            } else {
                curr = 1;
            }
        }

        return max;
    }
}