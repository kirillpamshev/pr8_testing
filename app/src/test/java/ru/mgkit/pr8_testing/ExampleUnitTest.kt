package ru.mgkit.pr8_testing

import org.junit.Test

import org.junit.Assert.*

class ExampleUnitTest {
    @Test
    fun testConverting10_2() {
        assertEquals("10", Convert.format("2", 2))
        assertEquals("f", Convert.format("15", 16))
        assertEquals("12", Convert.format("10", 8))
        assertEquals("ОШИБКА!", Convert.format("", 2))
    }
}