package algorithm;

import java.util.Scanner;

public class DynamicProgramming {

    //fn = min{f(n-1),f(n-4),f(n-11)} + 1
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();
        int cost = cost(i);
        System.out.println(cost);
    }

    private static int cost(int n) {
        int sum = 0;
        for (int i = 1; i <n ; i++) {
            sum =
        }

        return sum;
    }
}
