import java.util.Scanner;

public class Superpowers {
    public static  void main(String s[]) {
        Scanner sc = new Scanner(System.in);
        int test_case = sc.nextInt();
        for (int i = 0; i < test_case; i++) {
            String str = sc.next();
            String findStr = sc.next();


            char first_chracter = findStr.charAt(0);

            int lastIndex = 0;
            int count = 0;
            int j = 0;
            int ii=0, jj=0;
            while (j<=str.length()-findStr.length()) {

                if (str.charAt(j) == first_chracter) {
                    jj=j+findStr.length();
                    String ss= str.substring(j,jj);
                    if (ss.equals(findStr)) {
                        count++;
                    }
                }
                j++;
            }
                int x = i;
                System.out.println("Case #" + (++x) + ": " + count);

        }
    }
}


