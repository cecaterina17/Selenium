package CodeTest;

import java.util.ArrayList;
import java.util.List;

public class Methods {

    public List<String> findCommonStrings(String[] arrOne, String[] arrTwo) {
        List<String> commonStrings = new ArrayList<>();
        for (int i = 0; i < arrOne.length; i++) {
            for (int j = 0; j < arrTwo.length; j++) {
                if (arrOne[i].equalsIgnoreCase(arrTwo[j])) {
                    commonStrings.add(arrOne[i].toLowerCase());
                }
            }
        }
        return commonStrings;
    }

    public int factorial(int input) {
        int i, fact = 1;
        //int number = 5;//It is the number to calculate factorial
        for (i = 1; i <= input; i++) {
            fact = fact * i;
        }
        //System.out.println("Factorial of " + number + " is: " + fact);
        return fact;
    }

    public int returnMissingNum(int[] arr1){
        int result = 0;
        for (int i = 0; i < arr1.length-1; i++) {
            if (arr1[i] > arr1[i+1]){
                int temp = arr1[i];
                arr1[i] = arr1[i+1];
                arr1[i+1] = temp;
                i = -1;
            }
        }

        boolean isOnePresent = false;
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] == 1){
                isOnePresent = true;
            }
        }

        if (!isOnePresent){
            result = 1;
        }
        else {

            int countOverOne = 0;
            for (int i = 0; i < arr1.length; i++) {
                if (arr1[i] >= 1){
                    countOverOne++;
                }
            }

            int[] newArr = new int[countOverOne];
            int indexCounter = 0;
            for (int i = 0; i < arr1.length; i++) {
                if (arr1[i] >= 1){
                    newArr[indexCounter] = arr1[i];
                    indexCounter++;
                }
            }


            for (int i = 0; i < newArr.length; i++) {
                if (newArr[i] == newArr[newArr.length - 1]) {
                    int missingNumber = newArr[newArr.length-1] + 1;
                    result = missingNumber;
                    break;
                }
                if (countOverOne != 0 && (newArr[i+1] > (newArr[i]+1))){
                    int missingNumber = newArr[i]+1;
                    result = missingNumber;
                    break;
                }
            }
        }
        return result;
    }


}
