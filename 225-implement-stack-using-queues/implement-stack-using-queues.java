class MyStack {

    Queue<Integer> queue = new LinkedList<>();

    public MyStack() {

    }
    
    public void push(int x) {
        queue.offer(x); //adds element from the rear of the queue bruh


        for(int i = 0;i<queue.size()-1;i++){
            queue.offer(queue.poll());
            
        }

    }
    
    public int pop() {
        int x = queue.element();
        queue.poll();
        return x;
    }
    
    public int top() {
        return queue.peek();
    }
    
    public boolean empty() {
        if(queue.isEmpty())
            return true;
        else 
            return false;
    
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();

~~~~~~~~~~~~~~~ c++ code ~~~~~~~~~~~~~~~~~~~~
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

~~~~~~~~~~~~  Java Code for implementing stacks using Two queues ~~~~~~~~~

class MyStack {

    Queue<Integer> queue1 = new LinkedList<>();
    Queue<Integer> queue2 = new LinkedList<>();

    public MyStack() {

    }
    
    public void push(int x) {
        queue2.offer(x); //adds element from the rear of the queue bruh

        while(!queue1.isEmpty()){
           queue2.offer(queue1.element()); // element() is like peek()
           queue1.poll(); //poll() is like remove() or pop()
        }

        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;
    }
    
    public int pop() {
        int x = queue1.element();
        queue1.poll();
        return x;
    }
    
    public int top() {
        return queue1.peek();
    }
    
    public boolean empty() {
        if(queue1.isEmpty())
            return true;
        else 
            return false;
    
    }
}

 */