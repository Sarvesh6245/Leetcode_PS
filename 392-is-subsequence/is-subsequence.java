class Solution {
    public boolean isSubsequence(String s, String t) {
        int m=s.length();int n=t.length();
        int i=0;int j=0;
        if(s==null || t==null){
            return false;
        }
        if(m==0){
            return true;
        }
        if(n==0){
            return false;
        }
        while(i<n && j<m){
            if(s.charAt(j)==t.charAt(i)){
                j++;
            }
            i++;
        }
        if(j==m){
            return true;
        }
        return false;
    }
}