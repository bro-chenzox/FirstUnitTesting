package com.palchak.sergey.firstunittesting

import com.google.common.truth.Truth.assertThat
import org.junit.Test

class RegistrationUtilTest {

    @Test
    fun `empty userName returns false`() {
        val result = RegistrationUtil.validateRegistrationInput(
            "",
            "123",
            "123"
        )
        assertThat(result).isFalse()
    }

    @Test
    fun `valid userName and correctly repeats password returns true`() {
        val result = RegistrationUtil.validateRegistrationInput(
            "Sergey",
            "123",
            "123"
        )
        assertThat(result).isTrue()
    }

    @Test
    fun `userName already exists returns false`() {
        val result = RegistrationUtil.validateRegistrationInput(
            "Carl",
            "123",
            "123"
        )
        assertThat(result).isFalse()
    }

    @Test
    fun `empty password returns false`() {
        val result = RegistrationUtil.validateRegistrationInput(
            "Sergey",
            "",
            ""
        )
        assertThat(result).isFalse()
    }

    @Test
    fun `confirmed password differs from the real one returns false`() {
        val result = RegistrationUtil.validateRegistrationInput(
            "Sergey",
            "123",
            "124"
        )
        assertThat(result).isFalse()
    }

    @Test
    fun `password contains less than two digits returns false`() {
        val result = RegistrationUtil.validateRegistrationInput(
            "Sergey",
            "abcdefg1",
            "abcdefg1"
        )
        assertThat(result).isFalse()
    }
}