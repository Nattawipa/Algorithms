import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'FindTotalStudents' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. 2D_INTEGER_ARRAY a
     */

    public static int FindTotalStudents(int n, List<List<Integer>> a) {
    // Write your code here
        Set<Integer> x = new HashSet<Integer>(); 
        for (int i = 0; i < n; i++) 
        {
            x.add(a.get(i).get(0));
            x.add(a.get(i).get(1));
        }
        LinkedList<Integer> arr = new LinkedList<Integer>();
        LinkedList<Boolean> dup = new LinkedList<Boolean>();
        for(Integer item : x)
        {
            arr.add(item);
            dup.add(false);
        }
        int sum = 0;
        for(int i =0;i< a.size();i++){
            int[] founded = {0,0};
            for(int j = 0;j< a.get(0).size()-1;j++){
                for(int r = 0;r<arr.size();r++){
                    if(arr.get(r) == a.get(i).get(j) && dup.get(r) == false){
                        dup.set(r,true);
                        founded[j] = 1;
                    }
                    else{
                        continue;
                    }
                }
            }
            System.out.println(founded[0]);
            if(founded[0] == 1 && founded[1] == 1){
                sum += a.get(i).get(2);
            }
        }
        return sum;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> visits = new ArrayList<>();

        IntStream.range(0, n).forEach(i -> {
            try {
                visits.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int result = Result.FindTotalStudents(n, visits);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}