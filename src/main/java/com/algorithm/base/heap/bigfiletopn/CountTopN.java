package com.algorithm.base.heap.bigfiletopn;

import com.algorithm.base.heap.bigfiletopn.pojo.KeyBusi;

import java.util.*;

/**
 * @author dongfengfeng on 2020-02-11
 */
public class CountTopN {
    public static final CountTopN INSTANCE = new CountTopN();

    private static final Map<String, Integer> countMap = new HashMap<>(10240);

    private Comparator<KeyBusi> comparator = (o1, o2) -> {
        if (o1.getCount() > o2.getCount()) {
            return 1;
        } else if (o1.getCount() < o2.getCount()) {
            return -1;
        } else {
            return 0;
        }
    };

    public void clearData() {
        countMap.clear();
    }

    public void putData(String data) {
        Integer count = countMap.get(data);
        if (count == null) {
            count = 0;
        }
        count++;
        countMap.put(data, count);
    }

    public KeyBusi[] getTopN(int numk) {
        PriorityQueue<KeyBusi> queue = new PriorityQueue<>(numk, comparator);

        Iterator<Map.Entry<String, Integer>> iterator = countMap.entrySet().iterator();
        Map.Entry<String, Integer> entry;
        while (iterator.hasNext()) {
            entry = iterator.next();
            if (queue.size() < numk) {
                queue.offer(new KeyBusi(entry.getKey(), entry.getValue()));
            } else {
                if (queue.peek().getCount() < entry.getValue()) {
                    queue.poll();
                    queue.offer(new KeyBusi(entry.getKey(), entry.getValue()));
                }
            }
        }
        KeyBusi[] result = new KeyBusi[numk];
        queue.toArray(result);
        return result;
    }

    public KeyBusi[] getTopN(List<KeyBusi[]> list, int numk) {
        PriorityQueue<KeyBusi> queue = new PriorityQueue<>(numk, comparator);
        for (KeyBusi[] keyBusis : list) {
            for (KeyBusi keyBusi : keyBusis) {
                if (keyBusi == null) {
                    break;
                }
                if (queue.size() < numk) {
                    queue.offer(keyBusi);
                } else {
                    if (queue.peek().getCount() < keyBusi.getCount()) {
                        queue.poll();
                        queue.offer(keyBusi);
                    }
                }
            }
        }
        KeyBusi[] result = new KeyBusi[numk];
        queue.toArray(result);
        return result;
    }
}
