import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        double inputValue = 100;
        double [] basketArray = {0,0,0,0,0,0,0};
        int [][] pattern ={
                {0,0,0,0,0,0,0},
                {1,0,0,0,0,0,0},
                {0,0,1,1,1,0,0},
                {0,0,0,0,0,0,0},
                {1,1,1,0,0,1,0},
                {0,0,0,0,0,0,1},
                {0,0,0,0,0,0,0}
                };

        System.out.println("Enter the position:" );
        Scanner sc = new Scanner(System.in);
        int index = sc.nextInt() - 1;
        basketArray[index] = inputValue;

        double [] currCalculated;

        for (int i = 0; i < pattern.length; i++) {
            int [] currentRow = pattern[i];
            double [] splittedValues;

            currCalculated = Arrays.copyOf(basketArray, basketArray.length);

            for (int j = 0; j < currentRow.length; j++) {
                if (currentRow[j] == 1 && basketArray[j] > 0){
                    splittedValues = valueSplitter(currentRow.length, basketArray[j], currentRow[j], j);

                    // check left
                    if (splittedValues[0] > 0){
                        currCalculated[j - 1] = currCalculated[j - 1] + splittedValues[0];
                    }

                    // check right
                    if (splittedValues[1] > 0){
                        currCalculated[j + 1] = currCalculated[j + 1] + splittedValues[1];
                    }
                    currCalculated[j] = 0;
                }
            }
            // update basket array
            basketArray = currCalculated;
        }

        // print
        System.out.println("\n Result: \n");
        for (double bItem: basketArray ) {
            System.out.println(bItem);
        }
    }

    public static double[] valueSplitter(int colCount,double inputValue, int ringValue, int ringColIndex){
        double [] splittedValues = {0,0};
        if (ringValue == 1){
            // split now
            if(ringColIndex == 0){
                splittedValues[1]  = inputValue / 2;
            }
            else if (ringColIndex == colCount - 1){
                splittedValues[0]  = inputValue / 2;
            }else{
                splittedValues[0] = inputValue / 2;
                splittedValues[1] = inputValue / 2;
            }
        }
        return splittedValues;
    }
}