import xyz.barry.leetcode.Hot7_215;
import xyz.barry.leetcode.ListNode;

import java.util.List;

public class Main {
    public static void main(String[] args) {


        Hot7_215 hot7215 = new Hot7_215();
        int res = hot7215.findKthLargest(new int[]{3,2,3,1,2,4,5,5,6}, 4);

        System.out.println(res);
    }
}