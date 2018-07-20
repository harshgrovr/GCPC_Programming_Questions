import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.lang.Math;

public class touch {
    static int test_case = 0, length_of_spell_checker = 0, horizontal_distance = 0, vertical_distance = 0, sum = 0;
    String typed_word = "";
    static Scanner sc = new Scanner(System.in);
    ArrayList<String> spell_checker_words = null;
    ArrayList<Character> list0 = new ArrayList<Character>(Arrays.asList('q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p'));
    ArrayList<Character> list1 = new ArrayList<Character>(Arrays.asList('a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l'));
    ArrayList<Character> list2 = new ArrayList<Character>(Arrays.asList('z', 'x', 'c', 'v', 'b', 'n', 'm'));
    ArrayList<Integer> sum_of_words = null;
    char next_character;

    char[] current_spell_checker_string_array = null;
    char[] current_word_array = null;
    static int number_flag=0;
    public static void main(String s[]) {
        touch touch = new touch();
              test_case= sc.nextInt();

          for(int i=0;i<test_case;i++) {
              number_flag=i+1;
              touch.input();

          }

    }

    public void input() {
         sum_of_words = new ArrayList<>();
        spell_checker_words = new ArrayList<>();
        typed_word = sc.next();
        length_of_spell_checker = sc.nextInt();

        for (int i = 0; i < length_of_spell_checker; i++)
            //System.out.println(sc.nextLine());
            spell_checker_words.add(sc.next());
        current_word_array = typed_word.toCharArray();
        calculate_sum();
    }

    public void calculate_sum() {

        for (int i = 0; i < spell_checker_words.size(); i++) {
            String current_spell_checker_string = spell_checker_words.get(i);
            current_spell_checker_string_array = current_spell_checker_string.toCharArray();
            for (int j = 0; j < current_spell_checker_string_array.length; j++) {
                sum_determine(current_spell_checker_string_array[j], current_word_array[j]);
            }

            sum_of_words.add(sum);
            sum = 0;
        }
        sort();
        System.out.println("Case #"+number_flag+":");
        for (int i = 0; i < spell_checker_words.size(); i++) {
            System.out.print(spell_checker_words.get(i) + " " + sum_of_words.get(i) + "\n");
        }
    }

    public void sum_determine(char c, char typed_character) {
        int temp_horizontal_distance = 0, temp_vertical_distance = 0;
        if (list0.contains(c)) {
            horizontal_distance = list0.indexOf(c);
            vertical_distance = 0;
        } else if (list1.contains(c)) {
            horizontal_distance = list1.indexOf(c);
            vertical_distance = 1;
        } else if (list2.contains(c)) {
            horizontal_distance = list2.indexOf(c);
            vertical_distance = 2;
        }

        if (list0.contains(typed_character)) {
            temp_horizontal_distance = list0.indexOf(typed_character);
            temp_vertical_distance = 0;
        } else if (list1.contains(typed_character)) {
            temp_horizontal_distance = list1.indexOf(typed_character);
            temp_vertical_distance = 1;
        } else if (list2.contains(typed_character)) {
            temp_horizontal_distance = list2.indexOf(typed_character);
            temp_vertical_distance = 2;
        }

        sum += Math.abs(temp_horizontal_distance - horizontal_distance) + Math.abs(vertical_distance - temp_vertical_distance);


        horizontal_distance = 0;
        vertical_distance = 0;
    }

    public void sort() {

        Integer[] arr= new Integer[sum_of_words.size()];
        String[] str_arr= new String[sum_of_words.size()];
                arr=sum_of_words.toArray(arr);// int array
                str_arr=spell_checker_words.toArray(str_arr); // string array
        int n = arr.length;
        int temp = 0;
          String str_temp="";
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < (n - i); j++) {
                if (arr[j - 1].intValue() > arr[j].intValue()) {
                    //swap elements
                    temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;

                    //swap words side by side

                    str_temp = str_arr[j - 1];
                    str_arr[j - 1] = str_arr[j];
                    str_arr[j] = str_temp;
                }
              //  System.out.println(arr[j-1]);
                //System.out.println(arr[j]);

                                if(arr[j - 1].intValue() == arr[j].intValue())
                {
                    if(str_arr[j-1].compareTo(str_arr[j])>0)
                    {
                        str_temp = str_arr[j - 1];
                        str_arr[j - 1] = str_arr[j];
                        str_arr[j] = str_temp;
                    }
                }
            }
        }
        sum_of_words=new ArrayList<Integer>(Arrays.asList(arr));
        spell_checker_words=new ArrayList<String>(Arrays.asList(str_arr));

    }
}