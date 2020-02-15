package com.algorithm.throught.greedy.case3;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author dongfengfeng on 2020-02-15
 */
public class Solution {

    private PriorityQueue<Money> moneyQueue = new PriorityQueue<>((o1, o2) -> {
        if (o1.getDenomination() < o2.getDenomination()) {
            return 1;
        } else if (o1.getDenomination() > o2.getDenomination()) {
            return -1;
        } else {
            return 0;
        }
    });

    private void addMoney(Money money) {
        moneyQueue.offer(money);
    }

    public List<Money> pay(int account) {
        List<Money> resultList = new ArrayList<>();

        List<Money> tmpList = new ArrayList<>();

        int surplus = account;

        while (surplus > 0) {
            Money money = moneyQueue.poll();
            if (money.getDenomination() < surplus) {
                surplus = surplus - money.getDenomination();
                resultList.add(new Money(money.getDenomination(), 1));
                money.setNum(money.getNum() - 1);
                if (money.getNum() > 0) {
                    moneyQueue.offer(money);
                }
            } else {
                tmpList.add(money);
            }
        }
        moneyQueue.addAll(tmpList);
        return resultList;
    }
}
