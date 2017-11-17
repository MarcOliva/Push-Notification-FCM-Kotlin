package com.fcm.pushnotifications.marcoliva.pushnotificationfcm

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.google.firebase.iid.FirebaseInstanceId

class MainActivity : AppCompatActivity() {

    private val TAG  = this.localClassName
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //Get the token
        var token = FirebaseInstanceId.getInstance().token
        Log.d(TAG,"Token : "+token)

    }
}
