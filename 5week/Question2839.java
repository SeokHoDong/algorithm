package algorithm.week5;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Question2839 {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            int n = Integer.parseInt(reader.readLine());

            int count = 0;

            while (n >= 0) {
                if (n % 5 == 0) {
                    count += n / 5;
                    System.out.println(count);
                    return;
                }
                n -= 3;
                count++;
            }

            System.out.println(-1);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
