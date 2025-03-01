package greedy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DifferentSummands {
	private static List<Integer> optimalSummands(int n) {
        List<Integer> summands = new ArrayList<Integer>();
        
        int sum = 0, num = 1;
        
        while(sum+num<=n) {
        	summands.add(num);
        	sum+=num;
        	num++;
        }
        
        if(sum<n) {
        	int lastIndex = summands.size() - 1;
        	
        	summands.set(lastIndex, summands.get(lastIndex)+(n-sum));
        }
        
        
        return summands;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> summands = optimalSummands(n);
        System.out.println(summands.size());
        for (Integer summand : summands) {
            System.out.print(summand + " ");
        }
    }	
}
