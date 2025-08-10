class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;

        List<Integer> result = new ArrayList<>();

        if(n == 1){
            result.add(nums[0]);
            return result;
        }

        int count1 = 0, count2 = 0;
        int majEle1 = 0, majEle2 = 0;

        for(int num: nums){
            if(num == majEle1){
                count1++;
            }else if(num == majEle2){
                count2++;
            }else if(count1 == 0){
                majEle1 = num;
                count1 = 1;
            }else if(count2 == 0){
                majEle2  = num;
                count2 = 1;
            }else{
                count1--;
                count2--;
            }
        }

int freq1 = 0;
int freq2 = 0;

       for(int num : nums){
            if(num == majEle1){
                freq1++;
            }else if(num == majEle2){
                freq2++;
            }
       }

       if(freq1 > n/3){
            result.add(majEle1);
       }
       
        if(freq2 > n/3){
            result.add(majEle2);
       }


       return result;
    }
}