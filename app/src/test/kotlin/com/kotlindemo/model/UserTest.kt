package com.kotlindemo.model

import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotEquals
import org.junit.Before
import org.junit.Test

class UserTest {

    val EXPECTED_FIRST_EMAIL: String = "Satesh"
    val EXPECTED_LAST_PASSWORD: String = "Anumala"

    protected lateinit var user: User

    @Before
    fun setUp() {

        user = User(EXPECTED_FIRST_EMAIL, EXPECTED_LAST_PASSWORD)
    }

    @After
    fun tearDown() {
    }

    @Test
    fun isDataValid() {

    }

    @Test
    fun getValidationCode() {

    }

    @Test
    fun getEmail() {

        assertNotEquals(user.getEmail(), "OK")
        assertEquals(user.getEmail(), EXPECTED_FIRST_EMAIL)
    }

    @Test
    fun setEmail() {
    }

    @Test
    fun getPassword() {
    }

    @Test
    fun setPassword() {
    }
}