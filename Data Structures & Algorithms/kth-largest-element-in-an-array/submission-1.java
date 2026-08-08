class Solution {
    public int findKthLargest(int[] nums, int k) {
        int kth = nums.length - k;
        return quickSelect(nums, 0, nums.length - 1, kth);
    }

    private int quickSelect(int[] nums, int l, int r, int k) {
        int pivot = nums[r];
        int left = l;

        for (int i = l; i < r; i++) {
            if (nums[i] < pivot) {
                int temp = nums[left];
                nums[left] = nums[i];
                nums[i] = temp;
                left++;
            }
        }

        int temp = nums[left];
        nums[left] = nums[r];
        nums[r] = temp;

        if (left > k) {
            return quickSelect(nums, l, left - 1, k);
        } else if (left < k) {
            return quickSelect(nums, left + 1, r, k);
        } else {
            return nums[k];
        }
    }
}
