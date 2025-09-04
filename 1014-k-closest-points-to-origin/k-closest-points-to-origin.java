class Point {
    int dist;
    int x;
    int y;

    Point(int d, int x, int y) {
        this.dist = d;
        this.x = x;
        this.y = y;
    }
}

class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Point> maxHeap = new PriorityQueue<>(
            (a,b) -> b.dist - a.dist
            );

            for(int[] p : points){
                int dist = p[0]*p[0] + p[1]*p[1];
                maxHeap.add(new Point(dist,p[0],p[1]));
                if(maxHeap.size() > k){
                    maxHeap.poll();
                }
            }

int[][] result = new int[k][2];
int index = 0;


            while(!maxHeap.isEmpty()){
                Point top = maxHeap.poll();
                result[index][0]= top.x;
                result[index][1] = top.y;
                index++;
            }

            return result;

    }
}