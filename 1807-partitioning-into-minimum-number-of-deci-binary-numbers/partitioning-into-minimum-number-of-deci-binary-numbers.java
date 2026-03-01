class Solution {
    public int minPartitions(String n) {

        char maxCh = '0';

        for (char ch : n.toCharArray()) {
            maxCh = (char)Math.max(maxCh, ch);
        }

        return maxCh - '0';
        // char[] array = n.toCharArray();
        // int count = 0;

        // while(true){
        //     boolean changed = false;

        //     for (int i = 0; i < array.length; i += 1){
        //         if ( array[i] != '0'){
        //             array[i]--;
        //             changed = true;
        //         }
        //     }

        //     if(!changed){
        //         break;
        //     }

        //     count += 1;
            
        // }

        // return count;

    }
}