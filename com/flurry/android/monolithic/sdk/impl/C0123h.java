package com.flurry.android.monolithic.sdk.impl;

import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.flurry.android.monolithic.sdk.impl.h */
public class C0123h {
    private static final String f531a;
    private File f532b;

    static {
        f531a = C0123h.class.getSimpleName();
    }

    public C0123h(File file) {
        this.f532b = file;
        bh.m584a(3, "Referrer file Name if it exists:  " + this.f532b);
    }

    public final Map m608a() {
        if (!this.f532b.exists()) {
            return null;
        }
        bh.m584a(4, "Loading referrer info from file:  " + this.f532b.getAbsolutePath());
        String a = C0123h.m606a(this.f532b);
        if (a == null) {
            return null;
        }
        bh.m584a(3, "Parsing referrer map");
        return C0123h.m607a(a);
    }

    private static String m606a(File file) {
        Closeable fileInputStream;
        StringBuffer stringBuffer;
        Throwable th;
        Throwable th2;
        try {
            fileInputStream = new FileInputStream(file);
            try {
                stringBuffer = new StringBuffer();
            } catch (Throwable th3) {
                th = th3;
                stringBuffer = null;
                try {
                    bh.m590b("Error when loading persistent file", th);
                    bj.m596a(fileInputStream);
                    if (stringBuffer == null) {
                        return null;
                    }
                    return stringBuffer.toString();
                } catch (Throwable th4) {
                    th2 = th4;
                    bj.m596a(fileInputStream);
                    throw th2;
                }
            }
            try {
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = fileInputStream.read(bArr);
                    if (read <= 0) {
                        break;
                    }
                    stringBuffer.append(new String(bArr, 0, read));
                }
                bj.m596a(fileInputStream);
            } catch (Throwable th5) {
                th = th5;
                bh.m590b("Error when loading persistent file", th);
                bj.m596a(fileInputStream);
                if (stringBuffer == null) {
                    return stringBuffer.toString();
                }
                return null;
            }
        } catch (Throwable th6) {
            fileInputStream = null;
            th2 = th6;
            bj.m596a(fileInputStream);
            throw th2;
        }
        if (stringBuffer == null) {
            return stringBuffer.toString();
        }
        return null;
    }

    private static Map m607a(String str) {
        Map hashMap = new HashMap();
        String[] split = str.split("&");
        int length = split.length;
        for (int i = 0; i < length; i++) {
            String[] split2 = split[i].split("=");
            if (split2.length != 2) {
                bh.m584a(3, "Invalid referrer Element: " + split[i] + " in referrer tag " + str);
            } else {
                String decode = URLDecoder.decode(split2[0]);
                String decode2 = URLDecoder.decode(split2[1]);
                if (hashMap.get(decode) == null) {
                    hashMap.put(decode, new ArrayList());
                }
                ((List) hashMap.get(decode)).add(decode2);
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        if (hashMap.get("utm_source") == null) {
            stringBuilder.append("Campaign Source is missing.\n");
        }
        if (hashMap.get("utm_medium") == null) {
            stringBuilder.append("Campaign Medium is missing.\n");
        }
        if (hashMap.get("utm_campaign") == null) {
            stringBuilder.append("Campaign Name is missing.\n");
        }
        if (stringBuilder.length() > 0) {
            bh.m584a(5, stringBuilder.toString());
        }
        return hashMap;
    }
}
