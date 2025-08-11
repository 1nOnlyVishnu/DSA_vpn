class MyStack {

    Queue<Integer> queue;

    public MyStack() {
        queue = new LinkedList<>();
    }
    
    public void push(int x) {
        queue.add(x);

        for(int i= 1 ;i<queue.size();i++){
            queue.add(queue.remove());
        }
  
    }
    
    public int pop() {
        return queue.remove();
        
    }
    
    public int top() {
        return queue.peek();
        
    }
    
    public boolean empty() {
        return queue.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();

 c++ code 
 class MyStack {
public:

    queue<int> que1;
    queue<int> que2;

    MyStack() {

        
    }
    
    void push(int x) {
        que2.push(x);

        while(!que1.empty()){
            que2.push(que1.front());
            que1.pop();

        }

        swap(que1,que2);
    }
    
    int pop() {
        int ele = que1.front();
        que1.pop();
        return ele;
    }
    
    int top() {
        return que1.front();
        
    }
    
    bool empty() {
       return que1.empty();
    }
};

 */