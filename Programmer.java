
import java.util.*;

public class Programmer {
    static class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(final String[] args) {
        int t = 0;
        Scanner sc = new Scanner(System.in);
        t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            java.util.Deque<Point> points= new LinkedList<>();
            int count_1 = i+1;
            int n = sc.nextInt();
            for (int j = 0; j < n; j++) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                int z=sc.nextInt();
                int time=sc.nextInt();
                Point p = new Point(x, y);
                points.add(p);
            }

            Point[] points1 = new Point[points.size()];
            points1 = points.toArray(points1);
            Programmer programmer= new Programmer();
            List<Point> set=programmer.findConvexHull(points1);

            Collections.sort(set, new Comparator<Point>() {
                        @Override
                        public int compare(Point o1, Point o2) {
                            if (o1.x != o2.x) {
                                return Integer.compare(o1.x, o2.x);
                            }

                            else{
                                return Integer.compare(o1.y, o2.y);
                            }

                        }
                    });

            System.out.println("Case #" + (count_1) + ": ");
            System.out.println(set.size());
            for(Point pnt:set) {
                System.out.print(pnt.x+" "+pnt.y);
                System.out.println("");
            }
        }
    }

    public java.util.List<Point> findConvexHull(Point[] points) {
        //first find leftmost point to start the march.
        Point start = points[0];
        for (int i = 1; i < points.length; i++) {
            if (points[i].x < start.x) {
                start = points[i];
            }
        }
        Point current = start;
        //use set because this algorithm might try to insert duplicate point.
        List<Point> result = new ArrayList<>();
        result.add(start);
        java.util.List<Point> collinearPoints = new ArrayList<>();
        while (true) {
            Point nextTarget = points[0];
            for (int i = 1; i < points.length; i++) {
                if (points[i] == current) {
                    continue;
                }
                int val = crossProduct(current, nextTarget, points[i]);
                //if val > 0 it means points[i] is on left of current -> nextTarget. Make him the nextTarget.
                if (val > 0) {
                    nextTarget = points[i];
                    //reset collinear points because we now have a new nextTarget.
                    collinearPoints = new ArrayList<>();
                } else if (val == 0) { //if val is 0 then collinear current, nextTarget and points[i] are collinear.
                    //if its collinear point then pick the further one but add closer one to list of collinear points.
                    if (distance(current, nextTarget, points[i]) < 0) {
                        // collinearPoints.add(nextTarget);
                        nextTarget = points[i];
                    } else { //just add points[i] to collinearPoints list. If nextTarget indeed is the next point on
                        //convex then all points in collinear points will be also on boundary.
                        //   collinearPoints.add(points[i]);
                    }
                }
                //else if val < 0 then nothing to do since points[i] is on right side of current -> nextTarget.
            }

            //add all points in collinearPoints to result.
            for (Point p : collinearPoints) {
                result.add(p);
            }
            //if nextTarget is same as start it means we have formed an envelope and its done.
            if (nextTarget == start) {
                break;
            }
            //add nextTarget to result and set current to nextTarget.
            result.add(nextTarget);
            current = nextTarget;
        }
        return new ArrayList<>(result);
    }


    private int distance(Point a, Point b, Point c) {
        int y1 = a.y - b.y;
        int y2 = a.y - c.y;
        int x1 = a.x - b.x;
        int x2 = a.x - c.x;
        return Integer.compare(y1 * y1 + x1 * x1, y2 * y2 + x2 * x2);
    }

    private int crossProduct(Point a, Point b, Point c) {
        int y1 = a.y - b.y;
        int y2 = a.y - c.y;
        int x1 = a.x - b.x;
        int x2 = a.x - c.x;
        return y2 * x1 - y1 * x2;
    }
}

