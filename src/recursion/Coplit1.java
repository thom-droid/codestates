package recursion;

public class Coplit1 {

    public static void main(String[] args) {
        System.out.println(recursion(10));
    }
    private static int recursion(int num){

        if(num == 0){
            return 0;
        }

        return num + recursion(num - 1);
    }
}
