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

    @Test
    public void testEqual() {
        Stack<Integer> s1 = new ArrayStackImpl<>();
        Stack<Integer> s2 = new ArrayStackImpl<>();
        Queue<Integer> q1 = new ArrayQueueImpl<>();
        Queue<Integer> q2 = new ArrayQueueImpl<>();

        s1.push(17);
        s1.push(42);
        s1.push(88);

        s2.push(17);
        s2.push(42);
        s2.push(88);

        q1.enqueue(17);
        q1.enqueue(42);
        q1.enqueue(88);

        q2.enqueue(42);
        q2.enqueue(88);

        assertFalse(s1.equals(q1));
        assertTrue(s1.equals(s2));
        assertTrue(s2.equals(s1));
        assertFalse(q1.equals(q2));
        assertFalse(q2.equals(q1));

        s1.pop();
        q1.dequeue();

        assertFalse(s1.equals(s2));
        assertFalse(s2.equals(s1));
        assertTrue(q1.equals(q2));
        assertTrue(q2.equals(q1));
    }

}
