import java.util.ArrayList;
import java.util.TreeSet;
import java.util.*;

public class Working_At_The_Restaurant {
    static Scanner scanner= new Scanner(System.in);
    public static void main(String[] s) {
        Scanner sc= new Scanner(System.in);
        int t = 0;
        t = scanner.nextInt();

        for (int i = 0; i < t; ++i) {
            input(i);
        }
    }
    private static void input(int count_1) {
        int n= scanner.nextInt();
        ArrayList<String > commmand = new ArrayList();
        ArrayList<Integer> number_of_plates = new ArrayList();
        for(int i=0;i<n;i++)
        {
            commmand.add(scanner.next());
            number_of_plates.add(scanner.nextInt());
        }

        int count=0;
        int ist=0;
        int second=0;
        System.out.println("Case #" + (++count_1) + ":");
        while (count!=number_of_plates.size()) {
            if (commmand.get(count).equals("DROP")) {
                ist += number_of_plates.get(count);
                System.out.println("DROP 1 " + number_of_plates.get(count));
                count++;
            } else if (commmand.get(count).equals("TAKE")) {
                if(number_of_plates.get(count)<=second) {
                    System.out.println("TAKE 2 " + number_of_plates.get(count));
                    second-=number_of_plates.get(count);
                    count++;
                }
                else {
                    if(second!=0){
                        System.out.println("TAKE 2 " + second);
                        System.out.println("MOVE 1->2 " + ist);
                        System.out.println("TAKE 2 " + String.valueOf(number_of_plates.get(count)-second));
                        second=ist-number_of_plates.get(count)-second;
                        ist=0;
                        count++;
                    }
                    else {
                        System.out.println("MOVE 1->2 " + ist);
                        System.out.println("TAKE 2 " + String.valueOf(number_of_plates.get(count)-second));
                        second=ist-number_of_plates.get(count);
                        ist=0;
                        count++;
                    }
                }
            }
        }
    }
}