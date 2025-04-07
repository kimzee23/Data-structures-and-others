import org.junit.Test;

import static org.junit.Assert.*;

public class TestMyStack {
    @Test
    public void testMyStackSize() {
        MyStack myStack = new MyStack(9);
        assertFalse(myStack.size);
        myStack.size();
        assertEquals(9, myStack.size());


    }
    @Test
    public void testMyStackIsEmpty(){
        MyStack myStack = new MyStack(9);
        assertTrue(myStack.is_empty());
    }

    @Test
    public void testIfMyStackCanPush(){
        MyStack myStack = new MyStack(9);
        assertTrue(myStack.is_empty());
        myStack.push(2);
        assertFalse(myStack.is_empty());
    }
    @Test
    public void testIfMyStackCanPop(){
        MyStack myStack = new MyStack(9);
        assertTrue(myStack.is_empty());
        myStack.push(2);
        assertFalse(myStack.is_empty());
        assertEquals(2,myStack.pop(2));
    }
    @Test
    public void testIfMyStackCanRemoveElement(){
        MyStack myStack = new MyStack(4);
        myStack.push(2);
        myStack.push(3);
        myStack.push(4);
        myStack.push(5);
        assertEquals(2, myStack.pop(2));
    }
    @Test
    public void testIfMyStackIsCanAddElement(){
        MyStack myStack = new MyStack(9);
        assertTrue(myStack.is_empty());
        myStack.is_empty();
        assertEquals(1, myStack.push(2));

    }
    @Test
    public void testIfMyStackIsCanPeekElement(){
        MyStack myStack = new MyStack(9);
        myStack.push(2);
        myStack.push(3);
        myStack.push(4);
        myStack.push(5);
        assertEquals(1, myStack.peek(1));

    }
    @Test
    public void testIfMyStackIsCanSearchElement(){
        MyStack myStack = new MyStack(9);
        myStack.push(2);
        myStack.push(3);
        myStack.push(4);
        myStack.push(5);
        myStack.push(6);
        assertEquals(3, myStack.search(4));
    }
//    @Test
//    public void testIfMyStackPushElementCanThrowExceptionWhenIsEmpty(){
//        MyStack myStack = new MyStack(9);
//        assertThrows(IllegalArgumentException.class, () -> myStack.push(10));
//    }

    @Test
    public void testIfMyStackCanFindTheMultipleOfTwo(){
        MyStack myStack = new MyStack(9);
        myStack.push(2);
        myStack.push(3);
        myStack.push(4);
        myStack.push(6);
        myStack.push(8);
        assertEquals(5, myStack.multipleOfTwo(5));
    }
    @Test
    public void testIfMyStackClearFunction(){
        MyStack myStack = new MyStack(9);
        myStack.push(2);
        myStack.push(3);
        myStack.push(4);
        myStack.clear();
        assertTrue(myStack.is_empty());
    }

}