import java.util.Collections;

class Pair{
    int num;
    int index;

    Pair(int num,int index){
        this.num = num;
        this.index = index;
    }
}

class Solution {

    public ArrayList<Integer> reverseArrayList(ArrayList<Integer> ans){
        int i= 0;
        int j = ans.size() - 1;

        while(i<j){
            int temp = ans.get(i);
            ans.set(i,ans.get(j));
            ans.set(j,temp);
            i++;
            j--;
        }

        return ans;
    }

    public ArrayList<Integer> NSR(int[] arr){
        int n = arr.length;
        Stack<Pair> st = new Stack<>();
        ArrayList<Integer> ans = new ArrayList<>();

        for(int i = n-1;i>=0;i--){
            if(st.size() == 0){
                ans.add(n);
            }else if(st.size() > 0 && st.peek().num< arr[i]){
                ans.add(st.peek().index);
            }else if(st.size() > 0 && st.peek().num >= arr[i]){
                while(st.size() > 0 && st.peek().num >= arr[i]){
                    st.pop();
                }
                if(st.size() == 0){
                    ans.add(n);
                }else {
                    ans.add(st.peek().index);
                }
            }
            st.push(new Pair(arr[i],i));
        }

        return reverseArrayList(ans);
    }

    public ArrayList<Integer> NSL(int[] arr){
        int n = arr.length;
        ArrayList<Integer> ans = new ArrayList<>();

        Stack<Pair> st = new Stack<>();

        for(int i = 0;i<n;i++){
            if(st.size() == 0){
                ans.add(-1);
            }else if(st.size() > 0 && st.peek().num<arr[i]){
                ans.add(st.peek().index);
            }else if(st.size() > 0 && st.peek().num >= arr[i]){
                while(st.size() > 0 && st.peek().num >= arr[i]){
                    st.pop();
                }
                if(st.size() == 0){
                    ans.add(-1);
                }else{
                    ans.add(st.peek().index);
                }
            }
            st.push(new Pair(arr[i],i));
        }

        return ans;
    }




    public int largestRectangleArea(int[] heights) {
        ArrayList<Integer> hv = new ArrayList<>();
        ArrayList<Integer> widths = new ArrayList<>();

        ArrayList<Integer> right = NSR(heights);
        ArrayList<Integer> left = NSL(heights);

        for(int i = 0;i<right.size();i++){
                widths.add(right.get(i) - left.get(i) - 1); 
        }

        ArrayList<Integer> Area = new ArrayList<>();

        for(int num:heights){
            hv.add(num);
        }

        for(int i = 0;i<widths.size() ;i++){
            Area.add(hv.get(i) * widths.get(i));
        }

       return Collections.max(Area);
    }
}