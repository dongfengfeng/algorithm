package com.algorithm.throught.backtracing.eightqueens;

/**
 * @author dongfengfeng on 2020-02-16
 */
public class EightQueen {
    private static final int QUEENS = 8;

    private int[] result = new int[QUEENS];

    public void call8Queens(int row) {
        if (row == QUEENS) {
            return;
        }
        for (int column=0; column<QUEENS; column++) {
            if (isOk(row, column)) {
                result[row] = column;
                call8Queens(row + 1);
            }
        }
    }

    private boolean isOk(int row, int column) {
        int left = column - 1;
        int right = column + 1;
        for (int i=row - 1; i>=0; i--) {
            if (result[i] == column) {
                return false;
            }
            if (left >=0 && result[i] == left) {
                return false;
            }
            if (right <QUEENS && result[i] == right) {
                return false;
            }
            left--;
            right++;
        }
        return true;
    }
}
