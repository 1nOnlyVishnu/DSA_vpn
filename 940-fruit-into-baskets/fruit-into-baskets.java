class Solution {
    public int totalFruit(int[] fruits) {
        HashMap<Integer,Integer> fruitFreqMap = new HashMap<>();

        int windowStart = 0;
        int result = 0;

        for(int windowEnd = 0;windowEnd < fruits.length;windowEnd++){
            int num = fruits[windowEnd];

            fruitFreqMap.put(num,fruitFreqMap.getOrDefault(num,0)+1);
            
            while(fruitFreqMap.size() > 2){
                fruitFreqMap.put(fruits[windowStart],fruitFreqMap.get(fruits[windowStart]) - 1);
                if(fruitFreqMap.get(fruits[windowStart]) == 0){
                    fruitFreqMap.remove(fruits[windowStart]);   
                }

                windowStart++;

            }
            result = Math.max(result,windowEnd - windowStart + 1);
        }

        return result;
    }
}