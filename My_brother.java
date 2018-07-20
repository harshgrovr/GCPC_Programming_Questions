import java.util.*;

public class My_brother {
    static Scanner sc= new Scanner(System.in);
    public static void main(String s[])
    {

        int t= Integer.parseInt(sc.nextLine());
        //int t= sc.nextInt();

        for(int i=0;i<t;i++)
        {
            int count=i;
            My_brother my_brother= new My_brother();
            System.out.print("Case #" + (++count) + ": ");
            my_brother.input(count);
            System.out.println("");
        }
    }

    public  void input(int count) {
        String input = sc.nextLine();
        Map<Character, Integer> occurrences = new HashMap<Character, Integer>();
        char splitWords[] = input.toCharArray();

        //inside the loop of words this will get the frequency

        for (char word : splitWords) {
            if (word != ' ') {
                Integer oldCount = occurrences.get(word);
                if (oldCount == null) {
                    oldCount = 0;
                }
                occurrences.put(word, oldCount + 1);
            }
        }

        int count_num = 0;
        int max = 0;
        for (int value : occurrences.values()) {
            //do something with values, compare if the values are same as before
            if (value >= max)
                max = value;
        }


        Set s = getKeysByValue(occurrences, max);
        if (s.size() >= 2 || s.size()==0)
            System.out.print("impossible");
        else  {
            calculate(s, splitWords);
        }

    }

    public void calculate(Set s, char[] splitWords)
    {

        Object arrray[]=s.toArray();
        int distance=0;
        char max_char= (char) arrray[0];
        distance=(max_char-'E'+26)%26;
        System.out.print(distance+" ");

        for (char c : splitWords) {
            if (c != ' ') {

                if(c - distance<65) {
                    c = (char) (c-distance+26);
                    System.out.print(c);
                }
                else {
                    c = (char) ((c - distance));
                    System.out.print(c);
                }
            }
            else {
                System.out.print(c);
            }

        }
        //System.out.print("!");
    }

    public static <T, E> Set<T> getKeysByValue(Map<T, E> map, E value) {
        Set<T> keys = new HashSet<T>();
        for (Map.Entry<T, E> entry : map.entrySet()) {
            if (Objects.equals(value, entry.getValue())) {
                keys.add(entry.getKey());
            }
        }
        return keys;
    }

    }

