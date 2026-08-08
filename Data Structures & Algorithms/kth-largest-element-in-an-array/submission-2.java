class Solution {
    Random rand = new Random();

    public int findKthLargest(int[] nums, int k) {
        int kth = nums.length - k;
        return quickSelect(nums, 0, nums.length - 1, kth);
    }

    private int quickSelect(int[] nums, int l, int r, int k) {
        int pivotIdx = l + rand.nextInt(r - l + 1);

        swap(nums, pivotIdx, r);

        int pivot = nums[r];
        int left = l;

        for (int i = l; i < r; i++) {
            if (nums[i] <= pivot) {
                swap(nums, left, i);
                left++;
            }
        }

        swap(nums, left, r);

        if (left > k) {
            return quickSelect(nums, l, left - 1, k);
        } else if (left < k) {
            return quickSelect(nums, left + 1, r, k);
        } else {
            return nums[k];
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
