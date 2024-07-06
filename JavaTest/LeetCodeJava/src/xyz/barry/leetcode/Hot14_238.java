package xyz.barry.leetcode;

public class Hot14_238 {
    public int[] productExceptSelf(int[] nums) {

        int[] answer = new int[nums.length];

        answer[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            answer[i] = nums[i-1] * answer[i-1];
        }


        int lastRight = 1;
        for (int i = nums.length-1; i >= 0; i--) {
            answer[i] = answer[i] * lastRight;
            lastRight = lastRight * nums[i];
        }

        return answer;
    }
}
