package arrays.hourglass;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Hourglass {

    // Complete the hourglassSum function below.
    static int hourglassSum(int[][] arr) {
    	
    	int max = Integer.MIN_VALUE;
    	
    	for(int x = 1; x < 5; ++x) {
    		for(int y = 1; y < 5; ++y) {
    			int sum = 0;
    			sum += arr[y][x];
    			sum += arr[y-1][x];
    			sum += arr[y-1][x-1];
    			sum += arr[y-1][x+1];
    			sum += arr[y+1][x];
    			sum += arr[y+1][x-1];
    			sum += arr[y+1][x+1];
    			if(sum > max) max = sum;
    		}
    	}
    	return max;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

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

        System.out.println(result);

        scanner.close();
    }
}
