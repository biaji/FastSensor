package com.xie.xuan.fastsensor;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.KeyEvent;

public class MediaButtonReceiver extends BroadcastReceiver {

    public static final String KEYCODE_EXTRA = "MediaKey";

    public MediaButtonReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {

        if (!intent.getAction().equals(Intent.ACTION_MEDIA_BUTTON)) {
            return;
        }


        KeyEvent kv = (KeyEvent) intent.getParcelableExtra(Intent.EXTRA_KEY_EVENT);

        if (kv == null) {
            return;
        }


        if (kv.getKeyCode() != KeyEvent.KEYCODE_HEADSETHOOK) {
            Log.d(MainActivity.TAG, "Got Key:" + kv.getKeyCode() + " ignore");
            Intent serviceIntent = new Intent(context, SensorService.class);
            serviceIntent.putExtra("", kv.getKeyCode());
            context.startService(intent);
            return;
        }


    }
}
