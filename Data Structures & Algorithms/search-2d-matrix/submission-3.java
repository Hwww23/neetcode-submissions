class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int l = 0;
        int r = matrix.length * matrix[0].length - 1;

        while (l <= r) {
            int mid = l + (r - l) / 2;
            int i = mid / matrix[0].length;
            int j = mid % matrix[0].length;

            if (matrix[i][j] < target) {
                l = mid + 1;
            } else if (matrix[i][j] > target) {
                r = mid - 1;
            } else {
                return true;
            }
        }

        return false;
    }
}
