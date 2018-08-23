

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class pizza {

    static Scanner sc;

    public static void main(String[] s) {
        sc= new Scanner(System.in);
        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            pizza pizza = new pizza();
            pizza.input(i);
        }
    }

    public void input(int count) {
        int flag=0;
         int n;
         int m;
         int first=0, second=0;
         ArrayList<Integer> first_array= new ArrayList<>();
        ArrayList<Integer> second_array= new ArrayList<>();
        n = sc.nextInt();
        m = sc.nextInt();
        char colorArray[] = new char[n];
        for (int i = 0; i < n;i++) {
            colorArray[i] = 'y';
        }

        for (int i = 0; i < m; i++) {
             first = sc.nextInt();
             second = sc.nextInt();
             first_array.add(first);
             second_array.add(second);
        }
        for (int i = 0; i < m; i++) {
            first=first_array.get(i);
            second=second_array.get(i);
            if(colorArray[first-1]=='y' && colorArray[second-1]=='y') {/// for the first time initialize the colors
                if (colorArray[first - 1] == 'y') {
                    colorArray[first - 1] = 'b';
                }
                if (colorArray[second - 1] == 'y') {
                    colorArray[second - 1] = 'w';
                }
            }

            // if first color is black and second color is either yellow then make it white.
            else if(colorArray[first-1]=='b' && (colorArray[second-1]=='y'))
                {
                    colorArray[second-1]='w';
                }
            // if first color is white and second color is yellow then make it black.
            else if(colorArray[first-1]=='w' && (colorArray[second-1]=='y'))
            {
                colorArray[second-1]='b';
            }
            // if second color is black and first color is yellow then make it whote
            else if(colorArray[second-1]=='b' && (colorArray[first-1]=='y'))
            {
                colorArray[first-1]='w';
            }
            // if second color is white and first color is yellow then make it black .
            else if(colorArray[second-1]=='w' && (colorArray[first-1]=='y'))
            {
                colorArray[first-1]='b';
            }
            else if((colorArray[first-1]=='w'|| colorArray[first-1]=='b')&& colorArray[second-1]== (colorArray[first-1]))
            {
                flag=1;
                break;
            }

            }

        if(flag==1)
            System.out.println("Case #" + (++count) + ": "+"no");
        else
            System.out.println("Case #" + (++count) + ": "+"yes");



    }
}
