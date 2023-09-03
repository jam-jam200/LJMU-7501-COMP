import java.util.Scanner;

public class BubbleSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //get the user's input for the number of strings to be sorted
        System.out.print("Enter the number of strings to be sorted: ");
        int alphanum = scanner.nextInt();
        scanner.nextLine();

        //an array to store the strings
        String[] strings = new String[alphanum];

        //loop to get user input for strings
        for (int i = 0; i < alphanum; i++) {
            //prompting the user to enter a string with the current index
            System.out.print("Enter string: " + (i + 1) + ": ");
            strings[i] = scanner.nextLine();
        }

        //get user choice for sorting order
        System.out.println("Choose sorting order:");
        System.out.println("1. Alphanumeric Order");
        System.out.println("2. Reverse Alphanumeric Order");
        System.out.print("Enter your choice: ");
        int sortOption = scanner.nextInt();

        //sorting the strings using Bubble Sort
        if (sortOption == 1) {
            bubbleSort(strings, false); //sorts in alphanumeric order
        } else if (sortOption == 2) {
            bubbleSort(strings, true); //sorts in reverse alphanumeric order
        } else {
            //in case the entered choice is invalid print out error message
            System.out.println("Invalid choice. Sorting in alphanumeric order by default.");
            bubbleSort(strings, false); //default to alphanumeric order
        }

        //displaying the sorted strings
        System.out.println("\nSorted Strings:");
        for (String str : strings) {
            System.out.println(str);
        }
        //closing the scanner to release resources associated with standard input (System.in)
        scanner.close();
    }

    /**
     * Sorts an array of strings using the Bubble Sort algorithm.
     *
     * @param arr The array of strings to be sorted.
     * @param reverse If true, sorts the array in reverse alphanumeric order, otherwise, in alphanumeric order.
     */
    public static void bubbleSort(String[] arr, boolean reverse) {
        int n = arr.length;
        //outer loop for passes
        for (int i = 0; i < n - 1; i++) {
            //inner loop for comparisons and swaps
            for (int j = 0; j < n - i - 1; j++) {
                //comparing adjacent strings based on sorting order
                if (compareStrings(arr[j], arr[j + 1], reverse) > 0) {
                    //swap arr[j] and arr[j+1]
                    String temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    //function to compare strings based on sorting order
    public static int compareStrings(String str1, String str2, boolean reverse) {
        if (reverse) {
            //compare in reverse order (reverse alphanumeric)
            return str2.compareTo(str1);
        } else {
            //compare in normal order (alphanumeric)
            return str1.compareTo(str2);
        }
    }
}
