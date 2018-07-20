import java.util.*;


public class pizza {


    static int n,m;
   static ArrayList<HashSet<Integer>> arrayLists;

    static Scanner sc= new Scanner(System.in);
    public static void main(String s[]) {
        int t;

        t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            pizza pizza = new pizza();
            arrayLists = new ArrayList<>();
            pizza.input();


            int flag = 0;
            if (n != 2)
                for (Set<Integer> abc : arrayLists) {
                    if (abc.size() == n) {
                        flag++;
                    }
                }
                int casee=i+1;

            if (flag > 1) {
                System.out.println("Case #" + casee + ": " + "no");

            }
            else
            {
                System.out.println("Case #" + casee + ": " + "yes");

            }
            flag = 0;
        }
    }

     void input()
    {
        n=sc.nextInt();
        m= sc.nextInt();
        for(int i=0;i<n;i++)
        {
            HashSet<Integer> integers= new HashSet<>();
            integers.add(null);
            arrayLists.add(integers);
        }

        for(int i=0;i<m;i++)
        {

            int first=sc.nextInt();
            int second=sc.nextInt();
            if(arrayLists.get(first-1).contains(null)) {
                HashSet<Integer> integers= new HashSet<>();
                integers.add(first);
                integers.add(second);
                arrayLists.set(first-1, integers);
            }
            else
            {
                HashSet<Integer> integers= new HashSet<>();
                integers=arrayLists.get(first-1);
                integers.add(first);
                integers.add(second);
                arrayLists.set(first-1,integers);
            }

            if(arrayLists.get(second-1).contains(null)) {
                HashSet<Integer> integers= new HashSet<>();
                integers.add(second);
                integers.add(first);
                arrayLists.set(second-1, integers);
            }
            else
            {
                HashSet<Integer> integers= new HashSet<>();
                integers=arrayLists.get(second-1);
                integers.add(first);
                integers.add(second);
                arrayLists.set(second-1,integers);
            }

        }
    }


}
