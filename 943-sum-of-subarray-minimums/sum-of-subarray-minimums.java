class Solution {
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        int[] nsl = new int[n];
        int[] nsr = new int[n];
        // Arrays.fill(nsl,-1);
        // Arrays.fill(ngr,n);
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<n;i++){   //NSL
            while(!st.isEmpty()&&arr[st.peek()]>=arr[i])
                st.pop();
            nsl[i] = st.isEmpty()?-1:st.peek();
            st.push(i);
        }
        st.clear();
        for(int i=n-1;i>=0;i--){     //NSR
            while(!st.isEmpty()&&arr[st.peek()]>arr[i])
                st.pop();
            nsr[i]=st.isEmpty()?n:st.peek();
            st.push(i);
        }

        int mod = (int)1e9+7;
        long ans =0;
        for(int i=0;i<n;i++){
            ans += (long)(i-nsl[i])*(nsr[i]-i)%mod * arr[i]%mod;
            ans %=mod;
        }
        return (int) ans;
    }
}