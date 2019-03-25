package com.company;

public class Main {

    /**
     * 状态转移方程：dp[m][n] = dp[m-1][n]+dp[m][n-1]
     * 多定义一行一列 最后一行表示为0
     * @param m
     * @param n
     */
    public static int dp(int m , int n){//m 行 n 列
        int [][] dp = new int [m+1][n+1];
        for (int i = 0 ;i <= m ; i++){
            dp[i][n] = 0;
        }
        for (int i = 0 ;i <= n ; i++){
            dp[m][i] = 0;
        }
        dp[1][1] = 1;//初始化
        for (int i = 1 ; i<=m ; i++){
            for (int j = 1 ; j<=n ;j++){
                if ( i == 1 && j == 1 ){
                    continue;
                }
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m][n];
    }
    public static void main(String[] args) {
        System.out.println(dp(7,3));
    }
}
