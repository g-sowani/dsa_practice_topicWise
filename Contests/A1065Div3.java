import java.util.*;
import java.lang.Math;

public class A1065Div3 {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            if (n % 2 != 0) {
                arr.add(0);
            } else {
                arr.add(Math.min(n / 4, n / 2) + 1);
            }
        }
        for (int i = 0; i < t; i++) {
            System.out.println(arr.get(i));
        }
    }
}