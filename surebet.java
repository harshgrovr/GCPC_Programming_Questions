import java.util.*;


public class surebet {

   static int test_case=0,no_of_games=0, minimum_bet=0;
    static  HashMap<String, Integer> stringIntegerHashMap;

    public static void main(String s[])
    {
        Scanner sc= new Scanner(System.in);
        test_case=sc.nextInt();
        for(int i=0;i<test_case;i++)
        {
            no_of_games= sc.nextInt();
            minimum_bet= sc.nextInt();

            stringIntegerHashMap = new HashMap<>();

        for(int j=0;j<no_of_games;j++)
        {
            stringIntegerHashMap.put(sc.next(), sc.nextInt());
        }

        surebet surebet=  new surebet();
        String final_result=surebet.getMaxOfSet(minimum_bet);

            System.out.println("Case #"+Integer.parseInt(String.valueOf(i+1))+": "+final_result);
        }
    }

    public String getMaxOfSet(int minimum_bet) {
        String Sport="impossible";
        int previous_max=0,first_time_flag=1;

        for (Map.Entry<String, Integer> entry : stringIntegerHashMap.entrySet())
        {
            if (entry.getValue().compareTo(minimum_bet) >=0)
            {
                if(first_time_flag==1)
                {
                    previous_max=entry.getValue();
                    first_time_flag=0;
                }

                    if (entry.getValue() <= previous_max) {

                        {
                            Sport = entry.getKey();
                            previous_max = entry.getValue();
                        }
                    }

            }
        }
        return  Sport;

    }
}
