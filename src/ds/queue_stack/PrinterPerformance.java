package ds.queue_stack;

import java.util.ArrayDeque;
import java.util.Arrays;
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

    private static int queuePrinter2(int bufferSize, int capacities, int[] documents) {
        // buffer 공간을 아예 queue로 만들자.
        int time = bufferSize;
        ArrayDeque<Integer> deque = new ArrayDeque<>(bufferSize);
        int remainedCapacities = capacities;
        // 넣고 사이즈가 꽉 찼거나 capa가 딸리면 큐에서 top을 제거
        for (int i = 0; i < documents.length; i++) {
            int node = documents[i];

            // 큐가 꽉 찼을 때
            // 큐에서 제거하고 capa를 회복
            if (deque.size() == bufferSize) {
                remainedCapacities += deque.poll();
            }

            if (remainedCapacities > node) {
                deque.add(node);
                remainedCapacities -= node;
            }

            // 남은 capa보다 노드가 크다면 capa가 돌아올 때가지 기다려야 함
            


            time++;
        }
        return time;
    }

    public static void main(String[] args) {

        System.out.println(queuePrinter2(2, 10, new int[]{5, 5, 5, 5, 5}));
    }
}

