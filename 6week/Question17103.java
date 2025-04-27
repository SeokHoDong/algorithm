package y202503.d09;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Question17103 {
    private static final int LIMIT = 1_000_000;
    private static boolean[] isPrime = new boolean[LIMIT + 1];

    public static void main(String[] args) {

        preprocessPrimes();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){

            int num = Integer.parseInt(reader.readLine());

            StringBuilder builder = new StringBuilder();
            while (num-- > 0) {
                int n = Integer.parseInt(reader.readLine());
                builder.append(countGoldbachPartitions(n)).append("\n");
            }

            System.out.println(builder.toString());

        }  catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void preprocessPrimes() {
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;

        for (int i = 2; i * i <= LIMIT; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= LIMIT; j += i) {
                    isPrime[j] = false;
                }
            }
        }
    }

    private static int countGoldbachPartitions(int n) {
        int count = 0;
        for (int a = 2; a <= n / 2; a++) {
            int b = n - a;
            if (isPrime[a] && isPrime[b]) {
                count++;
            }
        }
        return count;
    }

}
