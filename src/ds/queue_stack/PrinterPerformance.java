package ds.queue_stack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.stream.Collectors;

public class PrinterPerformance {
    private static int queuePrinter(int bufferSize, int capacities, int[] documents) {

        // 처음 시작하는 노드는 bufferSize초 걸리고,
        // 연이어 통과하는 노드는 1초만큼 추가로 걸림.
        // 만약 노드가 통과가 안되고 새로운 묶음이 통과한다면, 처음 노드는 다시 bufferSize 만큼 걸림


        int time = bufferSize + 1; // 한 노드가 모두 통과하는 데에 buffersize + 1만큼 걸림
        int currentCapacity = capacities;
        ArrayDeque<Integer> deque = Arrays.stream(documents).boxed().collect(Collectors.toCollection(ArrayDeque::new));
        while (deque.size() > 0) {
            // 처음 값을 빼고 다음 값도 capa에 들어갈 수 있는지 확인
            // buffer size 만큼 시간이 지나면 맨 앞의 노드가 사라짐. capa가 늘어남.
            Integer node = deque.peek();
            if(currentCapacity > node){
                deque.poll();
                currentCapacity -= node;
                time++;
                continue;
            }

            currentCapacity = capacities;
            time += bufferSize;

        }

        return time;
    }


    // lets say we have buffersize the size of 2 with the capacity of 10, and documents are [5,4,2,3,4]
    // the first work for [5] will be done in 3 seconds from the insertion to being printed out.
    // and it will take one second more with the next document [4], 3 + 1 = four seconds altogether,
    // since there is enough space left for [4] after [5] is put onto the workbench.

    // no work can be loaded anymore since workbench is full, and capacity available is small (10 - 5 - 4 = 1)
    // so in this case next document have to wait until workbench is cleared, and it restores its capacity back


    private static int queuePrinter2(int bufferSize, int capacities, int[] documents) {

        // buffer 공간을 아예 queue로 만들자.
        int time = 0;
        int remainedCapacities = capacities;
        boolean isStreak = true;

        ArrayDeque<Integer> workbench = new ArrayDeque<>(bufferSize);
        LinkedList<Integer> documentQueue = Arrays.stream(documents).boxed().collect(Collectors.toCollection(LinkedList::new));

        // when document is empty
        if (documentQueue.isEmpty()) {
            return 0;
        }

        // iterate until documentQueue gets empty
        while (documentQueue.size() > 0) {
            int work = documentQueue.peek();

            // if remained capacity is not enough or workbench is fully loaded
            if (workbench.size() == bufferSize && !workbench.isEmpty()) {
                remainedCapacities += workbench.poll();
            }

            // check whether there is enough space left for the next node
            // and push the polled node to the workbench
            // when work is being processed, capacity must be subtracted
            // if there is enough capacity, it can make a streak, meaning that next insertion will only take 1 more second
            if (remainedCapacities >= work) {
                work = documentQueue.poll();
                workbench.add(work);
                remainedCapacities -= work;
                time++;
//                isStreak = true;
            } else {
                // if the next work needs the more capacities than left, then wait until the capacity has enough of it.
                // but what if the next work needs the whole space to process, so it has to wait until all the work in the bench is cleared?
                // we need to add only one buffer size time but in this code we add buffered size time every loop
                remainedCapacities += workbench.poll();
                isStreak = false;
                continue;
            }

            if (!isStreak) {
                time += bufferSize;
            }

            isStreak = true;


            // i think i need to change the way of aproaching to this problem from the scratch .
            // not adding the time at the end, but adding and subtracting the time when
            // work is added and removed from the workbench..
        }


        return time;
    }

    private static int queuePrinter3(int bufferSize, int capacities, int[] documents) {

        int time = 0;
        int remainedCapacities = capacities;

        ArrayDeque<Integer> workbench = new ArrayDeque<>(bufferSize);
        LinkedList<Integer> documentQueue = Arrays.stream(documents).boxed().collect(Collectors.toCollection(LinkedList::new));

        while (documentQueue.size() > 0) {
            int work = documentQueue.peek();

            // work is smaller than current capa
            if (work <= remainedCapacities) {

                work = documentQueue.poll();

                if (workbench.size() != bufferSize) {
                    workbench.add(work);
                    remainedCapacities -= work;
                    time++;
                } else {
                    remainedCapacities += workbench.poll();
                    time++;
                }

            } else {
                remainedCapacities += workbench.poll();
                time++;
            }

            // otherwise

        }


    }
    public static void main(String[] args) {

        System.out.println(queuePrinter2(2, 12, new int[]{5,6,1,12,8,9,11}));
        System.out.println(queuePrinter2(2, 10, new int[]{7, 4, 5, 6}));
    }
}

