import java.util.*;

public class test {
    public static void main(String[] args) {
        // String[] menu = { "dosa", "idly", "samosa", "puri", "chapati" };
        // String key = "parota";
        // int result = linearSearch(menu, key);
        // System.out.println(result);

        // int[] nums = { 2, 4, 6, 8, 10 };
        // int[] nums = { -1, -2, -3, -4 };
        // int[] nums = { -2, -3, 4, -1, -2, 1, 5, -3 };
        int[] nums = { -2, -1 };
        // int result1 = getLargest(nums);
        // System.out.println(result1);

        int result2 = binarySearch(nums, 58);
        System.out.println(result2);
        // reverseArray(nums);
        // arrayPairs(nums);
        // subArrays(nums);
        // int result3 = subArrays(nums);
        // int result4 = prefixSum(nums);
        // System.out.println(result4);

        int result5 = kadanesAlgo(nums);
        System.out.println(result5);
    }

    public static int linearSearch(String[] menu, String key) {
        for (int i = 0; i < menu.length; i++) {
            if (menu[i] == key) {
                return i;
            }
        }
        return -1;
    }

    public static int getLargest(int[] nums) {
        int largest = Integer.MIN_VALUE;
        int smallest = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > largest) {
                largest = nums[i];
            }
            if (nums[i] < smallest) {
                smallest = nums[i];
            }
        }
        // System.out.println("Smallest number is : " + smallest);
        return largest;
    }

    public static int binarySearch(int[] nums, int key) {
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] == key) {
                return mid;
            } else if (nums[mid] < key) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }

    public static void reverseArray(int[] nums) {
        for (int i = 0; i <= nums.length / 2; i++) {
            int temp = nums[i];
            nums[i] = nums[nums.length - i - 1];
            nums[nums.length - i - 1] = temp;
        }
        System.out.println(Arrays.toString(nums));
    }

    public static void arrayPairs(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                System.out.print(" ( " + nums[i] + "," + nums[j] + ")" + " ");
            }
            System.out.println();
        }
    }

    public static int subArrays(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        // int minSum = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                int sum = 0;
                for (int k = i; k <= j; k++) {
                    sum = sum + nums[k];
                }
                // System.out.print(sum + " ");
                if (sum > maxSum) {
                    maxSum = sum;
                }
            }
        }
        return maxSum;
    }

    public static int prefixSum(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int[] prefix = new int[nums.length];

        prefix[0] = nums[0];
        for (int i = 1; i < prefix.length; i++) {
            prefix[i] = prefix[i - 1] + nums[i];
        }

        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                int sum = 0;
                sum = i == 0 ? prefix[j] : prefix[j] - prefix[i - 1];
                if (sum > maxSum) {
                    maxSum = sum;
                }
            }
        }
        return maxSum;
    }

    public static int kadanesAlgo(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int currSum = 0;
        int smallestSumNeg = Integer.MIN_VALUE;
        int currSumNeg = 0;

        if (nums.length == 1) {
            maxSum = nums[0];
            return maxSum;
        } else {
            for (int i = 0; i < nums.length; i++) {
                currSum = currSum + nums[i];
                if (currSum < 0) {
                    currSum = 0;
                    if (currSumNeg > smallestSumNeg) {
                        smallestSumNeg = currSumNeg;
                    }
                    currSumNeg = currSumNeg + nums[i];
                }
                if (currSum > maxSum) {
                    maxSum = currSum;
                }
            }
            if (currSum == 0) {
                return smallestSumNeg;
            }
            return maxSum;
        }

    }

    // public static int kadanesAlgo(int[] nums) {
    // int maxSum = Integer.MIN_VALUE;
    // int currSum = 0;

    // for (int i = 0; i < nums.length; i++) {
    // currSum = currSum + nums[i];
    // if (currSum < 0) {
    // currSum = 0;
    // }
    // maxSum = Math.max(currSum, maxSum);
    // }
    // return maxSum;
    // }
}
