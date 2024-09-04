class Solution {
    public int lengthOfLastWord(String s) {
       s=s.trim();//to eliminate the spaces from end 
        int count=0;//for counting 
        for(int i=s.length()-1;i>=0;i--){//started loop from backward as we have to count last word
            if(s.charAt(i)==' '){//checking if at any index space comes then the loop will break
                break;
            }
            count++;//

        }
        return count;
        
    }
}