package com.flurry.android.monolithic.sdk.impl;

import android.provider.Settings.Secure;
import android.text.TextUtils;
import java.io.Closeable;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Collections;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

public final class ax {
    private static final String f488a;
    private static final Set f489b;
    private static String f490c;

    static {
        f488a = ax.class.getSimpleName();
        Set hashSet = new HashSet();
        hashSet.add("null");
        hashSet.add("9774d56d682e549c");
        hashSet.add("dead00beef");
        f489b = Collections.unmodifiableSet(hashSet);
    }

    public static synchronized String m570a() {
        String str;
        Throwable th;
        Object obj = null;
        synchronized (ax.class) {
            if (TextUtils.isEmpty(f490c)) {
                String string = Secure.getString(am.f442a.f443b.getContentResolver(), "android_id");
                if (!TextUtils.isEmpty(string)) {
                    if (!f489b.contains(string.toLowerCase(Locale.US))) {
                        int i = 1;
                    }
                }
                if (obj == null) {
                    str = null;
                } else {
                    str = "AND" + string;
                }
                if (TextUtils.isEmpty(str)) {
                    str = m571b();
                    if (TextUtils.isEmpty(str)) {
                        str = m572c();
                        if (TextUtils.isEmpty(str)) {
                            str = "ID" + Long.toString(Double.doubleToLongBits(Math.random()) + (37 * (System.nanoTime() + ((long) (at.m557a(am.f442a.f443b).hashCode() * 37)))), 16);
                        }
                        if (!TextUtils.isEmpty(str)) {
                            File fileStreamPath = am.f442a.f443b.getFileStreamPath(".flurryb.");
                            if (bd.m579a(fileStreamPath)) {
                                Closeable dataOutputStream;
                                try {
                                    dataOutputStream = new DataOutputStream(new FileOutputStream(fileStreamPath));
                                    try {
                                        dataOutputStream.writeInt(1);
                                        dataOutputStream.writeUTF(str);
                                        bj.m596a(dataOutputStream);
                                    } catch (Throwable th2) {
                                        th = th2;
                                        try {
                                            bh.m590b("Error when saving phoneId", th);
                                            bj.m596a(dataOutputStream);
                                            f490c = str;
                                            str = f490c;
                                            return str;
                                        } catch (Throwable th3) {
                                            Throwable th4 = th3;
                                            bj.m596a(dataOutputStream);
                                            throw th4;
                                        }
                                    }
                                } catch (Throwable th5) {
                                    th4 = th5;
                                    dataOutputStream = null;
                                    bj.m596a(dataOutputStream);
                                    throw th4;
                                }
                            }
                        }
                    }
                }
                f490c = str;
            }
            str = f490c;
        }
        return str;
    }

    private static String m571b() {
        Closeable dataInputStream;
        Throwable th;
        Throwable th2;
        String str = null;
        File fileStreamPath = am.f442a.f443b.getFileStreamPath(".flurryb.");
        if (fileStreamPath != null && fileStreamPath.exists()) {
            try {
                dataInputStream = new DataInputStream(new FileInputStream(fileStreamPath));
                try {
                    if (1 == dataInputStream.readInt()) {
                        str = dataInputStream.readUTF();
                    }
                    bj.m596a(dataInputStream);
                } catch (Throwable th3) {
                    th = th3;
                    try {
                        bh.m590b("Error when loading phoneId", th);
                        bj.m596a(dataInputStream);
                        return str;
                    } catch (Throwable th4) {
                        th2 = th4;
                        bj.m596a(dataInputStream);
                        throw th2;
                    }
                }
            } catch (Throwable th5) {
                dataInputStream = str;
                th2 = th5;
                bj.m596a(dataInputStream);
                throw th2;
            }
        }
        return str;
    }

    private static String m572c() {
        Throwable th;
        Throwable th2;
        String str = null;
        File filesDir = am.f442a.f443b.getFilesDir();
        if (filesDir != null) {
            String[] list = filesDir.list(new ay());
            if (!(list == null || list.length == 0)) {
                filesDir = am.f442a.f443b.getFileStreamPath(list[0]);
                if (filesDir != null && filesDir.exists()) {
                    Closeable dataInputStream;
                    try {
                        dataInputStream = new DataInputStream(new FileInputStream(filesDir));
                        try {
                            if (46586 == dataInputStream.readUnsignedShort()) {
                                if (2 == dataInputStream.readUnsignedShort()) {
                                    dataInputStream.readUTF();
                                    str = dataInputStream.readUTF();
                                }
                            }
                            bj.m596a(dataInputStream);
                        } catch (Throwable th3) {
                            th = th3;
                            try {
                                bh.m590b("Error when loading phoneId", th);
                                bj.m596a(dataInputStream);
                                return str;
                            } catch (Throwable th4) {
                                th2 = th4;
                                bj.m596a(dataInputStream);
                                throw th2;
                            }
                        }
                    } catch (Throwable th5) {
                        dataInputStream = null;
                        th2 = th5;
                        bj.m596a(dataInputStream);
                        throw th2;
                    }
                }
            }
        }
        return str;
    }
}
