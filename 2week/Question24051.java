package algorithm.week2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Question24051 {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            // 입력 받기
            String[] strings = reader.readLine().split(" ");
            int N = Integer.parseInt(strings[0]);
            int K = Integer.parseInt(strings[1]);

            int[] arr = new int[N];

            // 배열 값 입력 받기
            String[] elements = reader.readLine().split(" ");
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(elements[i]);
            }

            // 저장 횟수 추적
            int saveCount = 0;

            // 삽입 정렬
            for (int i = 1; i < arr.length; i++) {
                int key = arr[i];
                int j = i - 1;

                while (j >= 0 && arr[j] > key) {
                    arr[j + 1] = arr[j]; // 값이 뒤로 밀림
                    saveCount++; // 저장 횟수 증가

                    // K번째 저장을 찾았다면
                    if (saveCount == K) {
                        System.out.println(arr[j]);
                        return;
                    }
                    j--;
                }

                if (j + 1 != i) {
                    arr[j + 1] = key;
                    saveCount++;
                    if (saveCount == K) {
                        System.out.println(key);
                        return;
                    }
                }
            }

            if (saveCount - 1 < K) {
                System.out.println(-1);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
