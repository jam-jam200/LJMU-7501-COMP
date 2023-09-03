import java.util.Scanner;

public class BubbleSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //get the user's input for the number of strings to be sorted
        System.out.print("Enter the number of strings to be sorted: ");
        int numStrings = scanner.nextInt();
        scanner.nextLine();

        // Create an array to store the strings
        String[] strings = new String[numStrings];

        // Get user input for the strings
        for (int i = 0; i < numStrings; i++) {
            System.out.print("Enter string #" + (i + 1) + ": ");
            strings[i] = scanner.nextLine();
        }

        // Get user choice for sorting order
        System.out.println("Choose sorting order:");
        System.out.println("1. Alphanumeric Order");
        System.out.println("2. Reverse Alphanumeric Order");
        System.out.print("Enter your choice: ");
        int sortOption = scanner.nextInt();

        // Sort the strings using Bubble Sort
        if (sortOption == 1) {
            bubbleSort(strings, false); // Sort in alphanumeric order
        } else if (sortOption == 2) {
            bubbleSort(strings, true); // Sort in reverse alphanumeric order
        } else {
            System.out.println("Invalid choice. Sorting in alphanumeric order by default.");
            bubbleSort(strings, false); // Default to alphanumeric order
        }

        // Display the sorted strings
        System.out.println("\nSorted Strings:");
        for (String str : strings) {
            System.out.println(str);
        }
        //closing the scanner to release resources associated with standard input (System.in)
        scanner.close();
    }

    // Bubble Sort
    public static void bubbleSort(String[] arr, boolean reverse) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (compareStrings(arr[j], arr[j + 1], reverse) > 0) {
                    // Swap arr[j] and arr[j+1]
                    String temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    // Helper function to compare strings based on sorting order
    public static int compareStrings(String str1, String str2, boolean reverse) {
        if (reverse) {
            // Compare in reverse order (reverse alphanumeric)
            return str2.compareTo(str1);
        } else {
            // Compare in normal order (alphanumeric)
            return str1.compareTo(str2);
        }
    }
}
