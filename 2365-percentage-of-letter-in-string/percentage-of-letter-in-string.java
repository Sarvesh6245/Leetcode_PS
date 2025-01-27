class Solution {
    public int percentageLetter(String s, char letter) {

        int LetCount = 0;
        int n = s.length();

        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == letter){
                LetCount++;
            }
        }
        float ans = (LetCount * 100 /n);

        return (int)ans;
        
    }
}