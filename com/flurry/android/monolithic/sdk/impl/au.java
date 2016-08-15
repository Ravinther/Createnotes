package com.flurry.android.monolithic.sdk.impl;

import android.telephony.TelephonyManager;
import java.util.Arrays;

public class au {
    private static final String f473a;
    private static byte[] f474b;

    static {
        f473a = au.class.getSimpleName();
    }

    public static byte[] m559a() {
        if (f474b != null) {
            return f474b;
        }
        if (am.f442a.f443b.checkCallingOrSelfPermission("android.permission.READ_PHONE_STATE") != 0) {
            return null;
        }
        TelephonyManager telephonyManager = (TelephonyManager) am.f442a.f443b.getSystemService("phone");
        if (telephonyManager != null) {
            String deviceId = telephonyManager.getDeviceId();
            if (deviceId != null && deviceId.trim().length() > 0) {
                try {
                    byte[] b = bj.m597b(deviceId);
                    if (b == null || b.length != 20) {
                        bh.m584a(6, "sha1 is not 20 bytes long: " + Arrays.toString(b));
                    } else {
                        f474b = b;
                    }
                } catch (Exception e) {
                    bh.m584a(6, "Exception in generateHashedImei()");
                }
            }
        }
        return f474b;
    }
}
