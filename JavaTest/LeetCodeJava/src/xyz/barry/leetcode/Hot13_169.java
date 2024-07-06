package xyz.barry.leetcode;

import java.util.Random;

public class Hot13_169 {
    // 随机化

    public int countNum(int[] nums, int index){
        int count = 0, num = nums[index];

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == num) count++;
        }

        return count;
    }

    public int majorityElement(int[] nums) {
        while (true){
            Random r = new Random();
            int randIdx = r.nextInt(nums.length);
            int count = countNum(nums, randIdx);
            if (count > (nums.length/2)) return nums[randIdx];
        }
    }
}
