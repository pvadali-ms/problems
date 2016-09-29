package leetcode.hard;

/**
 * Created by PV029500 on 9/29/2016.
 */
public class TrappingRainWater {

    public int trap(int[] height) {

        if(height.length < 3) return 0;
        int prev = height[0];
        int[] forward = new int[height.length];
        int[] backward = new int[height.length];
        forward[0] = 0;
        for (int i = 1; i < height.length; i++) {
            if (height[i] < prev) {
                forward[i] = prev - height[i];
            } else {
                prev = height[i];
                forward[i] = 0;
            }
        }
        backward[height.length - 1] = 0;
        prev = height[height.length - 1];
        for (int i = height.length - 2; i >= 0; i--) {
            if (height[i] < prev) {
                backward[i] = prev - height[i];
            } else {
                prev = height[i];
                backward[i] = 0;
            }
        }
        int sum = 0;
        for (int i = 0; i < height.length; i++) {
            sum += Math.min(backward[i], forward[i]);
        }
        return sum;
    }
}
