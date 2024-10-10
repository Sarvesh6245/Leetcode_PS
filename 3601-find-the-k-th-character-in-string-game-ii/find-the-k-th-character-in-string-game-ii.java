class Solution {
    public char kthCharacter(long k, int[] arr) {
        int count = 0 ;
        for(int i = arr.length ; i >= 0 ; i--)
            if(k>Math.pow(2,i)){
                
                k-= Math.pow(2,i); if(arr[i]==1) count++;
            }
            count%=26;
        return (char) ('a' + count);
    }
}