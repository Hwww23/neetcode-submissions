class Solution {
    public int[] sortArray(int[] nums) {
        quickSort(0, nums.length - 1, nums);
        return nums;
    }

    private void quickSort(int l, int r, int[] nums) {
        if (l >= r) return;
        
        int pivot = nums[r];
        int left = l;

        for (int i = l; i < r; i++) {
            if (nums[i] < pivot) {
                swap(nums, left, i);
                left++;
            }
        }

        swap(nums, left, r);

        quickSort(l, left - 1, nums);
        quickSort(left + 1, r, nums);
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}