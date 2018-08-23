import java.util.*;

public class Potato_Farmers {
    static ArrayList<Integer> max_list= new ArrayList<>();
    public static void main(final String[] args) {
        int t = 0;
        ArrayList<ArrayList<Integer>> arrayList = null; // contains iq and weight in 0 and 1 respectively

        int count_1 = 0;
        Scanner sc = new Scanner(System.in);
        t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            count_1 = i;
            arrayList=new ArrayList<>();
            int n = sc.nextInt();

            for (int j = 0; j < n; j++) {
                int iq = sc.nextInt();
                int w = sc.nextInt();
                arrayList.add(new ArrayList<>(Arrays.asList(iq, w)));
            }

            //  weight descending
            //

            Collections.sort(arrayList, new Comparator<ArrayList<Integer>>() {
                @Override
                public int compare(ArrayList<Integer> a, ArrayList<Integer> b) {
                    return b.get(1).compareTo(a.get(1));
                }
            });




            arrayList=new Potato_Farmers().sorting(arrayList);



            Collections.sort(arrayList, new Comparator<ArrayList<Integer>>() {
                @Override
                public int compare(ArrayList<Integer> a, ArrayList<Integer> b) {
                    return a.get(0).compareTo(b.get(0));
                }
            });


            int prev_max = 0;
            arrayList=new Potato_Farmers().sorting(arrayList);
            if(max_list.get(0)>max_list.get(1))
                prev_max=max_list.get(0);
            else
                prev_max=max_list.get(1);
            max_list= new ArrayList<>();
            System.out.println("Case #" + (++count_1) + ": " + prev_max);
        }
    }

    public ArrayList<ArrayList<Integer>> sorting(ArrayList<ArrayList<Integer>> arrayList)
    {

        int count = 1;
        int max = 0;
        int prev_max = 0;


        for (ArrayList<Integer> top_element : arrayList) {
            count=1;
            if(arrayList.indexOf(top_element)==arrayList.size()-1)
            {
                break;
            }
            int x1=arrayList.get(arrayList.indexOf(top_element)).get(0);
            int y1=arrayList.get(arrayList.indexOf(top_element)).get(1);
            for (ArrayList<Integer> list : arrayList) {
                int index = arrayList.indexOf(list);
                if (index == arrayList.size() - 1) {
                    break;
                }
                if (arrayList.get(index + 1).get(0) >= x1 && arrayList.get(index + 1).get(1) < y1) {
                    count++;
                    max = count;
                    x1 = arrayList.get(index + 1).get(0);
                    y1 = arrayList.get(index + 1).get(1);
                }

            }
            if (max >=prev_max) {
                prev_max = max;
            }

        }
        max_list.add(prev_max);

        return arrayList;
    }


}