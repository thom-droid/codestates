package array;

import java.util.Arrays;

public class Array1 {

    private static int[][] variableArray = new int[5][];
    private static final String INVALID_SCORE = "INVALID SCORE";

    public static void main(String[] args) {
        System.out.println(computeSumOfAllElements(new int[]{1,2,3}));
    }

    private static Integer[] getSizeOfArray() {
        Integer[] sizeArray = new Integer[5];
        variableArray[0] = new int[5];
        variableArray[1] = new int[3];
        variableArray[2] = new int[4];
        variableArray[3] = new int[1];
        variableArray[4] = new int[1];


        for (int i = 0; i < variableArray.length; i++) {
            sizeArray[i] = variableArray[i].length;
        }
        String str =" A";
        StringBuilder sb = new StringBuilder(str);
        sb.append("C");
        System.out.println(sb);

        return sizeArray;
    }

    public static String convertScoreToGradeWithPlusAndMinus(int score) {
        String grade ="";

        if(score > 100 || score < 0){
            return INVALID_SCORE;
        }

        if(score >= 90){
            grade = "A";
        } else if (score >= 80){
            grade ="B";
        } else if (score >= 70){
            grade = "C";
        } else if(score >=60){
            grade = "D";
        }

        if(score < 60){
            return "F";
        }

        StringBuilder sb = new StringBuilder(grade);
        int detail = score % 10;

        if(detail < 3){
            sb.append("-");
        }

        if(detail >= 8){
            sb.append("+");
        }

        return sb.toString();
    }

    public static int computeSumOfAllElements(int[] arr) {
        // TODO:
        int a = 0;

        for(int i = 0; i < arr.length; i++){
            a += arr[i];
        }
        String sstr = "";

        return a;
    }
}
