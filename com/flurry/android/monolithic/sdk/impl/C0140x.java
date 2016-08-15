package com.flurry.android.monolithic.sdk.impl;

import android.os.Looper;
import java.io.Closeable;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.UUID;

/* renamed from: com.flurry.android.monolithic.sdk.impl.x */
public class C0140x {
    static final String f590a;
    String f591b;
    long f592c;
    int f593d;
    File f594e;

    static {
        f590a = C0140x.class.getSimpleName();
    }

    public C0140x() {
        this.f591b = null;
        this.f592c = -1;
        this.f593d = -1;
        this.f594e = null;
        this.f591b = UUID.randomUUID().toString();
        this.f594e = am.f442a.f443b.getFileStreamPath(".flurrydatasenderblock." + this.f591b);
    }

    public C0140x(String str) {
        this.f591b = null;
        this.f592c = -1;
        this.f593d = -1;
        this.f594e = null;
        this.f591b = str;
        this.f594e = am.f442a.f443b.getFileStreamPath(".flurrydatasenderblock." + this.f591b);
    }

    public final boolean m632a(byte[] bArr) {
        Closeable dataOutputStream;
        Throwable th;
        Throwable th2;
        boolean z = false;
        if (Looper.myLooper() == Looper.getMainLooper()) {
            bh.m584a(6, "setData(byte[]) running on the MAIN thread!");
        }
        bh.m584a(4, "Writing FlurryDataSenderBlockInfo: " + this.f594e.getAbsolutePath());
        try {
            if (bd.m579a(this.f594e)) {
                dataOutputStream = new DataOutputStream(new FileOutputStream(this.f594e));
                try {
                    int length = bArr.length;
                    dataOutputStream.writeShort(length);
                    dataOutputStream.write(bArr);
                    dataOutputStream.writeShort(0);
                    z = true;
                    this.f593d = length;
                    this.f592c = System.currentTimeMillis();
                    bj.m596a(dataOutputStream);
                } catch (Throwable th3) {
                    th = th3;
                    try {
                        bh.m590b("", th);
                        bj.m596a(dataOutputStream);
                        return z;
                    } catch (Throwable th4) {
                        th2 = th4;
                        bj.m596a(dataOutputStream);
                        throw th2;
                    }
                }
            }
            bj.m596a(null);
        } catch (Throwable th5) {
            th2 = th5;
            dataOutputStream = null;
            bj.m596a(dataOutputStream);
            throw th2;
        }
        return z;
    }

    public final byte[] m633a() {
        Throwable th;
        Throwable th2;
        byte[] bArr = null;
        if (Looper.myLooper() == Looper.getMainLooper()) {
            bh.m584a(6, "getData() running on the MAIN thread!");
        }
        if (this.f594e.exists()) {
            bh.m584a(4, "Reading FlurryDataSenderBlockInfo: " + this.f594e.getAbsolutePath());
            Closeable dataInputStream;
            try {
                dataInputStream = new DataInputStream(new FileInputStream(this.f594e));
                try {
                    int readUnsignedShort = dataInputStream.readUnsignedShort();
                    if (readUnsignedShort == 0) {
                        bj.m596a(dataInputStream);
                    } else {
                        bArr = new byte[readUnsignedShort];
                        dataInputStream.readFully(bArr);
                        dataInputStream.readUnsignedShort();
                        bj.m596a(dataInputStream);
                    }
                } catch (Throwable th3) {
                    th = th3;
                    try {
                        bh.m590b("Error when loading persistent file", th);
                        bj.m596a(dataInputStream);
                        return bArr;
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
        bh.m584a(4, "Agent cache file doesn't exist.");
        return bArr;
    }
}
