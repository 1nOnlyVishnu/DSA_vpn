class Solution {
    public int minPartitions(String n) {
        char[] array = n.toCharArray();
        int count = 0;

        while(true){
            boolean changed = false;

            for (int i = 0; i < array.length; i += 1){
                if ( array[i] != '0'){
                    array[i]--;
                    changed = true;
                }
            }

            if(!changed){
                break;
            }

            count += 1;
            
        }

        return count;

    }
}