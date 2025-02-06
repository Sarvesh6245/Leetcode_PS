class Solution {
    public int tupleSameProduct(int[] nums) {
    int n = nums.length;
    HashMap<Long, Integer> productMap = new HashMap<>();
    int nTuple = 0;
    for (int i = 0; i < n - 1; i++) {
      for (int j = i + 1; j < n; j++) {
        long product = (long) nums[i] * nums[j];
        productMap.put(product, productMap.getOrDefault(product, 0) + 1);
      }
    }
    for (var count : productMap.values()) {
      if (count > 1) {
        nTuple += count * (count - 1) / 2;
      }
    }
    return nTuple * 8;
  }
}