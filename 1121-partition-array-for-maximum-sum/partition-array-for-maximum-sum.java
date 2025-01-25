class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        
        int dp[] = new int[arr.length];

        Arrays.fill(dp, -1);

        return helper(arr, k, dp, 0);
    }

    private int helper(int arr[], int k, int dp[], int id) {

        int n = arr.length;
        if(id >= n) return 0;

        if(dp[id] != -1) {
            return dp[id];
        }

        int maxVal = 0, ans = 0;
        int end = Math.min(n, id + k);

        for(int j = id; j < end; j++) {
            maxVal = Math.max(maxVal, arr[j]);

            ans = Math.max(ans, maxVal * (j - id + 1) + helper(arr, k, dp, j+1));
        }

        return dp[id] = ans;
    }
}