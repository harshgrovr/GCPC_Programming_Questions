import java.util.*;
import java.util.Arrays;
import java.util.Scanner;



public class Buffet_Wars {

    static int no_of_dishes = 0, no_of_serving = 0;
    static Scanner sc = new Scanner(System.in);
    static HashMap<HashMap<String, Integer>, Float> hashMap = new HashMap<>();
    static float sum=0;

    public static void main(String s[]) {
        no_of_dishes = sc.nextInt();
        no_of_serving = sc.nextInt();
        for (int i = 0; i < no_of_dishes; i++) {
            HashMap<String, Integer> food_desc = new HashMap<>();
            food_desc.put(sc.next(), sc.nextInt());
            hashMap.put(food_desc, sc.nextFloat());
        }
        Buffet_Wars buffet_wars= new Buffet_Wars();
        buffet_wars.sort();
    }

    public void sort() {
        Collection<Float> values = hashMap.values();
        Float[] arr = new Float[values.size()]; // values
        arr= values.toArray(arr);
        Set<HashMap<String, Integer>> keys = hashMap.keySet();
        ArrayList<HashMap<String, Integer>> arrayList = new ArrayList<>();
        arrayList.addAll(keys);


        int n = arr.length;
        float temp = 0;
        HashMap<String, Integer> str_temp;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < (n - i); j++) {
                if (arr[j - 1] < arr[j]) {
                    //swap elements
                    temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;

                    //swap words side by side

                    str_temp = arrayList.get(j - 1);

                    arrayList.set(j - 1, arrayList.get(j));
                    arrayList.set(j, str_temp);
                }

            }
        }
        ArrayList<Integer> serving = new ArrayList<>();
            ArrayList<Integer> integerArrayList= new ArrayList<>();
            int x=0;

            for(HashMap<String, Integer> abc: arrayList)//5
                {
            Map<String, Integer> map = abc;

            for (Map.Entry<String, Integer> entry : map.entrySet())
            {
                integerArrayList.add(entry.getValue());
               // System.out.println(entry.getKey()+" "+entry.getValue()+" "+arr[x]);
                serving.add(entry.getValue());
                x++;
            }

                }


int index=0;
            for(int serve: serving)
            {
                if(serve<=no_of_serving)
                {
                    sum+=arr[index]*serve;
                    no_of_serving-=serve;
                }
                else if(serve>no_of_serving)
                {
                    sum+=arr[index]*no_of_serving;
                    no_of_serving=0;
                }


                if(no_of_serving==0)
                    break;
                index++;
            }

            System.out.println(String.format(java.util.Locale.US,"%.6f", sum));

            //sum_of_words = new ArrayList<Integer>(Arrays.asList(arr));
            //spell_checker_words = new ArrayList<String>(Arrays.asList(str_arr));
            sum=0;

        }
    }
