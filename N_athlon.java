import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class N_athlon {

    public static void main(String s[]) {
        long t = 0;
        Scanner sc = new Scanner(System.in);
        t = sc.nextLong();
        N_athlon n_athlon = new N_athlon();
        for (long i = 0; i < t; i++) {
            n_athlon.input(sc, i);
        }
    }

    private void input(Scanner sc, long count) {
        long n = sc.nextLong();
        long k = sc.nextLong();
        long max = 0;
        if (n != 0) {
            ArrayList<Long> rest = new ArrayList<>();
            ArrayList<Long> size = new ArrayList<>();
            ArrayList<ArrayList<Long>> collection = new ArrayList<>();
            long n1 = 0, k1 = 0;
            for (long i = 0; i < n; i++) {
                n1 = sc.nextLong();
                k1 = sc.nextLong();
                size.add(n1);
                rest.add(k1);
            }
            int maxx=0;
            int index=0;
            for(int i=0;i<size.size();i++)
            {
                if(maxx<size.get(i)) {
                    maxx = Math.toIntExact(size.get(i));
                    index=i;
                }
            }
            // swap maximum and first
            int temp=Math.toIntExact(size.get(index));
            size.set(index, size.get(0));
            size.set(0, (long) temp);

             temp=Math.toIntExact(rest.get(index));
            rest.set(index, rest.get(0));
            rest.set(0, (long) temp);


            long num = 0;
            long flag = 0;
            int same_flag=1;
            long prev_l2=rest.get(0);
            int k22=0;
            int enter_flag=0;
            for (long j = k; j > 0; ) {
                for (long i = 0; i < n; i++) {
                    long k2 = size.get((int) i);
                    long l2 = rest.get((int) i);
                     k22= Math.toIntExact(size.get(0));
                    if (prev_l2!=l2)
                        same_flag=0;

                    if(k2!=0) {
                        if ((j - l2) % k2 == 0) {
                            max = j;
                            flag = 1;
                            enter_flag=1;
                        } else {
                            max = 0;
                            flag = 0;
                            break;
                        }
                    }
                }
                if(enter_flag==1) {
                    j = j - k22;
                    enter_flag=0;
                }
                else
                    j--;
                if (flag == 1)
                    break;
            }

                if (max != 0) {
                System.out.println("Case #" + (++count) + ": " + max);
            } else if(same_flag!=0)
                System.out.println("Case #" + (++count) + ": "+rest.get(0));
            else
                System.out.println("Case #" + (++count) + ": impossible");
        }
    else if(k==1)
        System.out.println("Case #" + (++count) + ": " + "1");
        else
            System.out.println("Case #" + (++count) + ": " + max);

    }


    }


/*
        for (int j = 0; j < rest.size(); j++) {
            n1= size.get(j);
            k1= rest.get(j);

            ArrayList<Integer> calculated_values = new ArrayList<>();
            for (int i = 0; num <= k; i++) {
                num = n1 * i + k1;
                if(num<=k)
                calculated_values.add(num);
            }
            num=0;
            collection.add(calculated_values);
        }
        int max=0;
        ArrayList<Integer> max_array= new ArrayList<>();
        if(collection.size()>1) {
            ArrayList<Integer> temp1 = collection.get(0);
            ArrayList<Integer> temp2 = collection.get(1);
            Collections.sort(temp1);
            Collections.sort(temp2);
            int temp_flag=0;
            for(int i=temp1.size()-1;i>0;i--)
            {
                if(temp2.contains(temp1.get(i)))
                {
                    max=temp1.get(i);
                    max_array.add(max);
                }
            }
        }
        else
            max=Collections.max(collection.get(0));
        //max = get last element
        int flag=0;
        int max_temp=0;
        int temp_flag=0;
        for(int temp: max_array) {
            max_temp=temp;
            for (ArrayList arrayList : collection) {
                if (!arrayList.contains(temp)) {
                    flag = 1;
                    break;
                }
            }
            if(flag!=1 && max_temp>=max) {
                max = max_temp;
                temp_flag=1;
            }
            flag=0;
        }

        if(temp_flag==1)
        {
            System.out.println("Case #"+(++count)+": "+max);
        }
        else
            System.out.println("Case #"+(++count)+": impossible");
*/


