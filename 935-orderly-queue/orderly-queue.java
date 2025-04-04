class Solution {
    private static String sortString (String s){
        char tempArray[] = s.toCharArray();
        Arrays.sort(tempArray);
        return new String(tempArray);
    }
    
    public String orderlyQueue(String s, int k) {
        if (k > 1){
            return this.sortString(s);
        } 
        
        String minString = s;
        String sTwoTimes = s + s;
        int len = s.length();
        for (int index = 1; index < len; index++){
            String temp = sTwoTimes.substring(index, index + len);
            if (temp.compareTo(minString) < 0)
                minString = temp;
        }
        return minString;
    }
}