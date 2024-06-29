package xyz.barry.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Hot3_234 {
    public boolean isPalindrome(ListNode head) {
        List<Integer> list = new ArrayList<>();

        // copy linklist values to list
        ListNode p = head;
        while (p != null){
            list.add(p.val);
            p = p.next;
        }

        // judge in the list
        int size = list.size();
        if (size <= 1) return true;

        int loops = (int) Math.round(size/2.0);
        for (int i = 0; i < loops; i++) {
            int front = list.get(i);
            int back = list.get(size-i-1);
            if ( front != back) return false;
        }
        return true;
    }
}
