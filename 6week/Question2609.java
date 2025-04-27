package algorithm.week6;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Question2609 {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String[] input = reader.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);

            int gcd = gcd(a, b);
            int lcm = a * b / gcd;

            System.out.println(gcd);
            System.out.println(lcm);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static int gcd(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
}
