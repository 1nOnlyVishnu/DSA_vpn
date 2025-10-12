class Pair{
    int num;
    int span;

    Pair(int num,int span){
        this.num = num;
        this.span = span;
    }
}
class StockSpanner {

    Stack<Pair> st;
   

    public StockSpanner() {
        st = new Stack<>();
    }
    
    public int next(int price) {
        int span = 1;

        while(st.size() > 0 && st.peek().num <= price){
            span = span + st.peek().span;
            st.pop();
        }

        st.push(new Pair(price,span));
        return span;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */