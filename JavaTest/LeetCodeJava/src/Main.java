import xyz.barry.leetcode.*;

import java.util.List;

public class Main {
    public static void main(String[] args) {



        Hot11_200 hot11200 = new Hot11_200();
        char[][] cs = {{'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'}};

        int num = hot11200.numIslands(cs);


        System.out.println(num);
    }
}