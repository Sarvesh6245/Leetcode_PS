class Solution {
    public int firstMissingPositive(int[] nums) {
        
        int i = 0;
        while(i < nums.length){
            int corr = nums[i] - 1;
            if(nums[i] > 0 && nums[i] <= nums.length && nums[i] != nums[corr]){
                swap(nums , i , corr);
            }
            else{
                i++;
            }
        }
        for(int j = 0; j < nums.length; j++){
            if(nums[j] != j + 1){
                return j + 1;
            }
        }
        return nums.length + 1;
    }

    private static void swap(int[] arr, int first, int last) {
        int temp = arr[first];
        arr[first] = arr[last];
        arr[last] = temp;
    }
}