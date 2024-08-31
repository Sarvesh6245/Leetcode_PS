class Solution {
    public String removeTrailingZeros(String num) {
        int len=num.length();
        int temp=len;
        for(int i=len-1;i>=0;i--){
            if(num.charAt(i)!='0' ) {
               return num.substring(0,i+1);
            }
        }
        return "";
    }
}