package algorithm.week1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Question2559 {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){

            String[] strings = reader.readLine().split(" ");
            int N = Integer.parseInt(strings[0]);
            int K = Integer.parseInt(strings[1]);

            int[] ints = new int[N];

            String[] strings2 = reader.readLine().split(" ");
            for (int i = 0; i < N; i++){
                ints[i] = Integer.parseInt(strings2[i]);
            }

            int windowSum = 0;
            for (int i = 0; i < K; i++) {
                windowSum += ints[i];
            }

            int largeNum = windowSum;

            for (int i = K; i < ints.length; i++) {

                windowSum += ints[i];      // 새로운 값 추가
                windowSum -= ints[i - K];  // 이전 값 제거

                if(largeNum < windowSum){
                    largeNum = windowSum;
                }


            }

            System.out.println(largeNum);

        }  catch (Exception e) {
            e.printStackTrace();
        }
    }
}
