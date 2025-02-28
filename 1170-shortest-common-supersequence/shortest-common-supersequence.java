class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        int len1 = str1.length();
        int len2 = str2.length();
        String[] prev = new String[len2+1];
        String[] next = new String[len2+1];
        
        for (int i = 0; i < str2.length(); i++) {
            prev[i] = str2.substring(i);
        }
        prev[len2] = "";
        
        for (int i = len1 - 1; i >= 0; i--) {
            next[len2] = str1.substring(i);
            for (int j = len2 - 1; j >= 0; j--) {
                if (str1.charAt(i) == str2.charAt(j)) {
                    next[j] = str1.charAt(i) + prev[j + 1];
                } else {
                    String res1 = str1.charAt(i) + prev[j];
                    String res2 = str2.charAt(j) + next[j + 1];
                    next[j] = res1.length() < res2.length() ? res1 : res2;
                }
            }
            prev = next;
            next = new String[len2 + 1];
        }
        return prev[0];
    }
}