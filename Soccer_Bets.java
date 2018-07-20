import java.util.*;

public class Soccer_Bets {
    public static ArrayList<ArrayList<String>> input;
    public static HashMap<String, Integer> scores;
    String first_team,  second_team, first_team_score, second_team_score;
    // let us take input
    static int test_cases=0;
  static  Scanner sc= new Scanner(System.in);
    public static void main(String s[])
    {
        Soccer_Bets soccer_bets= new Soccer_Bets();
         sc= new Scanner(System.in);
//         System.out.println(sc.nextInt());
        test_cases=sc.nextInt();
        for(int i=0;i<test_cases;i++)
        {
            input= new ArrayList<>();
            scores= new HashMap<>();
            for(int j=0;j<16;j++){
            soccer_bets.input(); // take all the input
                 }
            soccer_bets.calculate_winner(); // score set is ready find the output who has maximum value

            Map.Entry<String, Integer> maxEntry = null;

            for (Map.Entry<String, Integer> entry : scores.entrySet())
            {
                if (maxEntry == null || entry.getValue().compareTo(maxEntry.getValue()) >0)
                {
                    maxEntry = entry;
                }
            }
            int case_value=i+1;
            System.out.println("Case #"+case_value+": "+maxEntry.getKey());

        }
    }

    public void input()
    {
        first_team= sc.next();
        second_team= sc.next();
        first_team_score= sc.next();
        second_team_score= sc.next();
        ArrayList<String> input_value= new ArrayList<>();
        input_value.add(first_team);
        input_value.add(second_team);
        input_value.add(first_team_score);
        input_value.add(second_team_score);
        input.add(input_value);
    }

    public void calculate_winner()
    {
        for(ArrayList<String> match_result: input)
        {
            if(Integer.parseInt(match_result.get(2))> Integer.parseInt(match_result.get(3)))
            {
                int x=0;
                if(scores.get(match_result.get(0))==null)
                    x=0;
                 else x=scores.get(match_result.get(0));// it will give me a value
                 x+=1;
                 scores.put(match_result.get(0), x);
            }
            else
            {
                int x=0;
                if(scores.get(match_result.get(1))==null)
                    x=0;
                 else x=scores.get(match_result.get(1));// it will give me a value
                x+=1;
                scores.put(match_result.get(1), x);
            }

        }
    }

}

