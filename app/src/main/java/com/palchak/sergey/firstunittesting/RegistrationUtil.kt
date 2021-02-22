package com.palchak.sergey.firstunittesting

object RegistrationUtil {

    private val existingUsers = listOf("Peter", "Carl")

    /**
     * the input is not valid if...
     *
     * ...the userName/password is empty
     *
     * ...the userName is already taken
     *
     * ...the confirmed password is not the same as the real password
     *
     * ...the password contains less two digits
     */
    fun validateRegistrationInput(
        userName: String,
        password: String,
        confirmedPassword: String
    ): Boolean {
        return when {
            userName.isEmpty() || password.isEmpty() -> false
            userName in existingUsers -> false
            password != confirmedPassword -> false
            password.count { it.isDigit() } < 2 -> false
            else -> true
        }
    }
}