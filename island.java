// answer: https://leetcode-cn.com/problems/number-of-islands/solution/dao-yu-lei-wen-ti-de-tong-yong-jie-fa-dfs-bian-li-/
//模版
class Solution {
    void dfs(int[][] grid, int r, int c) {


// 判断 base case
        // 如果坐标 (r, c) 超出了网格范围，直接返回
        if (!inArea(grid, r, c)) {
            return;
        }
//防止重复遍历
        //0 —— 海洋格子 1 —— 陆地格子（未遍历过） 2 —— 陆地格子（已遍历过）

        if (grid[r][c] != 1) {
            return;
        }
        grid[r][c] = 2; // 将格子标记为「已遍历过」

// 访问上、下、左、右四个相邻结点
        dfs(grid, r - 1, c);
        dfs(grid, r + 1, c);
        dfs(grid, r, c - 1);
        dfs(grid, r, c + 1);
    }
    
    // 判断坐标 (r, c) 是否在网格中
    boolean inArea(int[][] grid, int r, int c) {
        return 0 <= r && r < grid.length 
                && 0 <= c && c < grid[0].length;
    }

    public int numIslands(char[][] grid) {

        return 0;
    }
}

//题目2:最大面积
//https://leetcode-cn.com/problems/max-area-of-island/
class Solution2 {
    public int maxAreaOfIsland(int[][] grid) {
        int res = 0;
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == 1) {
                    int a = area(grid, r, c);
                    res = Math.max(res, a);
                }
            }
        }
        return res;
    }
    
    int area(int[][] grid, int r, int c) {
        if (!inArea(grid, r, c)) {
            return 0;
        }
        if (grid[r][c] != 1) {
            return 0;
        }
        grid[r][c] = 2;
        
        return 1 
            + area(grid, r - 1, c)
            + area(grid, r + 1, c)
            + area(grid, r, c - 1)
            + area(grid, r, c + 1);
    }
    
    boolean inArea(int[][] grid, int r, int c) {
        return 0 <= r && r < grid.length 
                && 0 <= c && c < grid[0].length;
    }
    
    }

//题目3:岛周长
//https://leetcode-cn.com/problems/island-perimeter/
class Solution3 {
        public int islandPerimeter(int[][] grid) {
            for (int r = 0; r < grid.length; r++) {
                for (int c = 0; c < grid[0].length; c++) {
                    if (grid[r][c] == 1) {
                        // 题目限制只有一个岛屿，计算一个即可
                        return dfs(grid, r, c);
                    }
                }
            }
            return 0;
        }
        
        int dfs(int[][] grid, int r, int c) {
            // 函数因为「坐标 (r, c) 超出网格范围」返回，对应一条黄色的边
            if (!inArea(grid, r, c)) {
                return 1;
            }
            // 函数因为「当前格子是海洋格子」返回，对应一条蓝色的边
            if (grid[r][c] == 0) {
                return 1;
            }
            // 函数因为「当前格子是已遍历的陆地格子」返回，和周长没关系
            if (grid[r][c] != 1) {
                return 0;
            }
            grid[r][c] = 2;
            return dfs(grid, r - 1, c)
                + dfs(grid, r + 1, c)
                + dfs(grid, r, c - 1)
                + dfs(grid, r, c + 1);
        }
        
        // 判断坐标 (r, c) 是否在网格中
        boolean inArea(int[][] grid, int r, int c) {
            return 0 <= r && r < grid.length 
                    && 0 <= c && c < grid[0].length;
        }
        
        }