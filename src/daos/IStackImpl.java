/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;
/**
 *
 * @author Maurice
 */
public class IStackImpl implements IStack {
    private int[] myStack;
    private int stackSize;
    private final int BAZESIZE = 5;

    public IStackImpl() {
        myStack = new  int[BAZESIZE];
        stackSize = 0;
    }

    @Override
    public int push(int t) {
        if (stackSize == myStack.length) {
            increaseLength();
        }
        myStack[stackSize] = t;
        stackSize++;
        return t;
    }

    @Override
    public int pop() {
        int popped = 0;
        if(stackSize !=0) {
            popped = myStack[stackSize - 1];
            myStack[stackSize - 1] = 0;
            stackSize--;
        }else{
            throw new ArrayIndexOutOfBoundsException();
        }

        return popped;
    }

    @Override
    public int peek() {
        // this method looks at something on the top of the stack
        // without removing it
        
          int peeked = 0;
        if(stackSize !=0) {
            peeked = myStack[stackSize - 1];
        }else{
            throw new ArrayIndexOutOfBoundsException();
        }
        return peeked;
    }

    @Override
    public boolean empty() {
        return myStack.length == 0;
    }

    @Override
    public int search(int t) {
        for (int position = 0; position < myStack.length; position++) {
            if (myStack[position] == t) {
                return position;
            }
        }
        return -1;
    }

    // private method to double the capacity of my initial array
    private void increaseLength() {
        int newLength = myStack.length * 2;
        int[] newStack = new int[newLength];

        for (int i = 0; i < myStack.length; i++) {
            newStack[i] = myStack[i];
        }
        myStack = newStack;
    }

    public void printTheArray() {
        for (int i = 0; i < myStack.length; i++) {
            System.out.println(myStack[i]);
        }
    }
}
