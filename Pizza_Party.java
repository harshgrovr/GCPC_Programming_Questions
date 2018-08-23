import java.util.ArrayList;
import java.util.Scanner;

public class Pizza_Party {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long t = sc.nextLong();

        for (long testcase = 0; testcase < t; testcase++) {
            long count_1 = testcase + 1;
            long n= sc.nextLong();
            long x= (long) Math.sqrt(n);
            System.out.print("Case #" + (count_1)+": ");
            if((double)(x*x)== n)
            {
                System.out.print("0");
            }
            else
            {
                System.out.print((long)((x+1)*(x+1)-n));
            }
            System.out.println("");
        }
    }
}
