class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
       HashSet<Integer> set1 = new HashSet<>();
       ArrayList<Integer> result = new ArrayList<>();

       for ( int num : nums1){
            set1.add(num); //{1,2}
       }

       for (int num : nums2){
            if(set1.contains(num)){
                    result.add(num);

                    set1.remove(num);
       }
    }

int[] ans = new int[result.size()];
int index = 0;

for(Integer num : result){
    ans[index++] = num;
}

return ans;

    }
}