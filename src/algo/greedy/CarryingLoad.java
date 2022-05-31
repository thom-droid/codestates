package algo.greedy;

import java.util.Arrays;

public class CarryingLoad {

    public static int movingStuff(int[] stuff, int limit) {
        // 다른 가중치에 대한 조건이 없으므로 무게만 고려하면 됨
        // variable to store the counted values
        int count = 0;

        // array should be sorted as we need to figure the minimum counts
        // can manually sort, but use api here
        Arrays.sort(stuff);
        boolean[] isPickedUp = new boolean[stuff.length];


        for (int i = 0; i < stuff.length; i++) {

            // 60, 73, 80, 87, 103, 109, 119, 123, 128, 129, 136, 146, 153, 168, 182
            // pick the element and then make combination that is lighter than the limit
            // find the biggest combination among them
            // to achieve that loop in reversed manner
            // this backward loop must stop before i
            for (int j = stuff.length - 1; j > i; j--) {

                int sum = stuff[i] + stuff[j];

                //if j is not picked up, pick this and turn true so next element will ignore it
                if(!isPickedUp[i] && !isPickedUp[j]){
                    if (sum <= limit) {
                        isPickedUp[i] = true;
                        isPickedUp[j] = true;
                        count++;
                        break;
                    }
                }

            }

            // if the case passed through the backward loop above, it means there is no pair
            // stuff[i] alone fits to the box, so increment count by 1
            if (!isPickedUp[i]) {
                isPickedUp[i] = true;
                count++;
            }

        }


        return count;

    }

    public static void main(String[] args) {
//        System.out.println(movingStuff(new int[]{70, 50, 80, 50}, 100));
//        System.out.println(movingStuff(new int[]{60, 80, 120, 90, 130}, 140));
        System.out.println(movingStuff(new int[]{60, 73, 80, 87, 103, 109, 119, 123, 128, 129, 136, 146, 153, 168, 182}, 200));
    }

    // counter example
    // in array {60, 73, 80, 87, 103, 109, 119, 123, 128, 129, 136, 146, 153, 168, 182} with limit 200
    // not that to find any combination lighter than the limit,
    // we need to find combination that is the biggest in that case but lighter than the limit
}
