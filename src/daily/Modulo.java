package daily;

public class Modulo {
    public static Integer modulo(int num1, int num2) {

        if(num1 == 0){
            return 0;
        }

        if (num2 == 0) {
            return null;
        }

        while (num1 >= num2) {
            num1 -= num2;
        }

        return num1;
    }

    public static void main(String[] args) {
        System.out.println(modulo(23, 6));
    }
}
