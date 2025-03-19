package algorithm.week1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Question2018 {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){

            int N = Integer.parseInt(reader.readLine());

            int count = 0;
            int sum = 0;
            int start = 1;
            int end = 1;

            while (start <= N) {
                if (sum < N) {
                    sum += end;
                    end++;
                } else if (sum > N) {
                    sum -= start;
                    start++;
                } else {
                    count++;
                    sum -= start;
                    start++;
                }
            }

            System.out.println(count);
        }  catch (Exception e) {
            e.printStackTrace();
        }
    }
}
