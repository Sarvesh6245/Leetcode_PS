class Solution {
    public boolean isHappy(int n) {
        if(n == 1 || n == 7)
        {
            return true;
        }
        while(n >= 10)
        {
            int sum = 0;
            while(n >= 1)
            {
                int rem = n % 10;
                sum += (rem * rem);
                n /= 10;  
            }
            if(sum == 1 || sum == 7)
            {
                return true;
            }
            n = sum;
        }
        return n == 1;
    }
}