import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;
import  java.lang.Math;

public class tower {
    static Scanner sc = new Scanner(System.in);
    static int t;
    static int flag=0;
    public static void main(String s[]) {

        int t= sc.nextInt();
        for (int i = 0; i < t; i++) {
            flag=i+1;
            tower.calculate_time();
        }
    }

    public static void calculate_time() {
        int time = 0;
        int h = sc.nextInt();
        int l = sc.nextInt();
        int total_cars = 0;
        int mid=0;
        if(l%2==0)
            mid=l/2;
        else
            mid= l/2+1;
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();

        for (int i = 0; i < h; i++) {
            ArrayList<Integer> input = new ArrayList<>();
            for (int j = 0; j < l; j++) {
                int entry = sc.nextInt();
                if (entry != -1)
                    total_cars += 1;

                input.add(entry);
            }
            list.add(input);
        }

        int position = 1;
        int horizontal_move = 0, vertical_move = 0, customer_car = 1, floor = 1;

        while (customer_car <= total_cars) {
            for (int k = 0; k < list.size(); ) {
                ArrayList arrays = list.get(k);

                if (arrays.contains(customer_car) && customer_car <= total_cars) {
// get the floor number
                    floor = list.indexOf(arrays) + 1;
// calculate vertical_move
                        vertical_move = (floor - 1) * 2;
// find position of car in arrays
                    int desired_position = arrays.indexOf(customer_car) + 1;
                    if(mid- desired_position<0)// move the queue to right
                    {
                        horizontal_move=arrays.size()-desired_position+1;
                        arrays=moveQueue(arrays, arrays.size()-desired_position+1, 'R');
                        list.remove(k);
                        list.add(k, arrays);
                        int xx=1;
                        //call queue function as public arraylist moveQueue(array,horizontal position, leftor right)
                    }
                    else
                    {
                        horizontal_move=  desired_position-1;
                        arrays=moveQueue(arrays, desired_position-1, 'L');
                        list.remove(k);
                        list.add(k, arrays);
                        int xx=1;
                                            }

                    time += (vertical_move * 10) + (horizontal_move * 5); // global variable
                   // System.out.println("Horiznotal_move: " + horizontal_move + "Vertical_move: " + vertical_move + "Time is:" + time);
                    customer_car++;
                    if (!(arrays.contains(customer_car))) {
                        k++;
                    }
                    if(customer_car > total_cars)
                        break;
                } else {
                    k++;
                }
            }
        }
            System.out.println("Case #"+flag+": "+ time);
    }


    public static ArrayList<Integer>  moveQueue(ArrayList<Integer> array, int moveBy, char leftorRight)
    {
        ArrayList<Integer> listt= new ArrayList<>();
        for(int y: array)
            listt.add(y);

        if(leftorRight=='R')
        for(int i=0;i<array.size();i++)
        {
            int x= (i+moveBy)%(array.size());
            listt.remove(x);
            listt.add(x,array.get(i));

        }
        else if(leftorRight=='L')
            for(int i=0;i<array.size();i++)
            {
                int x= (i-moveBy);
                if(x<0)
                    x+=array.size();
                listt.remove(x);
                listt.add(x,array.get(i));

            }

        return listt;
    }
}


