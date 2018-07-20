import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class candy {


    static ArrayList<Integer> each_player_candies_list= new ArrayList<>();
    static ArrayList<Integer> element_array;
    static long lcm=0;
    static int test_case=0, n=0;

    static String cc[];
    static Scanner sc= new Scanner(System.in);
    static int guests[];
    static int number_flag=0;
    public static void main(String sp[])
    {
        candy candy= new candy();
        // get combinations of a string charcters

        test_case=sc.nextInt();
        for(int i=0;i<test_case;i++) {
            number_flag=i+1;
            candy.input();


        }
    }


    public void input()
    {

        int n= sc.nextInt();
        guests= new int[n];

        for(int k=0;k< n;k++) {
            guests[k] = sc.nextInt();
        }
        element_array = new ArrayList<>();
        candy.combination();
        // split each combination and take a lcm of the array

        Set <Integer> set= new HashSet<>();
        for(int i=0;i<element_array.size();i++)
        {
            set.add(element_array.get(i));
        }

        Integer temp_int_array[]= new Integer[set.size()];
        temp_int_array=set.toArray(temp_int_array);

        lcm=lcm_of_array_elements(temp_int_array);
        //System.out.println(Integer.parseInt(tem));

        System.out.println("Case #"+number_flag+": "+lcm);
        //System.out.println(Integer.parseInt(Long.toString(lcm)));

    }

    public  static void combination()
    {
        int n = guests.length;
        for(int i=1;i<=n;i++)
            printCombination(guests, n, i);
    }


    public static long lcm_of_array_elements(Integer[] element_array)
    {
        long lcm_of_array_elements = 1;
        int divisor = 2;

        while (true) {
            long counter = 0;
            boolean divisible = false;

            for (int i = 0; i < element_array.length; i++) {

                // lcm_of_array_elements (n1, n2, ... 0) = 0.
                // For negative number we convert into
                // positive and calculate lcm_of_array_elements.

                if (element_array[i] == 0) {
                    return 0;
                }
                else if (element_array[i] < 0) {
                    element_array[i] = element_array[i] * (-1);
                }
                if (element_array[i] == 1) {
                    counter++;
                }

                // Divide element_array by devisor if complete
                // division i.e. without remainder then replace
                // number with quotient; used for find next factor
                if (element_array[i] % divisor == 0) {
                    divisible = true;
                    element_array[i] = element_array[i] / divisor;
                }
            }

            // If divisor able to completely divide any number
            // from array multiply with lcm_of_array_elements
            // and store into lcm_of_array_elements and continue
            // to same divisor for next factor finding.
            // else increment divisor
            if (divisible) {
                lcm_of_array_elements = lcm_of_array_elements * divisor;
            }
            else {
                divisor++;
            }

            // Check if all element_array is 1 indicate
            // we found all factors and terminate while loop.
            if (counter == element_array.length) {
                return lcm_of_array_elements;
            }
        }
    }



    // trying out this code to see if this works or not

        /* arr[] ---> Input Array
        data[] ---> Temporary array to store current combination
        start & end ---> Staring and Ending indexes in arr[]
        index ---> Current index in data[]
        r ---> Size of a combination to be printed */

        static void combinationUtil(int arr[], int data[], int start,
                                    int end, int index, int r)
        {

            // Current combination is ready to be printed, print it
            if (index == r)
            {
                int summ=0;
                for (int j=0; j<r; j++) {
                    summ+=data[j];
                }

                summ+=1;
                element_array.add(summ);
                return;
            }

            // replace index with all possible elements. The condition
            // "end-i+1 >= r-index" makes sure that including one element
            // at index will make a combination with remaining elements
            // at remaining positions
            for (int i=start; i<=end && end-i+1 >= r-index; i++)
            {

                data[index] = arr[i];
                combinationUtil(arr, data, i+1, end, index+1, r);
            }
        }

        // The main function that prints all combinations of size r
        // in arr[] of size n. This function mainly uses combinationUtil()
        static void printCombination(int arr[], int n, int r)
        {
            // A temporary array to store all combination one by one
            int data[]=new int[r];

            // Print all combination using temprary array 'data[]'
            combinationUtil(arr, data, 0, n-1, 0, r);
        }


}





