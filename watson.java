import java.time.temporal.ChronoField;
import java.util.*;
public class watson {

    public static int test_case;
    public static long result=0;
    static String input="";
    static Scanner scanner= new Scanner(System.in);
    static ArrayList<Long> integers= new ArrayList<>();
    static ArrayList<String> strings= new ArrayList<>();


    public static void main(String s[])
        {

            watson watson= new watson();
            test_case=Integer.parseInt(scanner.nextLine());
            for(int i=0;i<test_case;i++) {
                int first_time_flag=1;
                input= scanner.nextLine();
                 integers= new ArrayList<>();
                 strings= new ArrayList<>();
                watson.seperate_integer_and_string(input);
                int j=0;
                for(j=0;j<strings.size();j++)
                {

                        if(first_time_flag==1) {
                            watson.answer(integers.get(j), integers.get(j + 1), strings.get(j));
                            first_time_flag=0;
                        }
                        else
                            watson.answer(result,integers.get(j+1),strings.get(j));
                }
                if(j==0)
                     System.out.println("Case #"+Long.parseLong(String.valueOf(i+1))+": "+integers.get(j));
                else
                    System.out.println("Case #"+Long.parseLong(String.valueOf(i+1))+": "+result);
                     result=0;
            }
        }

        public void answer(long first, long second, String operation)
        {
            switch (operation) {
                case "plus":
                    result=first+second;
                    break;
                case "minus":
                    result=first-second;
                    break;
                case "times":
                    result=first*second;
                    break;
                case "tothepowerof":
                    result= (long) Math.pow(first,second);
                    break;
                default:
                    result=first;
            }

        }


    public void seperate_integer_and_string(String input)
    {
        int front=0, previous=0;
        char input_chars[]=input.toCharArray();
        for(int i=0;i<input.length();) {
            while (Character.isDigit(input_chars[i])) {
                front++;
                i++;
                if(i==input.length())
                    break;
            }

            String second_input = input.substring(previous, front);
            integers.add(Long.parseLong(second_input));
            previous = front;


            if(i==input.length())
                break;


            while (Character.isLetter(input_chars[i])) {
                front++;
                i++;
            }

            second_input = input.substring(previous, front);
            strings.add(second_input);
            previous = front;
        }
    }
}
