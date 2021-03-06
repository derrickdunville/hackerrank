package arrays.arraymanipulationtwo;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class ArrayManipulationTwo {

    static long arrayManipulation(int n, int[][] queries) {
    	long[] arr = new long[n+2];    	
    	long max = 0;
    	for(int i = 0; i < queries.length; ++i) {
			arr[queries[i][0]] += queries[i][2];
			arr[queries[i][1]+1] -= queries[i][2];			
    	}
    	
    	for(int j = 0; j < n+1; ++j) {
    		arr[j+1] += arr[j];
    		if(arr[j+1] > max) max = arr[j+1];
    	}
    	return max;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        String[] nm = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nm[0]);

        int m = Integer.parseInt(nm[1]);

        int[][] queries = new int[m][3];

        for (int i = 0; i < m; i++) {
            String[] queriesRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 3; j++) {
                int queriesItem = Integer.parseInt(queriesRowItems[j]);
                queries[i][j] = queriesItem;
            }
        }

        long result = arrayManipulation(n, queries);
        
        System.out.println(result);

        scanner.close();
    }
}
