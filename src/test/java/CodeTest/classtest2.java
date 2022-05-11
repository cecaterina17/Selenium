package CodeTest;

import Helper.Misc;
import Web.MyDriver;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class classtest2 {

    /**
     * Ques-2:
     * Verify feelsLike-temp value is in between the low-temp value and high-temp value
     * Web: https://www.darksky.net/
     * points: 20
     */

    @Test
    public void seleniumQuestion() {
        MyDriver.launchUrlOnNewWindow("https://darksky.net/");

        String feelTemp = MyDriver.getDriver().findElement(By.xpath("//*[@class='feels-like-text']")).getText();
        String lowTemp = MyDriver.getDriver().findElement(By.xpath("//*[@class='low-temp-text']")).getText();
        String highTemp = MyDriver.getDriver().findElement(By.xpath("//*[@class='high-temp-text']")).getText();


        int newFeelsTemp = Integer.valueOf(feelTemp.split("˚")[0]);
        int newLowTemp = Integer.valueOf(lowTemp.split("˚")[0]);
        int newHighTemp = Integer.valueOf(highTemp.split("˚")[0]);

        Assert.assertTrue(newFeelsTemp > newLowTemp && newFeelsTemp < newHighTemp);

        Misc.pause(1);
        MyDriver.quitWindows();
    }


    /**
     * Ques-1:
     * Create a method to return factorial value of input-int-value
     * points: 10
     */


    /*
     *
     * eg:
     * input -> 5
     * returned value -> (5*4*3*2*1) = 120
     *
     * input -> 1
     * returned value -> (1) = 1
     *
     * input -> 3
     * returned value -> (3*2*1) = 6
     *
     * input -> 10
     * returned value -> (10*9*8*7*6*5*4*3*2*1) =
     */
    public static void main(String[] args) {
        int i, fact = 1;
        int number = 5;//It is the number to calculate factorial
        for (i = 1; i <= number; i++) {
            fact = fact * i;
        }
        System.out.println("Factorial of " + number + " is: " + fact);
    }


    /**
     * Ques-3:
     * Create a method to return the common Strings values in two input-String-arrays
     * points: 30
     * Note: two input-String-arrays can be of same size or different size
     */
    /*
     *
     * eg:
     * input -> {"happY", "king", "peace", "living standard"} , {"king kong", "Happy", "PEACE"}
     * returned value -> [happy, peace]
     *
     * input -> {“ab”, “abcd”, “abc”, “abcde”, “defg”, "koli”} , {“abcde”, “jhuy”, “plot”, “koli”}
     * returned value -> [abcde, koli]
     *
     */



    /**
     * Ques-4:
     * Create a method to return missing smallest positive integer (greater than 0) from given int-array.
     * points: 40
     */
    /*
     *
     * eg:
     * 	input -> : {3, 5, 1, 4, 2, 7}
     * 	returned value : 6
     *
     * 	input -> : {3, 5, 1, 4, 2}
     * 	returned value : 6
     *
     * 	input -> {2, 5, -1, 0, 6}
     * 	returned value : 1
     *
     * 	input -> {0, 5, -1, 1, 2, 5, 3, 7, 1, 2}
     * 	returned value : 4
     *
     * 	input -> {-2, -5, -1, -10, -6}
     * 	returned value : 1
     *
     */
    public static int returnMissingNum(int[] arr1) {
        int result = 0;
        for (int i = 0; i < arr1.length - 1; i++) {
            if (arr1[i] > arr1[i + 1]) {
                int temp = arr1[i];
                arr1[i] = arr1[i + 1];
                arr1[i + 1] = temp;
                i = -1;
            }
        }

        boolean isOnePresent = false;
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] == 1) {
                isOnePresent = true;
            }
        }

        if (!isOnePresent) {
            result = 1;
        } else {

            int countOverOne = 0;
            for (int i = 0; i < arr1.length; i++) {
                if (arr1[i] >= 1) {
                    countOverOne++;
                }
            }

            int[] newArr = new int[countOverOne];
            int indexCounter = 0;
            for (int i = 0; i < arr1.length; i++) {
                if (arr1[i] >= 1) {
                    newArr[indexCounter] = arr1[i];
                    indexCounter++;
                }
            }


            for (int i = 0; i < newArr.length; i++) {
                if (newArr[i] == newArr[newArr.length - 1]) {
                    int missingNumber = newArr[newArr.length - 1] + 1;
                    result = missingNumber;
                    break;
                }
                if (countOverOne != 0 && (newArr[i + 1] > (newArr[i] + 1))) {
                    int missingNumber = newArr[i] + 1;
                    result = missingNumber;
                    break;
                }
            }
        }
        return result;

    }
}


