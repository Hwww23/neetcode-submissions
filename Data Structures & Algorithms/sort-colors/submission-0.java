class Solution {
    public void sortColors(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        int i = 0;

        while (i <= r) {
            if (nums[i] == 0) {
                swap(nums, l, i);
                l++;
                i++;
            } else if (nums[i] == 1) {
                i++;
            } else {
                swap(nums, i, r);
                r--;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}