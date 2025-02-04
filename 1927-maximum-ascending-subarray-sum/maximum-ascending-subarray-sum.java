class Solution {
    public int maxAscendingSum(int[] nums) {
        int n = nums.length;

        int temp = nums[0];  
        int max = temp;  

        for(int i = 1; i < n; i++) {
            while(i < n && nums[i] > nums[i - 1]) {
                temp += nums[i];
                i++;  
            }

            max = Math.max(max, temp);

            if(i < n)  
                temp = nums[i];  
        }
        return max;  
    }
}