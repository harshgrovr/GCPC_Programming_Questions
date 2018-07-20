import java.util.*;

public class Snake {
    public int no_of_blocks_of_food, snake_starting_column, snake_starting_row;
    public static int grid_size;
    public static int test_case;
    public static boolean test_if_last_case = false;
    Deque<HashMap<Integer, Integer>> list;
    int grid_array[][];
    // initializing the variables
    int food_starting_column[], food_starting_row[], food_widht[], food_height[];

    String snake_path = "";
    public int length_of_snake = 0;
    String snake_direction[] = {"R", "L", "U", "D"};
    public char direction;
    static Scanner sc = new Scanner(System.in);
    static int no;

    // main function to call all the  functions
    public static void main(String s[]) {
        Snake snake = new Snake();
        // function to take input
        test_case = sc.nextInt();

        for (int i = 0; i < test_case; i++) {
            no = i + 1;
            if(i==test_case-1)
                test_if_last_case=true;
            snake.input();
        }
    }

    // taking input
    public void input() {
        direction = 'R';
        grid_size = sc.nextInt();
        grid_array = new int[grid_size + 1][grid_size + 1];
        no_of_blocks_of_food = sc.nextInt();
        snake_starting_column = sc.nextInt();
        snake_starting_row = sc.nextInt();

        food_starting_column = new int[no_of_blocks_of_food];
        food_starting_row = new int[no_of_blocks_of_food];
        food_widht = new int[no_of_blocks_of_food];
        food_height = new int[no_of_blocks_of_food];

        for (int i = 0; i < no_of_blocks_of_food; i++) {
            food_starting_column[i] = sc.nextInt();
            food_starting_row[i] = sc.nextInt();
            food_widht[i] = sc.nextInt();
            food_height[i] = sc.nextInt();
        }
        int snake_path_length = sc.nextInt();

            snake_path = sc.next();

        // i=ri; i<=ri+hi;i++
        // j=ci; j<=ci+wi;j++

        // making no of food items 1 in the grid
        int current_position = 0;
        while (current_position != no_of_blocks_of_food) {
            for (int i = food_starting_row[current_position]; i < food_starting_row[current_position] + food_height[current_position]; i++) {
                for (int j = food_starting_column[current_position]; j < food_starting_column[current_position] + food_widht[current_position]; j++) {
                    grid_array[i][j] = 1;
                }
            }
            current_position++;
        }

        // do not take starting value as 1 since it ia not countable. !!
        grid_array[snake_starting_row][snake_starting_column] = 0;

        /*
        for (int i = 0; i <= grid_size; i++) {
            for (int j = 0; j <= grid_size; j++) {
                System.out.print(grid_array[i][j] + " ");
            }
            System.out.println();
        }
        */
        list = new LinkedList <HashMap<Integer, Integer>>();
        HashMap<Integer,Integer> hashMap= new HashMap<Integer, Integer>();
        hashMap.put(snake_starting_row,snake_starting_column);
        list.addFirst(hashMap);

        char snakepath[] = snake_path.toCharArray();
        int string_path_traversed = 0;


        char direction_1 = direction;
        // call rule here... n times, or till we are receving true
        for (int i = 0; i < snakepath.length && rule(direction, snakepath[i]); i++) {
            string_path_traversed = i + 1;
        }

        // print out here and set length to 0 again
        System.out.println("Case #" + no + ": " + string_path_traversed + " " + length_of_snake);
        length_of_snake = 0;

    }

    // decides the direction and next position of the snake
    public boolean rule(char direction_1, char c) {
        int row=0;
        HashMap<Integer,Integer> arrayList_first = list.getFirst();
        for ( int key : arrayList_first.keySet() ) {
            row=key;
        }
        int column = (int) arrayList_first.get(row);
        direction = direction_1;
        if (direction == 'R') {
            if (c == 'F') {
                // make last position to increase COLUMN value(value of map) by 1 [from last value in queue]
                column += 1;
                //no change in direction
            } else if (c == 'R') {
                // make last position to increase ROW value(value of map) by 1 [from last value in queue]
                row += 1;
                direction = 'D';
            } else if (c == 'L') {
                // make last position to decrease ROW value(value of map) by 1 [from last value in queue]
                row -= 1;
                direction = 'U';
            }
        } else if (direction == 'L') {
            if (c == 'R') {
                // make last position to decrease ROW value(value of map) by 1 [from last value in queue]
                row -= 1;
                direction = 'U';
            } else if (c == 'F') {
                // make last position to decrease COLUMN value(value of map) by 1 [from last value in queue]
                column -= 1;
                // NO CHANGE IN DIRECTION
            } else if (c == 'L') {
                // make last position to decrease ROW value(value of map) by 1 [from last value in queue]
                row += 1;
                direction = 'D';
            }
        } else if (direction == 'U') {
            if (c == 'R') {
                // make last position to Increase Column value(value of map) by 1 [from last value in queue]
                column += 1;
                direction = 'R';
            } else if (c == 'F') {
                // make last position to Decrease ROW value(value of map) by 1 [from last value in queue]
                row -= 1;
                // NO CHANGE IN DIRECTION
            } else if (c == 'L') {
                // make last position to Decrease COLUMN value(value of map) by 1 [from last value in queue]
                column -= 1;
                direction = 'L';
            }
        } else if (direction == 'D') {
            if (c == 'R') {
                // make last position to Decrease Column value(value of map) by 1 [from last value in queue]
                column -= 1;
                direction = 'L';
            } else if (c == 'F') {
                // make last position to Increase ROW value(value of map) by 1 [from last value in queue]
                row += 1;
                // NO CHANGE IN DIRECTION
            } else if (c == 'L') {
                // make last position to Increase COLUMN value(value of map) by 1 [from last value in queue]
                column += 1;
                direction = 'R';
            }
        }

        // to make sure new element does not exceeds boundary
        // kind of like circular array
        if (row == grid_size + 1)
            row = 1;
        if (row == -1 || row == 0)
            row = grid_size;
        if (column == grid_size + 1)
            column = 1;
        if (column == -1 || column == 0)
            column = grid_size;

        HashMap <Integer, Integer> new_first_element =
                new HashMap <Integer, Integer> ();
        HashMap<Integer,Integer> hashMap= new HashMap<Integer, Integer>();
        hashMap.put(row, column);
        new_first_element.put(row, column);

        // delete the last and put it in front after changing row or column as per the above rule
        if (grid_array[row][column] == 0) {
         //   list.addFirst(new_first_element);
            list.removeLast();
        }

        // check if snake is colliding or not
        // if element is present in the list<ArrayList<integer> before, then we will now that snake has collided itself
        if(list.contains(hashMap))
            return false;

        if (grid_array[row][column] == 0) {
            list.addFirst(new_first_element);
        }


        if (grid_array[row][column] == 1) {
            //  put it in front, a new value
            grid_array[row][column]=0;
            list.addFirst(new_first_element);
//            if (row != snake_starting_row || column != snake_starting_column)
                length_of_snake++;

            return true;
        }


        return true;
    }
}
