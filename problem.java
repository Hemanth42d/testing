// import java.util.Arrays;

public class problem {
    public static void main(String[] args) {
        // int[] height = { 1, 1 };
        // int result = trappingRainwater(height);
        // System.out.println(result);

        int[] prices = { 7, 1, 5, 3, 6, 4 };
        int ans = maxProfit(prices);
        System.out.println(ans);

        // int[] nums = { 1, 3, 5, 6 };
        // int target = 2;
        // int result1 = searchInsert(nums, target);
        // System.out.println(result1);
    }

    public static int trappingRainwater(int[] height) {
        int[] leftMax = new int[height.length];
        int[] rightMax = new int[height.length];
        int width = 1;
        int trappedWater = 0;

        leftMax[0] = height[0];
        for (int i = 1; i < leftMax.length; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }
        rightMax[height.length - 1] = height[height.length - 1];
        for (int i = rightMax.length - 2; i >= 0; i--) {
            rightMax[i] = Math.max(height[i], rightMax[i + 1]);
        }
        for (int i = 0; i < height.length; i++) {
            trappedWater = trappedWater + (((Math.min(leftMax[i], rightMax[i])) - height[i]) * width);
        }
        return trappedWater;
    }

    public static int searchInsert(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return start;
    }

    public static int maxProfit(int[] prices) {
        int maxProfit = Integer.MIN_VALUE;
        for (int i = 0; i <= prices.length - 1; i++) {
            int profit = prices[i + 1] - prices[i];
            if (profit > maxProfit)
                maxProfit = profit;
        }
        if (maxProfit < 0)
            return 0;
        return maxProfit;
    }
}
