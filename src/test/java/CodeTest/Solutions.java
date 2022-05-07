package CodeTest;

import java.util.List;

public class Solutions {

    public static void main(String[] args) {


        Methods object = new Methods();

        // {"happY", "king", "peace", "living standard"} , {"king kong", "Happy", "PEACE"}
        String[] one = {"happY", "king", "peace", "living standard"};
        String[] two = {"king kong", "Happy", "PEACE"};
        List results = object.findCommonStrings(one,two);
        System.out.println(results);


        int result2 = object.factorial(5);
        System.out.println(result2);


        // Q4
        int[] intArr = {3, 5, 1, 4, 2};
        int result3 = object.returnMissingNum(intArr);
        System.out.println(result3);



    }
}
