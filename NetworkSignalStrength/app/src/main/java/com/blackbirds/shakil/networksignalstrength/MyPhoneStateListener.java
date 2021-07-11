package com.blackbirds.shakil.networksignalstrength;

import android.telephony.PhoneStateListener;
import android.telephony.SignalStrength;
import android.widget.TextView;

public class MyPhoneStateListener extends PhoneStateListener {
    public int signalStrengthValue;

    TextView textView;

    public MyPhoneStateListener(TextView textView) {
        this.textView = textView;
    }

    public void onSignalStrengthsChanged(SignalStrength signalStrength) {
        super.onSignalStrengthsChanged(signalStrength);
        if (signalStrength.isGsm()) {
            if (signalStrength.getGsmSignalStrength() != 99)
                signalStrengthValue = signalStrength.getGsmSignalStrength() * 2 - 113;
            else
                signalStrengthValue = signalStrength.getGsmSignalStrength();
        } else {
            signalStrengthValue = signalStrength.getCdmaDbm();
        }
        textView.setText("Signal Strength : " + signalStrengthValue);
    }
}
