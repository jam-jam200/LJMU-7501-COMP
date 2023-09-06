import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //calculate and display the first 30 numbers of the Fibonacci sequence
        int[] fibSequence = calculateFib(30);
        System.out.println("First 30 numbers of the Fibonacci sequence: ");

        //printing the first 30 numbers of the Fibonacci sequence
        for (int j : fibSequence) {
            System.out.print(j + " ");
        }
        //allowing the user to choose an index number
        System.out.print("\nEnter an index number (1-30) to print from the Fibonacci sequence: ");
        int index = scanner.nextInt();
        //check if the user's input index is within the valid range of 1-30
        if (index >= 1 && index <= 30) {
            //calculating the Fibonacci number at the specified index
            int fibNumber = fibSequence[index - 1];
            //display the calculated Fibonacci number and its index
            System.out.println("Fibonacci number at index " + index + " is: " + fibNumber);
        } else {
            //in case the entered index is invalid print out error message
            System.out.println("Invalid index. Please enter a valid index (1-30).");
        }

        //allowing the user to print a range
        System.out.print("Enter a range (start and end) to print from the Fibonacci sequence (1-30): ");
        int start = scanner.nextInt();
        int end = scanner.nextInt();
        //check if the user's input range is within the valid range of 1-30
        if (start >= 1 && end <= 30 && start <= end) {
            //display a message indicating the range being printed
            System.out.println("Fibonacci numbers in the range " + start + "-" + end + ":");

            //iterate through and print Fibonacci numbers within the specified range
            for (int i = start - 1; i < end; i++) {
                System.out.print(fibSequence[i] + " ");
            }
        } else {
            //in case the entered range is invalid print out error message
            System.out.println("Invalid range. Please enter a valid range (1-30).");
        }

        //closing the scanner to release resources associated with standard input (System.in)
        scanner.close();
    }

    /**
     * Calculates the first 'n' Fibonacci numbers and returns them in an array.
     *
     * @param n The number of Fibonacci numbers to calculate.
     * @return An array containing the first 'n' Fibonacci numbers.
     */
    public static int[] calculateFib(int n) {
        int[] fibonacciSequence = new int[n];

        //initializing the first two Fibonacci numbers
        if (n >= 1) {
            fibonacciSequence[0] = 0;
        }
        if (n >= 2) {
            fibonacciSequence[1] = 1;
        }

        //calculating the remaining Fibonacci numbers using a loop
        for (int i = 2; i < n; i++) {
            fibonacciSequence[i] = fibonacciSequence[i - 1] + fibonacciSequence[i - 2];
        }

        return fibonacciSequence;
    }
}
