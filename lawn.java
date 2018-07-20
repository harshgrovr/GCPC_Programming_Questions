import javax.swing.text.TabExpander;
import java.util.*;

public class lawn {

    // taking input

   static Scanner scanner= new Scanner(System.in);

    public static void main(String s[])
    {
        int t=0;
        t= scanner.nextInt();
        for (int i=0;i<t;i++)
        input();
    }

    private static void input() {
        int nx,ny;
        float w;
        ArrayList<Float> xi= new ArrayList<>();
        ArrayList<Float> yi= new ArrayList<>();
        TreeSet<Float> floatsx= new TreeSet<>();
        TreeSet<Float> floatsy= new TreeSet<>();
        nx= scanner.nextInt();
        ny= scanner.nextInt();
        w= scanner.nextFloat();

        for(int i=0;i<nx;i++) {
            float temp= scanner.nextFloat();
            floatsx.add(temp);
            //floatsx.add(temp+(w/2));
            xi.add(temp);
        }

        for(int i=0;i<ny;i++) {
            float temp= scanner.nextFloat();
            floatsy.add(temp);
            //floatsy.add(temp+(w/2));
            yi.add(temp);
        }
        int flag=0;
        float lastx=0;
        float lasty=0;
        Object[] arrayx= floatsx.toArray();
        lastx= floatsx.last();
        lasty= floatsy.last();
        for(int i=0;i<arrayx.length-1;i++)
        {
            float temp= (float) arrayx[i];
            float temp_1= (float) arrayx[i+1];
            if(temp_1-temp>w)
            {
                flag=1;
                break;
            }

        }


            Object[] arrayy= floatsy.toArray();
            for(int i=0;i<arrayy.length-1;i++)
            {
                float temp= (float) arrayy[i];
                float temp_1= (float) arrayy[i+1];
                if(temp_1-temp>w)
                {
                    flag=1;
                    break;
                }
            }



        if(flag==1)
            System.out.println("NO");
        else if(lastx+w/2<75 || lasty+w/2< 100 || floatsx.first()-w/2>0 || floatsy.first()-w/2>0 )
            System.out.println("NO");
        else
            System.out.println("YES");


    }

}
