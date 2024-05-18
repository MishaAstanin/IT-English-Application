package com.example.application.auth

import android.provider.ContactsContract.CommonDataKinds.Email

class UserResults() {
    private var email: String? = null
    private var countTest: Int? = null
    private var countAnswer: Int? = null

    constructor(email: String, countTest: Int, countAnswer: Int) : this() {
        this.email = email
        this.countTest = countTest
        this.countAnswer = countAnswer
    }

    fun getEmail(): String? {
        return email
    }
    fun setEmail(value: String?) {
        this.email = value
    }
    fun getCountTest(): Int? {
        return countTest
    }
    fun setCountTest(value: Int?) {
        this.countTest = value
    }
    fun getCountAnswer(): Int? {
        return countAnswer
    }
    fun setCountAnswer(value: Int?) {
        this.countAnswer = value
    }
}