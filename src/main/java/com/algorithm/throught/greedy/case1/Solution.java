package com.algorithm.throught.greedy.case1;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author dongfengfeng on 2020-02-15
 */
public class Solution {

    private PriorityQueue<Goods> queue = new PriorityQueue<>((o1, o2) -> {
        if (o1.getPrice() < o2.getPrice()) {
            return 1;
        } else if(o1.getPrice() > o2.getPrice()) {
            return -1;
        } else {
            return 0;
        }
    });

    public void addGoods(Goods goods) {
        queue.offer(goods);
    }

    public List<Goods> handle(int packageCapacity) {
        List<Goods> goodsPackage = new ArrayList<>();

        int remain = packageCapacity;

        while (!queue.isEmpty()) {
            Goods expensiveGoods = queue.poll();
            if (expensiveGoods.getWeight() <= remain) {
                remain = remain - expensiveGoods.getWeight();
                goodsPackage.add(expensiveGoods);
            } else {
                int surplusWeight = expensiveGoods.getWeight() - remain;
                expensiveGoods.setWeight(surplusWeight);
                expensiveGoods.setValue(surplusWeight * expensiveGoods.getPrice());
                queue.offer(expensiveGoods);
                goodsPackage.add(new Goods(expensiveGoods.getName(), remain, expensiveGoods.getPrice() * remain));
                remain = 0;
                break;
            }
        }
        return goodsPackage;
    }
}
