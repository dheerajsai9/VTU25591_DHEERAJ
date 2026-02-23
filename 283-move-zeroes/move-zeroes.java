class Solution {
    public void moveZeroes(int[] nums) {
        int k = 0; // index for next non-zero

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[k++] = nums[i];
            }
        }

        // fill remaining with zeros
        while (k < nums.length) {
            nums[k++] = 0;
        }
    }
}