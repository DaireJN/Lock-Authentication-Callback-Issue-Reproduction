package com.ineqe.lockexample

import android.content.Intent
import android.util.Log
import com.auth0.android.lock.AuthenticationCallback
import com.auth0.android.lock.utils.LockException
import com.auth0.android.result.Credentials

object AuthenticationCallbackImpl :
    AuthenticationCallback() {

    override fun onEvent(event: Int, data: Intent) {
        super.onEvent(event, data)
        Log.d("AuthenticationCallback", "eventcalled")
    }


    override fun onError(error: LockException) {

    }

    override fun onAuthentication(credentials: Credentials) {

    }

    override fun onCanceled() {

    }

}
