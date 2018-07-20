import java.lang.reflect.Array;
import java.util.*;
class happy_prime
{

   public  static ArrayList<String> happy_prime_list= new ArrayList<>();
    public  static ArrayList<String> temp_happy_prime_list= new ArrayList<>();
    public   static ArrayList<String> unhappy_list= new ArrayList<>();

    public static void main(String s[]) {
        happy_prime happyPrime= new happy_prime();
        happyPrime.final_func();
    }

    public void final_func()
    {
        int test_cases=0;
        Scanner sc = new Scanner(System.in);
        test_cases = sc.nextInt();

        ArrayList<Integer> k_array= new ArrayList<>();
        ArrayList<Long> m_array= new ArrayList<>();
        ArrayList<String> result_array= new ArrayList<>();
        for (int i=0;i<test_cases;i++)
        {
            k_array.add(sc.nextInt());
            m_array.add(sc.nextLong());
        }

        for(long x: m_array) {
            if(happy_prime_list.contains(String.valueOf(x)))
                result_array.add("YES");
            else if(unhappy_list.contains(String.valueOf(x)))
                result_array.add("NO");
            else
                result_array.add(happy_prime_function(x));
        }

        for (int k=0;k<m_array.size();k++)
        {
            System.out.println(k_array.get(k)+" "+ m_array.get(k)+" "+ result_array.get(k));
        }

    }


        public  String happy_prime_function(long x)
        {
            if(prime(x))
            {

                String temp = new String(String.valueOf(x));
                int while_counter=0;
                while ((!temp.equals("1")) && while_counter!=10) {

                    char c[] = temp.toCharArray();
                    int sum_of_squrare_of_digits = 0;
                    temp_happy_prime_list.add(temp);
                    for (char c1 : c) {
                        Integer i1 = Integer.parseInt(String.valueOf(c1));
                        sum_of_squrare_of_digits += i1 * i1;
                    }
                    temp = new String(String.valueOf(sum_of_squrare_of_digits));
                    while_counter++;
                }
                if(temp.equals("1")) {
                    for (String s : temp_happy_prime_list) {
                        if (prime(Long.parseLong(s))) {
                            happy_prime_list.add(s);
                        }
                        else
                            unhappy_list.add(s);

                    }
                    temp_happy_prime_list.clear();
                }
                else {
                    for(String s: temp_happy_prime_list)
                    {
                        unhappy_list.add(s);
                    }
                    temp_happy_prime_list.clear();
                }

                if(temp.equals("1"))
                    return "YES";
                else
                    return  "NO";
            }
            else
                return  "NO";

        }


        public static boolean prime(long n)
        {
            int prime_flag=1;
            long square_root_n= (long) (Math.sqrt(n)+1);
            if(n==1)
                return false;
            if(n==2)
                return true;
            for(int i=2;i<square_root_n;i++)
            {
                if(n%i==0)
                {
                    prime_flag=0;
                    break;
                }
            }
            if(prime_flag==0)
                return false;
            else
                return true;
        }
}