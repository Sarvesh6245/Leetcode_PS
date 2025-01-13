class Solution {
    public String minWindow(final String s, final String t) {
        final int[] tCount = new int[58];

        for(int i = 0; i < t.length(); ++i)
            tCount[t.charAt(i) - 'A']++;

        final int[] count = new int[58];
        
        int j = 0, start = 0, end = 100001;

        for(int i = 0; i < s.length(); ++i) {
            count[s.charAt(i) - 'A']++;

            if(isValid(count, tCount)) {
                while(j < s.length() && isValid(count, tCount))
                    count[s.charAt(j++) - 'A']--;

                int minLength = end - start + 1, length = i - j + 1;

                if(length < minLength) {
                    start = j - 1;
                    end = i;
                }
            }
        }

        return end == 100001 ? "" : s.substring(start, end + 1);
    }

    private boolean isValid(final int[] count, final int[] tCount) {
        for(int i = 0; i < 58; ++i)
            if(tCount[i] > count[i])
                return false;

        return true;
    }
}