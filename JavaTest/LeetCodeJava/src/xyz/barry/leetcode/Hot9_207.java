package xyz.barry.leetcode;

import java.util.ArrayList;
import java.util.List;

// 拓扑排序（Topological Sorting）是一种对**有向图**的顶点进行排序的方法
public class Hot9_207 {

    // 建模成一个图结构，进行遍历，如果存在有环说明不对
    List<ArrayList<Integer>> edges = new ArrayList<>();
    int[] visited;
    boolean existLoop = false;


    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // 先生成图结构
        visited = new int[numCourses];

        // 初始化边数组
        for (int i = 0; i < numCourses; i++) {
            edges.add(new ArrayList<>());
        }

        for (int[] courseInfo : prerequisites){
            edges.get(courseInfo[1]).add(courseInfo[0]);
        }

        // 遍历图，利用DFS遍历，拓扑排序是针对于有向无环图的，不能出现环
        for (int i = 0; i < numCourses && !existLoop; i++) {
            if (visited[i] == 0){
                dfs(i);
            }
        }

        return !existLoop;
    }

    public void dfs(int vert){
        // 0代表未搜索，1代表搜索中，2代表已经搜索
        visited[vert] = 1;

        List<Integer> neighborEdge = edges.get(vert);
        for (int neighbor : neighborEdge){
            if (visited[neighbor] == 1){
                existLoop = true;
                break;
            }

            if (visited[neighbor] == 0){
                dfs(neighbor);
            }
        }

        visited[vert] = 2;
    }

}
