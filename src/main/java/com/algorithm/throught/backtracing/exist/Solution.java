package com.algorithm.throught.backtracing.exist;

/**
 * @author dff on 2020-03-29
 */
public class Solution {
    public boolean exist(char[][] board, String word) {
        char[] chars = word.toCharArray();
        boolean result = false;
        boolean[][] viewed = new boolean[board.length][board[0].length];
        for (int i=0; i<board.length; i++) {
            for (int j=0; j<board[0].length; j++) {
                if (board[i][j] == chars[0]) {
                    result = recursion(board, chars, i, j, 0, viewed) || result;
                }
            }
        }
        return result;
    }
    private boolean recursion(char[][] board, char[] words, int row, int col, int index, boolean[][] viewed) {
        if (index == words.length) {
            return true;
        }
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length || viewed[row][col] || board[row][col] != words[index]) {
            return false;
        }
        viewed[row][col] = true;
        boolean down = recursion(board, words, row + 1, col, index + 1, viewed);
        boolean up = recursion(board, words, row - 1, col, index + 1, viewed);
        boolean left = recursion(board, words, row, col - 1, index + 1, viewed);
        boolean right = recursion(board, words, row, col + 1, index + 1, viewed);
        viewed[row][col] = false;
        return (down || up || left || right);
    }
}
