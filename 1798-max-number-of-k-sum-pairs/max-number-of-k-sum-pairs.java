class Solution {
    public int maxOperations(int[] nums, int k) {
        int c = 0, n = nums.length;

        Arrays.sort(nums);
        int left = 0, right = n-1;
        while(left<right){
            if(nums[left] + nums[right] == k){
                c++;
                left++;
                right--;
            }
            else if(nums[left] + nums[right] < k){
                left++;
            }
            else{
                right--;
            }
        }
        return c;
    }
}