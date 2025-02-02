class Solution {
    public int splitArray(int[] nums, int k) {
        int start = findStart(nums);
        int end = findEnd(nums);
        int ans = start;
        while (start <= end) {
            int mid = (start + end) / 2;
            int part = splitArrayKTimes(nums, mid);
            if (part > k) {
                start = mid + 1;
            } else {
                ans = mid;
                end = mid - 1;
            }
        }
        return ans;
    }

    /*
     * Function to split the array in k times
     */
    int splitArrayKTimes(int[] nums, int mid) {
        int sum = 0;
        int count = 1;
        for (int i = 0; i < nums.length; i++) {
            if (sum + nums[i] > mid) {
                sum = nums[i];
                count++;
            } else {
                sum = sum + nums[i];
            }
        }
        return count;
    }   

    /*
     * Give the start range for the ans(minMax)
     */
    int findStart(int[] nums) {
        int max = nums[0];
        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
        }
        return max;
    }

    /*
     * Give the end range for the ans(minMax)
     */
    int findEnd(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];
        }
        return sum;
    }
}