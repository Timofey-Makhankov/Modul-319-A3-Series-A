import java.io.*;
import java.util.Arrays;

// Main class
class StringSort {

    // Main driver method
    public static void main(String[] args)
    {   // Custom string input
        String str = "DieserStringwirdsortiert";
        // Converting string into an array for computation
        
        // Output sorted Array
        System.out.println(stringSort(str));
    }
    static char[] stringSort(String input){
        char arr[] = input.toCharArray(); // Convert to static array
        char temp;
        int i = 0;                      // Sort starts at the beginning
        while (i < arr.length) {        // outer loop i
            int j = i + 1;              // j is next character in row
            while (j < arr.length) {    // inner loop j till the end
                if (arr[j] < arr[i]) {  // Comparing the characters one by one
                    temp = arr[i];      // Swap characters if second is "smaller"
                    arr[i] = arr[j];    // this takes "smaller" char to front
                    arr[j] = temp;
                }
                j += 1;                 // get next character to compare
            }
            i += 1;                     // get next character to sort
        }
        return arr;
    }
}


