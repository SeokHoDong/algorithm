package algorithm.week1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Question10773 {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){

            int num = Integer.parseInt(reader.readLine());

            Stack<Integer> stack = new Stack<>();

            for (int i = 0; i < num; i++){
                int x = Integer.parseInt(reader.readLine());

                if(x != 0){
                    stack.push(x);
                    continue;
                } else {
                    stack.pop();
                }
            }

            int sum = 0;
            while (!stack.isEmpty()) {
                sum += stack.pop();
            }

            System.out.println(sum);


        }  catch (Exception e) {
            e.printStackTrace();
        }
    }
}
