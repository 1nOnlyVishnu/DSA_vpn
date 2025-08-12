class MyQueue {

    Stack<Integer> input = new Stack<>();
    Stack<Integer> output = new Stack<>();
    int peekEle = -1;


    public MyQueue() {
        
    }
    
    public void push(int x) {
        if(input.isEmpty()){
            peekEle = x;
        }
        input.push(x); 
        
    }
    
    public int pop() {
        if(output.isEmpty()){
            //put input stack elements to output stack 

            while(!input.isEmpty()){
                output.push(input.pop());
            }
        }

        int ele = output.peek();
        output.pop();
        return ele;
    }
    
    public int peek() {
        if(output.isEmpty()){
            return peekEle;
        }
        return output.peek();
    }
    
    public boolean empty() {
        if(input.isEmpty() && output.isEmpty())
            return true;
        else
            return false; 
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */