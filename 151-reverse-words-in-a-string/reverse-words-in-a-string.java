class Solution {
    public String reverseWords(String s) {
       char[] str =  s.toCharArray();

       int start = 0;
       int end = str.length - 1;

       reverse(str,start,end);

      reverseEachWord(str);

      return cleanSpaces(str);
    }

    public void reverse(char[] arr,int start,int end){
            while(start < end){
                char temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;
                start++;
                end--;
            }
    }

    public void reverseEachWord(char[] arr){
            int start = 0;
            int end = 0;
            int n = arr.length;

            while(start < n){
                while(start < n && arr[start] == ' ') start++;
                end = start;
                while (end < n && arr[end] != ' ') end++;        // move to end of word
                reverse(arr, start, end - 1);                    // reverse that word
                start = end;
            }
    }

    public String cleanSpaces(char[] arr){
        int  n = arr.length;
        StringBuilder sb = new StringBuilder();
        int i = 0;

        while (i < n) {
            while (i < n && arr[i] == ' ') i++;             // skip leading spaces
            if (i >= n) break;

            if (sb.length() > 0) sb.append(' ');            // add single space

            while (i < n && arr[i] != ' ') {
                sb.append(arr[i++]);                        // append word
            }
        }

        return sb.toString();
    }
}