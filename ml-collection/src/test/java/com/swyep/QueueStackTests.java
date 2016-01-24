package com.swyep;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class QueueStackTests {

    private Stack<Integer> integetStack;
    private Queue<Integer> integerQueue;

    @Before
    public void setup() {
        integetStack = new ArrayStackImpl<>();
        integerQueue = new ArrayQueueImpl<>();
    }

    @Test
    public void testStack() {

        integetStack.push(17);
        integetStack.push(42);
        integetStack.push(88);
        assertEquals(Integer.valueOf(88), Integer.valueOf(integetStack.pop()));
        assertEquals(Integer.valueOf(42), Integer.valueOf(integetStack.pop()));
        assertEquals(Integer.valueOf(17), Integer.valueOf(integetStack.peek()));
        assertEquals(Integer.valueOf(17), Integer.valueOf(integetStack.pop()));

    }

    @Test
    public void testQueue() {

        integerQueue.enqueue(17);
        integerQueue.enqueue(42);
        integerQueue.enqueue(88);
        assertEquals(Integer.valueOf(17), Integer.valueOf(integerQueue.dequeue()));
        assertEquals(Integer.valueOf(42), Integer.valueOf(integerQueue.dequeue()));
        assertEquals(Integer.valueOf(88), Integer.valueOf(integerQueue.peek()));
        assertEquals(Integer.valueOf(88), Integer.valueOf(integerQueue.dequeue()));
    }

}