package com.fcm.pushnotifications.marcoliva.pushnotificationfcm

import android.util.Log
import com.google.firebase.iid.FirebaseInstanceId
import com.google.firebase.iid.FirebaseInstanceIdService

/**
 * Created by ThinkSoft on 16/11/2017.
 */
class MyFirebaseInstanceIDService : FirebaseInstanceIdService() {
    private var TAG = "MyFirebaseInstanceIDService"

    override fun onTokenRefresh() {
        //Get updated token
        var refreshedToken = FirebaseInstanceId.getInstance().token
        Log.d(TAG,"New Token : "+refreshedToken)

    }
}