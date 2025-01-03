class Solution {
    public int[] sortArray(int[] nums) {
         mergesort(nums,0,nums.length-1);
         return nums;
   }
   public void mergesort(int nums[],int low,int high){
    if(low == high){
        return;
    }

    int middle=(low+high)/2;
    mergesort(nums,low,middle);
    mergesort(nums,middle+1,high);
    merge(nums,low,middle,high);
   }
   public void merge(int[] nums,int low,int middle,int high){
    int left=low;
    int right=middle+1;
    List<Integer> temp=new ArrayList<>();
    while(left <= middle && right <= high){
        if(nums[left] <= nums[right]){
            temp.add(nums[left]);
            left++;
        }
        else{
            temp.add(nums[right]);
            right++;
        }
    }
    while(left <= middle){
        temp.add(nums[left]);
        left++;
    }
    while(right <= high){
        temp.add(nums[right]);
        right++;
    }

    for(int i=low;i<=high;i++){
        nums[i] =temp.get(i-low);
    }

   }
    
}