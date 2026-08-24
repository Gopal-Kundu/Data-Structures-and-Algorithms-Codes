//https://leetcode.com/problems/design-circular-queue/

//Messy code but workable 100% beats
class MyCircularQueue {
    int k; int[] queue; int rear = -1, front = -1;
    public MyCircularQueue(int K) {
        queue = new int[K];
        k = K;
    }

    public boolean enQueue(int value) {
        if(rear == k-1 && front == 0) return false;
        if(rear == k-1) rear = -1;
        if(rear == -1 && front == -1){
            rear++;
            front++;
            queue[rear] = value;
            return true;
        }
        if(rear+1 == front) return false;
        rear++;
        queue[rear] = value;
        return true;
    }

    public boolean deQueue() {
        if(front == -1) return false;
        if(front == rear){
            front = -1;
            rear = -1;
            return true;
        }
        if(front == k-1){
            front = -1;
        }
        front++;
        return true;
    }
    
    public int Front() {
        return front == -1 ? -1 : queue[front];
    }
    
    public int Rear() {
        return rear == -1 ? -1 : queue[rear];
    }
    
    public boolean isEmpty() {
        return front == -1;
    }
    
    public boolean isFull() {
        if(rear == k-1){
            if(front == 0) return true;
            else return false;
        } 
        return rear+1 == front;
    }
}

--------------------------------------------------------------------
// Cleaner version.
class MyCircularQueue {
    int[] queue;
    int front, rear, size, capacity;

    public MyCircularQueue(int k) {
        queue = new int[k];
        capacity = k;
        front = 0;
        rear = -1;
        size = 0;
    }

    public boolean enQueue(int value) {
        if (isFull()) return false;
        rear = (rear + 1) % capacity;
        queue[rear] = value;
        size++;
        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) return false;
        front = (front + 1) % capacity;
        size--;
        return true;
    }

    public int Front() {
        return isEmpty() ? -1 : queue[front];
    }

    public int Rear() {
        return isEmpty() ? -1 : queue[rear];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }
}
