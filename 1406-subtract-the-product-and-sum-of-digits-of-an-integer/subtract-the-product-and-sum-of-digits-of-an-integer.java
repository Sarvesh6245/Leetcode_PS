class Solution {
    public int subtractProductAndSum(int n) {
       int ans = 1;
       int sum = 0;
       int pro = 1;
    while (n!= 0) {
        int a = n%10;
        pro = pro*a;
        sum = sum+a;

        n = n/10;

    }
    ans = pro  - sum;
       return ans; 
    }
}