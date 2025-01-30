class Solution {
    
    public int getPmt(int i){
        if(i<=1)return 1;
        return i*getPmt(i-1);
    }

    public String getPermutation(int n, int k) {
        int[] arr = new int[n+1];
       
     
        StringBuilder s = new StringBuilder();
        while(k>0){
            n--;
            int pmt = getPmt(n);
            for(int i = 1;i<arr.length; i++){
                if(arr[i] == 0){
                    if(k>pmt)
                        k-=pmt;
                    else{
                        k -= k==pmt?k:0;
                        s.append(""+i);
                        arr[i] = 1;
                        break;
                    }
                }
            }
        }
        for(int i=arr.length-1;i>0;i--)
            if(arr[i]==0)s.append(""+i);
        return s.toString();
    }
}