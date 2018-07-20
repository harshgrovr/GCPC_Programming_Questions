import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class exam_prep {
    int length_of_lecture = 0, no_of_topics = 0;

    public static void main(String s[]) {
        int lectures = 0;
        Scanner sc = new Scanner(System.in);
        lectures = sc.nextInt();
        exam_prep exam_prep = new exam_prep();
        for (int i = 0; i < lectures; i++) {
            exam_prep.input(sc, i);
        }

    }

    void input(Scanner sc, int input_number) {
        int no_of_max_character = sc.nextInt();
        no_of_topics = sc.nextInt();
        ArrayList<Integer> length_of_topic = new ArrayList<>();
        ArrayList<Integer> score_of_topic = new ArrayList<>();
        ArrayList<Float> ratio_topic = new ArrayList<>();
        for (int j = 0; j < no_of_topics; j++) {
            int length = sc.nextInt();
            int score = sc.nextInt();
            length_of_topic.add(length);
            score_of_topic.add(score);
            ratio_topic.add((float) ((float)score / (float)length));
        }
        int current_length = 0;
        int score = 0;
        Map<Integer, ArrayList> map = max(ratio_topic, length_of_topic, score_of_topic);
        int index = 0;
        ratio_topic = map.get(0);
        length_of_topic = map.get(1);
        score_of_topic = map.get(2);
        ArrayList<Integer> previous_index= map.get(3);
        ArrayList<Integer> output= new ArrayList<>();

        while (index<ratio_topic.size()) {
            if (current_length < no_of_max_character) {
                current_length += length_of_topic.get(index);
                score += score_of_topic.get(index);
                output.add(previous_index.get(index));
            }
            else  if(current_length == no_of_max_character)
                break;
            else if(index<=ratio_topic.size()-2) {
                index++;
                current_length -= length_of_topic.get(index-1);
                score -= score_of_topic.get(index-1);
                output.remove(output.size()-1);
                current_length += length_of_topic.get(index);
                score += score_of_topic.get(index);
                output.add(previous_index.get(index));
            }
            else
            {
                current_length -= length_of_topic.get(index);
                score -= score_of_topic.get(index);
                output.remove(output.size()-1);
                index++;
            }
        }
        System.out.print("Case #"+(++input_number)+": ");
        for(int x: output)
            System.out.print(x+1+" ");
        System.out.println("");
    }

    Map<Integer, ArrayList> max(ArrayList<Float> ratio, ArrayList<Integer> length, ArrayList<Integer> score) {
        int n = ratio.size();
        int max_index = 0;
        float temp = 0;
        int scoretmp = 0;
        ArrayList<Integer> previous_index= new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            previous_index.add(i);
        }
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < (n - i); j++) {
                if (ratio.get(j - 1) < ratio.get(j)) {
                    //swap elements
                    temp = ratio.get(j - 1);
                    ratio.set(j - 1, ratio.get(j));
                    ratio.set(j, temp);
                    max_index = j;


                    // do the same for score and index
                    scoretmp = score.get(j - 1);
                    score.set(j - 1, score.get(j));
                    score.set(j, scoretmp);

                    // do the same for score and index
                    scoretmp = length.get(j - 1);
                    length.set(j - 1, length.get(j));
                    length.set(j, scoretmp);

                    scoretmp = previous_index.get(j - 1);
                    previous_index.set(j - 1, previous_index.get(j));
                    previous_index.set(j, scoretmp);
                }
            }
        }
        Map<Integer, ArrayList> map = new HashMap<>();
        map.put(0, ratio);
        map.put(1, length);
        map.put(2, score);
        map.put(3, previous_index);

        return map;
    }
}
