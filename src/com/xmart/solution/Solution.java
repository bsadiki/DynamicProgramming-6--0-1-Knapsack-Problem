package com.xmart.solution;

public class Solution {
    public static void main(String[] args) {
        int[] values = {60, 100, 120};
        int[] weights = {10, 20, 30};
        int W = 50;
        System.out.println(solveSnapSack(values, weights, W));
        int[] values1 = {10, 12, 21};
        int[] weights1 = {2, 5, 8};
        int W1 = 8;
        System.out.println(solveSnapSack(values1, weights1, W1));
    }

    private static int solveSnapSack(int[] values, int[] weights, int W) {
        int[][] dynamicMatrix = initializeMatrix(values, W);
        for (int i = 1; i < W + 1; i++) {
            for (int j = 1; j <= weights.length; j++) {
                dynamicMatrix[i][j] = dynamicMatrix[i][j - 1];
                if (i- weights[j-1] >= 0)
                    dynamicMatrix[i][j] = Math.max(dynamicMatrix[i - weights[j-1]][j - 1] + values[j-1], dynamicMatrix[i][j - 1]);
            }
        }
        return dynamicMatrix[W][values.length];
    }

    private static int[][] initializeMatrix(int[] values, int W) {
        int[][] dynamicMatrix = new int[W + 1][values.length+1];
        for (int i = 0; i < W + 1; i++) {
            dynamicMatrix[i] = new int[values.length+1];
        }
        return dynamicMatrix;
    }
}