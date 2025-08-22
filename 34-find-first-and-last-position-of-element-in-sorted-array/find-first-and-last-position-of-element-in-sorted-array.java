class Solution {
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        int start = 0;
        int end = n - 1;
        
int first = -1;
int last = -1;

for(int i = 0;i<n;i++){
    if(nums[i] == target){
        if(first == -1){
            first = i;
        }
        last = i;
    }
}

int[] ans = {first,last};

return ans;
    }
}