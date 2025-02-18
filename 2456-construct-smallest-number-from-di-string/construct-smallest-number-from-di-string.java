class Solution {
    public String smallestNumber(String pattern) {
        StringBuilder sb=new StringBuilder();
        int[] st=new int[pattern.length()+1];
        int ind=0;
        for(int i=0;i<=pattern.length();i++){
            st[ind++]=i+1;
            if(i==pattern.length() || pattern.charAt(i)=='I'){
                while(ind>0){
                    ind--;
                    sb.append(st[ind]);
                }
            }
        }
        return sb.toString();
    }
}