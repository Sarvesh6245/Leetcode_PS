class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (String str : strs) {
            int[] chars = new int[30];
            for (int i = 0; i < str.length(); i ++) {
                chars[str.charAt(i) - 'a'] ++;
            }
            boolean foundAnagram = map.containsKey(Arrays.hashCode(chars));
            List<String> listToAdd;
            if (foundAnagram) {
                listToAdd = ans.get(map.get(Arrays.hashCode(chars)));
                listToAdd.add(str);
            } else {
                listToAdd = new ArrayList<>();
                map.put(Arrays.hashCode(chars), ans.size());
                listToAdd.add(str);
                ans.add(listToAdd);
            }
        }
        return ans;
    }
}