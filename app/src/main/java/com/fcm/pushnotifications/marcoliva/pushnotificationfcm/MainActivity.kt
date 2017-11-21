package com.fcm.pushnotifications.marcoliva.pushnotificationfcm

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.google.firebase.iid.FirebaseInstanceId
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var TAG  = "Main Activity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //Get the token
        //Use the token only for received a push notification this device
        var token = FirebaseInstanceId.getInstance().token
        Log.d(TAG,"Token : "+token)
        var bodyMessage= intent.getStringExtra("Notification")
        if(bodyMessage != null){
            body_text_view.text = bodyMessage
        }

    }
}
