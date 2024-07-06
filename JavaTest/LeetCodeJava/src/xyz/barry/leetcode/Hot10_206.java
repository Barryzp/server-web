package xyz.barry.leetcode;

public class Hot10_206 {

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode first = head;
        ListNode second = first.next;

        head.next = null; //置为头结点
        while (second != null){
            ListNode temp = second;
            second = second.next;
            temp.next = first;
            first = temp;
        }

        return first;
    }

    public ListNode reverseList_recurse(ListNode head) {
        if (head != null){
            ListNode next = reverseList_recurse(head.next);
            if (next != null) next.next = head;
            else {// 第一个不为null的head是头结点
            }
        }

        return head;
    }

}
