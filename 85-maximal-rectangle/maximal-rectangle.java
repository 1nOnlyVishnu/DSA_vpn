import java.util.*;

class Pair {
    int num;
    int index;

    Pair(int num, int index) {
        this.num = num;
        this.index = index;
    }
}

class Solution {

    private ArrayList<Integer> reverseArrayList(ArrayList<Integer> ans) {
        int i = 0;
        int j = ans.size() - 1;

        while (i < j) {
            int temp = ans.get(i);
            ans.set(i, ans.get(j));
            ans.set(j, temp);
            i++;
            j--;
        }

        return ans;
    }

    public ArrayList<Integer> NSR(int[] arr) {
        int n = arr.length;
        Stack<Pair> st = new Stack<>();
        ArrayList<Integer> ans = new ArrayList<>();

        for (int i = n - 1; i >= 0; i--) {
            if (st.size() == 0) {
                ans.add(n);
            } else if (st.size() > 0 && st.peek().num < arr[i]) {
                ans.add(st.peek().index);
            } else if (st.size() > 0 && st.peek().num >= arr[i]) {
                while (st.size() > 0 && st.peek().num >= arr[i]) {
                    st.pop();
                }
                if (st.size() == 0) {
                    ans.add(n);
                } else {
                    ans.add(st.peek().index);
                }
            }
            st.push(new Pair(arr[i], i));
        }

        return reverseArrayList(ans);
    }

    public ArrayList<Integer> NSL(int[] arr) {
        int n = arr.length;
        ArrayList<Integer> ans = new ArrayList<>();
        Stack<Pair> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            if (st.size() == 0) {
                ans.add(-1);
            } else if (st.size() > 0 && st.peek().num < arr[i]) {
                ans.add(st.peek().index);
            } else if (st.size() > 0 && st.peek().num >= arr[i]) {
                while (st.size() > 0 && st.peek().num >= arr[i]) {
                    st.pop();
                }
                if (st.size() == 0) {
                    ans.add(-1);
                } else {
                    ans.add(st.peek().index);
                }
            }
            st.push(new Pair(arr[i], i));
        }

        return ans;
    }

    private int MAH(int[] heights) {
        ArrayList<Integer> right = NSR(heights);
        ArrayList<Integer> left = NSL(heights);

        ArrayList<Integer> widths = new ArrayList<>();
        for (int i = 0; i < heights.length; i++) {
            widths.add(right.get(i) - left.get(i) - 1);
        }

        ArrayList<Integer> Area = new ArrayList<>();
        for (int i = 0; i < heights.length; i++) {
            Area.add(heights[i] * widths.get(i));
        }

        return Collections.max(Area);
    }

    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) return 0;

        int cols = matrix[0].length;
        int rows = matrix.length;

        int[] heights = new int[cols];

        for (int j = 0; j < cols; j++) {
            heights[j] = matrix[0][j] - '0';
        }

        int mx = MAH(heights);

        for (int i = 1; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == '0') {
                    heights[j] = 0;
                } else {
                    heights[j] += 1;
                }
            }
            mx = Math.max(mx, MAH(heights));
        }

        return mx;
    }
}
