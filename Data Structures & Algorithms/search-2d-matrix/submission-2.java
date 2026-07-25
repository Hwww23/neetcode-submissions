class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;
        
        int l = 0;
        int r = row * col - 1;

        while (l <= r) {
            int m = l + (r - l) / 2;
            int val = matrix[m / col][m % col];

            if (target < val) {
                r = m - 1;
            } else if (target > val) {
                l = m + 1;
            } else {
                return true;
            }
        }

        return false;
    }
}
