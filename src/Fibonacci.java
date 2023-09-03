import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Calculate and display the first 30 numbers of the Fibonacci sequence
        int[] fibonacciSequence = calculateFibonacci(30);
        System.out.println("First 30 numbers of the Fibonacci sequence:");

        for (int i = 0; i < fibonacciSequence.length; i++) {
            System.out.print(fibonacciSequence[i] + " ");
        }

        // Allow the user to choose an index number
        System.out.print("\nEnter an index number (1-30) to print from the Fibonacci sequence: ");
        int index = scanner.nextInt();
        if (index >= 1 && index <= 30) {
            int fibonacciNumber = fibonacciSequence[index - 1];
            System.out.println("Fibonacci number at index " + index + " is: " + fibonacciNumber);
        } else {
            System.out.println("Invalid index. Please enter a valid index (1-30).");
        }

        // Allow the user to print a range
        System.out.print("Enter a range (start-end) to print from the Fibonacci sequence (1-30): ");
        int start = scanner.nextInt();
        int end = scanner.nextInt();
        if (start >= 1 && end <= 30 && start <= end) {
            System.out.println("Fibonacci numbers in the range " + start + "-" + end + ":");
            for (int i = start - 1; i < end; i++) {
                System.out.print(fibonacciSequence[i] + " ");
            }
        } else {
            System.out.println("Invalid range. Please enter a valid range (1-30).");
        }

        scanner.close();
    }

    // Function to calculate the first n Fibonacci numbers
    public static int[] calculateFibonacci(int n) {
        int[] fibonacciSequence = new int[n];
        if (n >= 1) {
            fibonacciSequence[0] = 0;
        }
        if (n >= 2) {
            fibonacciSequence[1] = 1;
        }
        for (int i = 2; i < n; i++) {
            fibonacciSequence[i] = fibonacciSequence[i - 1] + fibonacciSequence[i - 2];
        }
        return fibonacciSequence;
    }
}
