package com.blackbirds.shakil.networksignalstrength;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TelephonyManager telephonyManager;
    MyPhoneStateListener psListener;
    public TextView txtSignalStr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtSignalStr = findViewById(R.id.txtStrength);
        psListener = new MyPhoneStateListener(txtSignalStr);
        telephonyManager = (TelephonyManager)this.getSystemService(Context.TELEPHONY_SERVICE);
        telephonyManager.listen(psListener, PhoneStateListener.LISTEN_SIGNAL_STRENGTHS);
    }
}