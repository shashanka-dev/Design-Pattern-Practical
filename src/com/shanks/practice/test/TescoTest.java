package com.shanks.practice.test;

import org.junit.jupiter.api.Test;
import practice.Tesco;

import static org.junit.jupiter.api.Assertions.*;

class TescoTest {

    @Test
    void test_null_case() {
        assertFalse(Tesco.validate(null, null));
    }

    @Test
    void test_empty_array_case() {
        assertTrue(Tesco.validate(new int[] {}, new int[] {}));
    }

    @Test
    void test_mismatched_input_array_size() {
        assertFalse(Tesco.validate(new int[] {1,2,3,4,5}, new int[] {1,2,3,4,51,2,3,4,5}));
    }

    @Test
    void test_case_1() {
        int[] array1 = new int [] {1,2,3,4,5};
        int[] array2 = new int [] {5,4,3,2,1};

        assertEquals(true, Tesco.validate(array1, array2));
    }

    @Test
    void test_case_2() {
        int[] array1 = new int [] {1,2,3,4,5};
        int[] array2 = new int [] {4,5,3,2,1};

        assertTrue(Tesco.validate(array1, array2));
    }

    @Test
    void test_case_3() {
        int[] array1 = new int [] {1,2,3,4,5};
        int[] array2 = new int [] {5,6,7,8,9};

        assertEquals(false, Tesco.validate(array1, array2));
    }

    @Test
    void test_case_4() {
        int[] array1 = new int [] {5,2,3,4,5};
        int[] array2 = new int [] {5,5,4,3,2};//PUS,POP,PUS,PUS,PUS,PUS,POP,POP,POP,POP

        assertEquals(true, Tesco.validate(array1, array2));
    }

    @Test
    void test_case_5() {
        int[] array1 = new int [] {1,2,3,4,5};
        int[] array2 = new int [] {3,4,5,2,1};

        assertEquals(true, Tesco.validate(array1, array2));
    }

    @Test
    void test_case_6() {
        int[] array1 = new int [] {1,2,3,4,5};
        int[] array2 = new int [] {3,4,2,5,1};

        assertEquals(false, Tesco.validate(array1, array2));
    }

    @Test
    void test_case_7() {
        int[] array1 = new int [] {1,2,3,4,5};
        int[] array2 = new int [] {4,3,1,2,5};

        assertEquals(false, Tesco.validate(array1, array2));
    }
}