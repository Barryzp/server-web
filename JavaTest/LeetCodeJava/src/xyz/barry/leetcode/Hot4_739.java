package xyz.barry.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.ArrayDeque;
import java.util.Deque;

public class Hot4_739 {

    public int nextHigherTempCount(int currentIdx, int[] temperatures) {
        int count = 1;
        int currentTemp = temperatures[currentIdx];
        boolean hasAbove = false;
        for (int i = currentIdx + 1; i < temperatures.length; i++) {
            if (temperatures[i] > currentTemp) {
                hasAbove = true;
                break;
            }
            count++;
        }
        if (!hasAbove) return 0;
        return count;
    }

    // 超时的程序
    public int[] dailyTemperaturesDeprecated(int[] temperatures) {

        List<Integer> nextTemp = new ArrayList<>();

        int arrayLen = temperatures.length;
        for (int i = 0; i < arrayLen; i++) {
            if (i == arrayLen - 1) {
                nextTemp.add(0);
            } else {
                int nextCount = nextHigherTempCount(i, temperatures);
                nextTemp.add(nextCount);
            }
        }

        // 使用流（Stream）将List<Integer>转换为int[]

        return nextTemp.stream()             // 将List转换为Stream
                .mapToInt(Integer::intValue) // 转换为IntStream
                .toArray();
    }

    // 使用单调栈
    public int[] dailyTemperatures(int[] temperatures) {

        int arrayLen = temperatures.length;
        int[] nextTemp = new int[arrayLen]; // 动态初始化，必须指定长度
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < arrayLen; i++) {
            if (stack.isEmpty()) {
                stack.push(i);
            } else {
                int currentTemp = temperatures[i];
                // 循环：栈顶大于currentTemp
                while (!stack.isEmpty() && currentTemp > temperatures[stack.peek()]) {
                    // 索引出栈
                    int topIndex = stack.pop();
                    int countForHigherTemp = i - topIndex;
                    nextTemp[topIndex] = countForHigherTemp;
                }
                if (i == arrayLen - 1) {
                    nextTemp[i] = 0;
                } else {
                    stack.push(i);
                }
            }
        }

        return nextTemp;
    }

}
