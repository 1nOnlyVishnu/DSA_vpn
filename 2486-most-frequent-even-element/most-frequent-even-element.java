//# hashMap -> store the num : count -> traverse through them -> store only even numbers -> store their frequencies -> traverse through the HashMap -> find the max freq ( num : count ) ->  i will return the key (num )-> if there's a tie, return the smallest key, or if all the keys have odd frequency , then i can return -1

class Solution {
    public int mostFrequentEven(int[] nums) {
        HashMap<Integer,Integer> freqMap = new HashMap<>();

        for(int num : nums){
            if(num % 2 == 0){
                freqMap.put(num , freqMap.getOrDefault(num,0) + 1);
            }
        }

int maxFreq = -1;
int answer = -1;

for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
    int key = entry.getKey();
    int count = entry.getValue();

    if (count > maxFreq) {
        maxFreq = count;
        answer = key;
    } else if (count == maxFreq && key < answer) {
        answer = key;
    }
}

return answer;
        
    }
}