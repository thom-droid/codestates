package ds;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class BoxWrapping {

    private static int countHowManyCanPassAtATime(Integer[] boxes) {
        if (boxes.length <= 1) {
            return boxes.length;
        }

        LinkedList<Integer> listQueue = Arrays.stream(boxes).collect(Collectors.toCollection(LinkedList::new));

        // 한 번에 나갈 수 있는 최대 인원을 구해야 한다.
        // 10명이 있을 때, 2명, 3명, 5명이 묶음으로 나갔다면, 5명이 리턴되야 한다.
        int count = 1;
        Integer firstNode = listQueue.poll();
        int size = listQueue.size();
        TreeSet<Integer> treeSet = new TreeSet<>();
        while (size-- > 0) {

            Integer toCompare = listQueue.peek();

            if (firstNode.compareTo(toCompare) >= 0) {
                listQueue.poll();
                count++;
                if (listQueue.size() == 0) {
                    treeSet.add(count);
                    break;
                }
                continue;
            }

            treeSet.add(count);

            count = 1;
            firstNode = listQueue.poll();

        }

        return treeSet.last();

    }

    public static void main(String[] args) {
//        System.out.println(countHowManyCanPassAtATime(new Integer[]{5, 1, 4, 6, 2,3,2,3,2,5, 9,1,2,3,1,2,3,1,2,3,1,2,3,12,3,1,23,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2}));
//        System.out.println(countHowManyCanPassAtATime(new Integer[]{1, 5, 7, 9}));
        System.out.println(countHowManyCanPassAtATime(new Integer[]{1}));


    }
}
