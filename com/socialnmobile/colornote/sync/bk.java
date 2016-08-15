package com.socialnmobile.colornote.sync;

import android.os.Build;
import com.socialnmobile.colornote.p006a.C0148g;
import com.socialnmobile.util.p011b.p017b.C0462e;
import java.security.MessageDigest;

public final class bk {
    static String m1900a() {
        try {
            return C0148g.m669b();
        } catch (RuntimeException e) {
            return "";
        }
    }

    static String m1901a(String str) {
        int i = 1;
        String[] strArr = new String[]{Build.BRAND, Build.MANUFACTURER, Build.MODEL, Build.PRODUCT, str};
        try {
            MessageDigest instance = MessageDigest.getInstance("SHA1");
            String str2 = ":";
            StringBuffer stringBuffer = new StringBuffer();
            for (int i2 = 0; i2 < 5; i2++) {
                String str3 = strArr[i2];
                if (i != 0) {
                    i = 0;
                } else {
                    stringBuffer.append(str2);
                }
                stringBuffer.append(str3);
            }
            return (String) C0462e.f2255b.m1782c(instance.digest(stringBuffer.toString().getBytes("utf-8")));
        } catch (Throwable e) {
            throw new RuntimeException(e);
        } catch (Throwable e2) {
            throw new RuntimeException(e2);
        }
    }
}
