package ee.bcs.valiit.tasks.tasks;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Lesson1MathUtilTest {

    @Test
    void min() {
        assertEquals(1, Lesson1MathUtil.min(1, 5));
        assertEquals(-5, Lesson1MathUtil.min(1, -5));
        assertEquals(0, Lesson1MathUtil.min(0, 5));
    }

    @Test
    void max() {
        assertEquals(10, Lesson1MathUtil.max(5, 10));
        assertEquals(10, Lesson1MathUtil.max(10, 5));
    }

    @Test
    void abs() {
        assertEquals(1, Lesson1MathUtil.abs(-1));
        assertEquals(0, Lesson1MathUtil.abs(0));
        assertEquals(1, Lesson1MathUtil.abs(1));
    }

    @Test
    void isEven() {
        assertTrue(Lesson1MathUtil.isEven(2));
        assertFalse(Lesson1MathUtil.isEven(3));
    }

    @Test
    void min3() {
        assertEquals(1,Lesson1MathUtil.min3(1,3,5));
        assertEquals(3,Lesson1MathUtil.min3(5,3,10));
        assertEquals(5,Lesson1MathUtil.min3(10,15,5));
    }

    @Test
    void max3() {
        assertEquals(5,Lesson1MathUtil.max3(5,3,1));
        assertEquals(3,Lesson1MathUtil.max3(1,3,2));
        assertEquals(1,Lesson1MathUtil.max3(0,-1,1));
    }
}