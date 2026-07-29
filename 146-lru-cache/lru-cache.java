class LRUCache {
    
    class Node {
        int key;
        int value;
        Node prev;
        Node next;

        Node(int key , int value){
            this.key = key;
            this.value = value;
        }
    }   

    Node head = new Node(-1,-1);
    Node tail = new Node(-1,-1);

    int cap = 0;

    HashMap<Integer, Node> map = new HashMap<>();

    public LRUCache(int capacity){
        cap = capacity;
        head.next = tail;
        tail.prev = head;
    }
    

    public void addToTail(Node newNode){
        Node prevNode = tail.prev;
        newNode.next = tail;
        newNode.prev = prevNode;

        prevNode.next = newNode;
        tail.prev = newNode;
    }

    public void removeNode(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }


    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }

        removeNode(map.get(key));
        addToTail(map.get(key));
        return map.get(key).value;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            removeNode(map.get(key));
        }

        Node newNode = new Node(key,value);
        map.put(key,newNode);

        if (map.size() > cap){
            map.remove(head.next.key);
            removeNode(head.next);
        }
        addToTail(newNode);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */