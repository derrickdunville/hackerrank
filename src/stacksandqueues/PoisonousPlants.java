package stacksandqueues;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;


public class PoisonousPlants {

    static int poisonousPlants(int[] p) {
    	
    	ArrayList<LinkedList<Integer>> queues = new ArrayList<LinkedList<Integer>>();
    	queues.add(new LinkedList<Integer>());
		
		int currentQ = 0;
    	for(int i = 0; i < p.length; ++i) {
    		if(queues.get(currentQ).isEmpty() || queues.get(currentQ).peekLast() >= p[i]) { 
    			queues.get(currentQ).add(p[i]); 
    		} else {
    			queues.add(new LinkedList<Integer>());
    			currentQ++;
    			queues.get(currentQ).add(p[i]);
    		}
    	}
    	
    	
    	int days = 0;
    	while(queues.size() > 1) {
    		// pollFist on all except first
//    		System.out.println("Day: " + days);
//        	for(int i = 0; i < queues.size(); ++ i) {
//        		System.out.println("Queue: " + i + " " + queues.get(i));
//        	}
    		for(int i = 1; i < queues.size(); ++i) {
    			queues.get(i).pollFirst();
    			
    			// remove the queue if its now empty
    			if(queues.get(i).isEmpty()) {
    				queues.remove(i);
    				i--;
    			}
    		}
//    		System.out.println("After Poll");
//        	for(int i = 0; i < queues.size(); ++ i) {
//        		System.out.println("Queue: " + i + " " + queues.get(i));
//        	}
    		// merge 
    		for(int i = 1; i < queues.size(); ++i) {
    			if(queues.get(i).peekFirst() <= queues.get(i-1).peekLast()) {
    				queues.get(i-1).addAll(queues.get(i));
    				queues.remove(i);
//    				--i;
    			}
    		}
			days++;
    	}
    	return days;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] p = new int[n];

        String[] pItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int pItem = Integer.parseInt(pItems[i]);
            p[i] = pItem;
        }

        int result = poisonousPlants(p);
        System.out.println(result);

        scanner.close();
    }
}
