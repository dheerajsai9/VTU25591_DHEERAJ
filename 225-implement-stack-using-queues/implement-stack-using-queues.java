import java.util.*;

class MyStack {
    private Queue<Integer> q;

    public MyStack() {
        q = new LinkedList<>();
    }
    
    // Push element x onto stack.
    public void push(int x) {
        q.offer(x);
        
        // Rotate the queue so that x becomes the front
        int size = q.size();
        for (int i = 1; i < size; i++) {
            q.offer(q.poll());
        }
    }
    
    // Removes the element on top of the stack and returns it.
    public int pop() {
        return q.poll();
    }
    
    // Get the top element.
    public int top() {
        return q.peek();
    }
    
    // Returns whether the stack is empty.
    public boolean empty() {
        return q.isEmpty();
    }
}