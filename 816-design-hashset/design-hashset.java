class MyHashSet {

    int capacity;
    int[] arr;
    // int size = 0;

    public MyHashSet() {
        capacity = 1000000;
        arr = new int[capacity];
        Arrays.fill(arr, Integer.MIN_VALUE);
    }
    
    public void add(int key) {
        // the key needs to be hashed first and converted to an array index
        // Since our goal is an array index to store the key, not a 32-bit integer, we combine hashCode() 
        // with a modular hashing in our implementation to produce integers between 0 - (capacity - 1). 
        // Ref: Algorithms, 4th Edition by Robert Sedgewick and Kevin Wayne 
        int index = normalizeIndex(Integer.hashCode(key));
        arr[index] = key;
    }
    
    public void remove(int key) {
        int index = normalizeIndex(Integer.hashCode(key));
        arr[index] = Integer.MIN_VALUE;
    }
    
    public boolean contains(int key) {
        int index = normalizeIndex(Integer.hashCode(key));
        return arr[index] == key;
    }

    private int normalizeIndex(int keyHash){
        return (keyHash & 0x7FFFFFFF) % capacity;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */