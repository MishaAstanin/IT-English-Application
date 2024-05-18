package com.example.application.ui.notifications

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth

class NotificationsViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is notifications Fragment"
    }
    val text: LiveData<String> = _text

    val email = MutableLiveData<String>()
    fun setUserEmail() {
        if (FirebaseAuth.getInstance().currentUser != null) {
            email.value = FirebaseAuth.getInstance().currentUser!!.email
        }
    }
}