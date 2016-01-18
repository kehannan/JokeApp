package com.udacity.gradle.builditbigger;

import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.gcm.GcmListenerService;

/**
 * Created by khannan on 1/17/16.
 */
public class MyGcmListenerService extends GcmListenerService {

    /**
     * Called when message is received.
     *
     * @param from SenderID of the sender.
     * @param data Data bundle containing message data as key/value pairs.
     *             For Set of keys use data.keySet().
     */
    @Override
    public void onMessageReceived(String from, Bundle data) {
        // Time to unparcel the bundle!
        if (!data.isEmpty()) {
            // TODO: gcm_default sender ID comes from the API console
            String senderId = getString(R.string.gcm_defaultSenderId);
            if (senderId.length() == 0) {
                Toast.makeText(this, "SenderID string needs to be set", Toast.LENGTH_LONG).show();
            }
            // Not a bad idea to check that the message is coming from your server.
            if ((senderId).equals(from)) {
                Toast.makeText(this, "Received Message", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
