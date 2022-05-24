package recursion;

public class Coplit5 {

    public int arrSum(int[] arr){
        int len = arr.length;
        if(len == 0){
            return 0;
        }

        return arrSum(arr);
        //TODO..
    }
}
