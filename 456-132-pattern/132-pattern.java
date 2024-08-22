class Solution {
    public boolean find132pattern(int[] nums) {
        int n = nums.length;
        Integer[] onePrefix = new Integer[n];

        Integer one = null;
        for (int i = 0; i < nums.length; i++) {
            if (one != null && one < nums[i]) {
                onePrefix[i] = one;
            }

            if (one == null || one > nums[i]) {
                one = nums[i];
            }
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = nums.length - 1; i >= 0; i--) {
            Integer j = onePrefix[i];
            if(j == null){
                pq.add(nums[i]);
                continue;
            }
            
            while(!pq.isEmpty() && pq.peek() <= j){
                pq.remove();
            }

            if(!pq.isEmpty() && pq.peek() < nums[i]){
                // System.out.println(j + " " + nums[i] + " " + stack);
                return true;
            }
            pq.add(nums[i]);
        }

        return false;
    }
}