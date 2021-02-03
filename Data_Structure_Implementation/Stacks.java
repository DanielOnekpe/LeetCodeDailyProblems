package Data_Structure_Implementation;
// Methods
// Push - Add an element to the top of the stack
// Pop - Take an element off the top of the stack
// Isfull - Returns true if theres no more space in the array
// Isempty - Return true if there are no elements in the stack
// Peek - See the top element in the stack without removing it
// Size - Gets the amount of elemenets in the stack

public class Stacks {
    private int arr[];
    private int top;
    private int capacity;

    public Stacks(int size) {
        arr = new int[size];
        capacity = size;
        top = -1;
    }

    public void pussh(int element) {
        if (isFull()) {
            System.out.println("OverFlow\nProgram Terminated\n");
            System.exit(1);
        }

        System.out.println("Inserting: " + element);
        arr[++top] = element;
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack Empty");
            System.exit(1);
        }

        return arr[top--];
    }

    public int size(){
        return top + 1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == capacity - 1;
    }

    public int Peek() {
        if (isEmpty()) {
            System.out.println("Nothing to see here");
            return 0;
        }
        return arr[top];
    }
}
