package com.algorithm.base.array.setZeroes;

/**
 * @author dff on 2020-03-23
 */
public class Solution {
    public void setZeroes(int[][] matrix) {

        boolean  firstRow = false;
        boolean firstCol = false;
        for (int i=0; i<matrix.length; i++) {
            for (int j=0; j<matrix[0].length; j++) {
                if (i !=0 && j !=0 && matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                } else if (matrix[i][j] == 0){
                    if (i == 0) {
                        firstRow = true;
                    }
                    if (j == 0){
                        firstCol = true;
                    }
                }
            }
        }
        //i和j都从1开始，这里很关键，否则如果[0,0]为0则整个矩阵被刷为0
        for (int i=1; i<matrix.length; i++) {
            for (int j=1; j < matrix[0].length; j++) {
                if (matrix[0][j] == 0 || matrix[i][0] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        if (firstRow) {
            for (int i=0; i<matrix[0].length; i++) {
                matrix[0][i] = 0;
            }
        }
        if (firstCol) {
            for (int j=0; j<matrix.length; j++) {
                matrix[j][0] = 0;
            }
        }
    }
}
