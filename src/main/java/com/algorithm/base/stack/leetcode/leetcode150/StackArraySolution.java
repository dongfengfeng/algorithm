package com.algorithm.base.stack.leetcode.leetcode150;

/**
 * 高手的解法，通过声明一个数组，来实现栈的功能
 *
 * @author liujun
 * @version 0.0.1
 * @date 2019/08/15
 */
public class StackArraySolution {

  /**
   * 进行逆波兰式的求解
   *
   * @param operations
   * @return
   */
  public int evalRPN(String[] operations) {

    int[] value = new int[operations.length];

    int currIndex = -1;

    int tmpval1;
    int tmpVal2;

    for (int i = 0; i < operations.length; i++) {
      switch (operations[i]) {
        case "+":
          tmpval1 = value[currIndex - 1];
          tmpVal2 = value[currIndex];
          value[currIndex - 1] = tmpval1 + tmpVal2;
          currIndex--;
          break;
        case "-":
          tmpval1 = value[currIndex - 1];
          tmpVal2 = value[currIndex];
          value[currIndex - 1] = tmpval1 - tmpVal2;
          currIndex--;
          break;
        case "*":
          tmpval1 = value[currIndex - 1];
          tmpVal2 = value[currIndex];
          value[currIndex - 1] = tmpval1 * tmpVal2;
          currIndex--;
          break;
        case "/":
          tmpval1 = value[currIndex - 1];
          tmpVal2 = value[currIndex];
          value[currIndex - 1] = tmpval1 / tmpVal2;
          currIndex--;
          break;
        default:
          value[++currIndex] = Integer.parseInt(operations[i]);
          break;
      }
    }

    return value[0];
  }
}
