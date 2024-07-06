package xyz.barry.leetcode;

// 打家劫舍，典型的动态规划问题，后一个结果需要前面的答案
public class Hot12_198 {

    int[] robbedMoney;

    public int rob(int[] nums){
        int totalLength = nums.length;
        robbedMoney = new int[totalLength];

        if (totalLength == 0) return 0;

        if (totalLength == 1) return nums[0];

        robbedMoney[0] = nums[0];
        robbedMoney[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < totalLength; i++) {
            int currentOne = nums[i];
            int preGot = robbedMoney[i-1];
            int prePreGot = robbedMoney[i-2];
            int currentMaxGot = Math.max(prePreGot + currentOne, preGot);
            robbedMoney[i] = currentMaxGot;
        }

        return robbedMoney[totalLength-1];
    }

    public int robNoArray(int[] nums){
        int totalLength = nums.length;
        int currentGot = 0, previousGot = 0, temp;

        for (int i = 0; i < totalLength; i++) {
            temp = currentGot;
            currentGot = Math.max(previousGot + nums[i], currentGot);
            previousGot = temp;
        }

        return currentGot;
    }

}
