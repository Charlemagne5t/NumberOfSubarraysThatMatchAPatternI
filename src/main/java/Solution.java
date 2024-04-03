class Solution {
    public int countMatchingSubarrays(int[] nums, int[] pattern) {
        int count = 0;
        int n = nums.length;
        int m = pattern.length;
        int start = 0;
        int end = m;

        while (end < n) {
            if (check(nums, start, end, pattern)) {
                count++;
            }
            start++;
            end++;
        }

        return count;
    }

    boolean check(int[] nums, int start, int end, int[] pattern) {
        int j = 0;
        for (int i = start + 1; i <= end; i++) {
            if (pattern[j] == -1) {
                if (nums[i] >= nums[i - 1]) {
                    return false;
                }
            } else if (pattern[j] == 0) {
                if (nums[i] != nums[i - 1]) {
                    return false;
                }
            } else {
                if (nums[i] <= nums[i - 1]) {
                    return false;
                }
            }
            j++;
        }

        return true;
    }
}