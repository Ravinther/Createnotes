package com.socialnmobile.colornote.sync;

import com.socialnmobile.util.p011b.p017b.C0462e;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public final class dg {
    public static String m1993a(byte[] bArr, String str) {
        try {
            Mac instance = Mac.getInstance("HMAC-SHA1", "BC");
            instance.init(new SecretKeySpec(bArr, "RAW"));
            return (String) C0462e.f2255b.m1782c(instance.doFinal(str.getBytes("UTF-8")));
        } catch (Throwable e) {
            throw new RuntimeException(e);
        } catch (Throwable e2) {
            throw new RuntimeException(e2);
        } catch (Throwable e22) {
            throw new RuntimeException(e22);
        }
    }
}
