package com.company;

public class Main {

    /**
     *
     * 多定义一行一列 最后一行表示为0
     *
     *
     * 输入:
     * [
     *   [0,0,0],
     *   [0,1,0],
     *   [0,0,0]
     * ]
     * 输出: 2
     * 解释:
     * 3x3 网格的正中间有一个障碍物。
     * 从左上角到右下角一共有 2 条不同的路径：
     * 1. 向右 -> 向右 -> 向下 -> 向下
     * 2. 向下 -> 向下 -> 向右 -> 向右
     *
     * 状态转移方程：dp[m][n] = dp[m-1][n]+dp[m][n-1]
     *  o[m][n]为1时 dp[m][n] = 0
     */
    public static int dp(int[][] obstacleGrid){//m 行 n 列
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int [][] dp = new int [m+1][n+1];
        for (int i = 0 ;i <= m ; i++){
            dp[i][n] = 0;
        }
        for (int i = 0 ;i <= n ; i++){
            dp[m][i] = 0;
        }
        if (obstacleGrid[0][0] == 1){
            dp[1][1] = 0;//初始化
        }else{
            dp[1][1] = 1;//初始化
        }
        for (int i = 1 ; i<=m ; i++){
            for (int j = 1 ; j<=n ;j++){
                if ( i == 1 && j == 1 ){
                    continue;
                }
                dp[i][j] = obstacleGrid[i-1][j-1]==0?dp[i-1][j] + dp[i][j-1]:0;
            }
        }
        return dp[m][n];
    }
    public static void main(String[] args) {
        int[][] obstacleGrid = {{0,0,0},{0,1,0},{0,0,0}};
        System.out.println(dp(obstacleGrid));
    }
}
