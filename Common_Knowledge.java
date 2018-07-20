import java.util.Scanner;

public class Common_Knowledge {

    public static void main(String s[]) {

        Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            double x=Math.pow(8, n);
            long l=new Double(x).longValue();
            System.out.println(l);
        }
    }

