class Solution {
    public boolean isMatch(String str, String pattern) {
        //mark the beginning and end of the str and pattern with a '#'
        str =  "#" + str + "#";
        pattern = "#" + pattern + "#";

        //split up the pattern into words that can be separated by arbitrary gaps
        //e.g. "#***apple*****pear**orange#" -> ["#", "apple", "pear", "orange#"]
        ArrayList<String> words = new ArrayList<>();
        int remainingLength = patternToWords(pattern, words);

        //find the first match of each word in the string
        int i = 0;
        int wordIndex = 0;
        String word = words.get(0);
        while (remainingLength <= str.length() - i) {
            if (wordMatches(str, word, i)) {
                remainingLength -= word.length();
                i += word.length();
                wordIndex++;
                if (wordIndex == words.size()) {
                    //the final word was matched
                    return true;
                }
                word = words.get(wordIndex);
            }
            else {
                i++;
            }
        }
        return false;
    }

    public boolean wordMatches(String str, String word, int startIndex) {
        boolean wordMatches = true;
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) != '?' && word.charAt(i) != str.charAt(startIndex+i)) {
                wordMatches = false;
                break;
            }
        }
        return wordMatches;
    }

    public int patternToWords(String pattern, List<String> words){
        int sumWordLengths = 0;
        int beginIndex = 0;
        for (int endIndex = 0; endIndex < pattern.length(); endIndex++) {
            if (pattern.charAt(endIndex) == '*') {
                words.add(pattern.substring(beginIndex, endIndex));
                endIndex++;
                while (endIndex < pattern.length() && pattern.charAt(endIndex) == '*') {
                    endIndex++;
                }
                beginIndex = endIndex;
            }
            sumWordLengths++;
        }
        words.add(pattern.substring(beginIndex));
        return sumWordLengths;
    }
}