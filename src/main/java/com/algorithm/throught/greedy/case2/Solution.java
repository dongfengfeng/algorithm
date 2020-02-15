package com.algorithm.throught.greedy.case2;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author dongfengfeng on 2020-02-15
 */
public class Solution {

    private PriorityQueue<Sweet> sweetQueue = new PriorityQueue<>((o1, o2) -> {
        if (o1.getSize() > o2.getSize()) {
            return 1;
        } else if (o1.getSize() < o2.getSize()) {
            return -1;
        } else {
            return 0;
        }
    });

    private PriorityQueue<Child> childQueue = new PriorityQueue<>((o1, o2) -> {
        if (o1.getExpect() > o2.getExpect()) {
            return 1;
        } else if (o1.getExpect() < o2.getExpect()) {
            return -1;
        } else {
            return 0;
        }
    });

    public void addSweet(Sweet sweet) {
        sweetQueue.offer(sweet);
    }

    public void addChild(Child child) {
        childQueue.offer(child);
    }

    public List<Child> alloc() {
        List<Child> satisfiedChild = new ArrayList<>();

        while (!childQueue.isEmpty()) {
            Child child = childQueue.poll();
            while (!sweetQueue.isEmpty()) {
                Sweet sweet = sweetQueue.poll();
                if (child.getExpect() <= sweet.getSize()) {
                    child.setSweet(sweet);
                    satisfiedChild.add(child);
                    break;
                }
            }
            if (sweetQueue.isEmpty()) {
                break;
            }
        }
        return satisfiedChild;
    }
}
