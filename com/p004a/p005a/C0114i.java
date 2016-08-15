package com.p004a.p005a;

import android.os.Bundle;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;

/* renamed from: com.a.a.i */
public final class C0114i {
    public static String m508a(Bundle bundle) {
        StringBuilder stringBuilder = new StringBuilder();
        Object obj = 1;
        for (String str : bundle.keySet()) {
            if (obj != null) {
                obj = null;
            } else {
                stringBuilder.append("&");
            }
            stringBuilder.append(URLEncoder.encode(str) + "=" + URLEncoder.encode(bundle.getString(str)));
        }
        return stringBuilder.toString();
    }

    private static Bundle m509b(String str) {
        Bundle bundle = new Bundle();
        if (str != null) {
            for (String split : str.split("&")) {
                String[] split2 = split.split("=");
                bundle.putString(URLDecoder.decode(split2[0]), URLDecoder.decode(split2[1]));
            }
        }
        return bundle;
    }

    public static Bundle m507a(String str) {
        try {
            URL url = new URL(str.replace("fbconnect", "http"));
            Bundle b = C0114i.m509b(url.getQuery());
            b.putAll(C0114i.m509b(url.getRef()));
            return b;
        } catch (MalformedURLException e) {
            return new Bundle();
        }
    }
}
