import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'solve' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER m
     *  3. 2D_INTEGER_ARRAY a
     */

    public static int solve(int n, int m, List<List<Integer>> a) 
    {
    // Write your code here
        int count = 0;
        for(int i = 0 ; i < n - 1 ; i++)
        {
            if (i != 0)
            for(int j = 0 ; j < m - 1 ; j++)
            {
               if (j != 0)
               {
                   if(a.get(i).get(j) > a.get(i-1).get(j) &&
                      a.get(i).get(j) > a.get(i).get(j-1) &&
                      a.get(i).get(j) > a.get(i).get(j+1) &&
                      a.get(i).get(j) > a.get(i+1).get(j))
                   {    
                     count++;  
                   }
               }
            }
        }
        return count;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int m = Integer.parseInt(firstMultipleInput[1]);

        List<List<Integer>> a = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] aRowTempItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            List<Integer> aRowItems = new ArrayList<>();

            for (int j = 0; j < m; j++) {
                int aItem = Integer.parseInt(aRowTempItems[j]);
                aRowItems.add(aItem);
            }

            a.add(aRowItems);
        }

        int result = Result.solve(n, m, a);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}