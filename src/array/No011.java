package array;

public class No011 {
    public int maxArea(int[] height) {
        if (height == null || height.length < 2)
            return 0;
        int ans = 0;
        int i = 0;
        int j = height.length - 1;
        while (i < j) {
            ans = Math.max(ans, (j - i) * Math.min(height[i], height[j]));
            if (height[i] <= height[j]) {
                i++;
            } else {
                j--;
            }
        }
        return ans;
    }
}
