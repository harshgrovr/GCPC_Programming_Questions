import java.util.Scanner;

public class super_powerts{

    public static int count(final String string, final String substring)
    {
        int count = 0;
        int idx = 0;

        while ((idx = string.indexOf(substring, idx)) != -1)
        {
            idx++;
            count++;
        }

        return count;
    }
    public static int count(final String string, final char c)
    {
        return count(string, String.valueOf(c));
    }

    public  static  void main(String s[]) {
        Scanner sc = new Scanner(System.in);
        int test_case = sc.nextInt();
        for (int i = 0; i < test_case; i++) {
            int temp=i;
            String str = sc.next();
            String findStr = sc.next();
            System.out.println("Case #" + (++temp) + ": " + count(str, findStr));
        }
    }

}
