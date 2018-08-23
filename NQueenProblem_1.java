import java.util.*;


public class NQueenProblem_1 {
    static ArrayList<Integer> queen_row = null;

    static class Position {
        int row=0, col=0;
        Position(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public Position[] solveNQueenOneSolution(int n, Position positions[]) {

        boolean hasSolution = solveNQueenOneSolutionUtil(n, 0, positions);
        if (hasSolution) {
            return positions;
        } else {
            return null;
        }
    }

    private boolean solveNQueenOneSolutionUtil(int n, int row, Position[] positions) {
        if (n == row) {
            return true;
        }
        int col;
        for (col = 0; col < n; col++) {
            boolean foundSafe = true;


            //check if this row and col is not under attack from any previous queen.

            if(!queen_row.contains(row))
            for (int queen = 0; queen < row; queen++) {
                if(positions[queen]!=null)
                if (positions[queen].col == col || positions[queen].row - positions[queen].col == row - col ||
                        positions[queen].row + positions[queen].col == row + col) {
                    foundSafe = false;
                    break;
                }
            }
            if (foundSafe) {
                if(!queen_row.contains(row))
                positions[row] = new Position(row, col);

                if (solveNQueenOneSolutionUtil(n, row + 1, positions)) {
                    return true;
                }

            }
        }
        if(!queen_row.contains(row))
        positions[row]=null;
        return false;
    }


    public static void main(String args[]) {
        int t;

        Scanner scanner = new Scanner(System.in);

        t = scanner.nextInt();
        for (int testcase = 0; testcase < t; testcase++) {
            queen_row = new ArrayList<>();
            int n=0;
            int count_1=testcase;
            n = scanner.nextInt();

            Position temp_position[] = new Position[n];
            for (int row = 0; row < n; row++) {

                char input = ' ';
                String abc = scanner.next();
                int col=abc.indexOf("x");
                if(col!=-1)
                {
                    temp_position[row] = new Position(row, col);
                    queen_row.add(row);
                }
                }


            boolean foundSafe=true;
            NQueenProblem_1 s = new NQueenProblem_1();
            foundSafe=valid(n,temp_position);
            Position[] positions=null;
            if(foundSafe==true)
                positions = s.solveNQueenOneSolution(n, temp_position);

            System.out.println("Case #" + (++count_1) + ":");

            if(positions!=null &&foundSafe==true)
           foundSafe=valid(n,positions);
            else
                foundSafe=false;

            if(foundSafe==true)
            for (int i = 0; i < n; i++) {
                Position p = positions[i];
                int col = p.col;
                int row = p.row;
                for (int j = 0; j < n; j++) {
                    if (i == row && j == col)
                        System.out.print("x");
                    else
                        System.out.print(".");
                }
                System.out.println();
            }
            else
                System.out.println("impossible");
        }
    }
    public static boolean valid(int n, Position positions[])
    {
        boolean foundSafe=true;
        for(int i=0;i<n;i++) {
            if (positions[i] != null) {
                int col = positions[i].col;
                int row = positions[i].row;

                for (int queen = 0; queen < i; queen++) {
                    if (positions[queen] != null)
                        if (positions[queen].col == col || positions[queen].row - positions[queen].col == row - col ||
                                positions[queen].row + positions[queen].col == row + col) {
                            foundSafe = false;
                            break;
                        }
                }
            }
        }
           return foundSafe;
    }
}
