import java.util.Arrays;

class first {
    public static void main(String args[]) {
        int[] arr = { 2, 5, 5, 11 };
        int[] ans = twoSum(arr, 10);
        System.out.println(Arrays.toString(ans));
    }

    public static int[] twoSum(int[] nums, int target) {
        int[] newArr = new int[2];
        boolean ans = false;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 1; j < nums.length; j++) {
                if (i != j && target == nums[i] + nums[j]) {
                    newArr[0] = i;
                    newArr[1] = j;
                    ans = true;
                    break;
                }
            }
            if (ans) {
                break;
            }
        }
        return newArr;
    }

}