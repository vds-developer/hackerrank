import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class HourglassSum {

    // Complete the hourglassSum function below.
    static int hourglassSum(int[][] arr) {
        int i = arr.length;
        int j = arr[0].length;
        List<Integer> hourglassSums = new LinkedList<Integer>();

        for (int row = 0; row < i - 2; row++ ) {
            for (int col = 0; col < j - 2; col++ ) {
                int sum = 0;
                sum += arr[row][col] + arr[row][col+1] + arr[row][col+2] + arr[row+1][col + 1] + arr[row + 2][col] + arr[row + 2][col+1] + arr[row + 2][col+2];
                hourglassSums.add(sum);
            }
        }

        return Collections.max(hourglassSums);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int[][] arr = new int[6][6];

        for (int i = 0; i < 6; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }

        int result = hourglassSum(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
