import java.util.Scanner;

public class Scrambled_Chatlog {
    static Scanner sc= new Scanner(System.in);
    //static Scanner sc1= new Scanner(System.in);
    public static void main(String s[])
    {
        int t= Integer.parseInt(sc.nextLine());
        //int t= sc.nextInt();

        for(int i=0;i<t;i++)
        {
            int count=i;
            Scrambled_Chatlog scrambled_chatlog= new Scrambled_Chatlog();
            scrambled_chatlog.input(count);
        }
    }

    void input(int count) {
        String input=sc.nextLine();
        String stringss[]=input.split("#");
        int number=Integer.parseInt(stringss[0]);
        String s1=stringss[1].substring(0,number);
        String s2=stringss[1].substring(number,stringss[1].length());
        String s3= s2+s1;
        System.out.println("Case #" + (++count) + ": "+s3);


    }
}
