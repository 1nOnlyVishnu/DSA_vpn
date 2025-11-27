class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {

        int[] ans = new int[nums.length - k + 1];
        Deque<Integer> dq = new LinkedList<>();


        int i=0;
        int j = 0;
        while(j<nums.length){
            //do some calculations
            if(dq.size() ==0){
                dq.add(nums[j]);

            }
            else{
                while(dq.size() > 0 && dq.peekLast() < nums[j]){
                   dq.removeLast();
                }
                dq.add(nums[j]);
            }

            // now move j pointer
            if(j - i + 1 < k) j++;
            // if we hit the window size
            else if(j - i + 1 == k){
                // answer -> calculation;
                ans[i] = dq.peek();
                // slide the window ---> 2 work to do...
                // i) calculation
                if(nums[i] == dq.peek()){
                    dq.removeFirst();
                }
                // ii) now slide the pointer
                i++;
                j++;
            }
        }
        return ans;



        }


    }
