class Solution {
    public int numberOfAlternatingGroups(int[] colors) {
        int x = 0;
        for (int i = 0; i < colors.length - 2; i++) {
            // Check if the color at position i is the same as the color at position i+2
            // and different from the color at position i+1
            if (colors[i] == colors[i + 2] && colors[i] != colors[i + 1]) {
                x++;
            }
        }
        // Check the condition for the first and second-to-last elements
        // If the color at the first position is the same as the color at the second-to-last position
        // and different from the color at the last position, increment the count
        if (colors[0] == colors[colors.length - 2] && colors[0] != colors[colors.length - 1]) {
            x++;
        }
        // Check the condition for the second and last elements
        // If the color at the second position is the same as the color at the last position
        // and different from the color at the first position, increment the count
        if (colors[1] == colors[colors.length - 1] && colors[1] != colors[0]) {
            x++;
        }
        return x;
    }
}