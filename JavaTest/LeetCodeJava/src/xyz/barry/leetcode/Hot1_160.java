package xyz.barry.leetcode;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class Hot1_160 {

    public ListNode testHeadA(){
        ListNode head = new ListNode(4);
        head.next = new ListNode(1);
        head.next.next = new ListNode(8);
        head.next.next.next = new ListNode(5);
        return head;
    }
    public List<ListNode> getReverse(ListNode head){
        List<ListNode> ls = new ArrayList<ListNode>();
        ListNode p = head;
        while (p != null){
            ls.add(p);
            p = p.next;
        }
        Collections.reverse(ls);
        return ls;
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        List<ListNode> lsA = getReverse(headA);
        List<ListNode> lsB = getReverse(headB);

        int lengthLsA = lsA.size();
        ListNode pA=null, pB=null, intersect=null;
        for (int i = 0; i < lengthLsA; i++) {
            pA = lsA.get(i);
            pB = lsB.get(i);
            if (pA == pB){
                intersect = pA;
            }else{
                break;
            }
        }

        return intersect;
    }
}
