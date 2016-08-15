package com.flurry.android.monolithic.sdk.impl;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Map;
import java.util.Map.Entry;

/* renamed from: com.flurry.android.monolithic.sdk.impl.j */
public final class C0125j {
    String f539a;
    long f540b;
    boolean f541c;
    boolean f542d;
    long f543e;
    private int f544f;
    private Map f545g;

    public C0125j(int i, String str, Map map, long j) {
        this.f544f = i;
        this.f539a = str;
        this.f545g = map;
        this.f540b = j;
        this.f541c = false;
        if (this.f541c) {
            this.f542d = false;
        } else {
            this.f542d = true;
        }
    }

    public final byte[] m610a() {
        byte[] toByteArray;
        Closeable closeable;
        Throwable th;
        Closeable dataOutputStream;
        try {
            OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            dataOutputStream = new DataOutputStream(byteArrayOutputStream);
            try {
                dataOutputStream.writeShort(this.f544f);
                dataOutputStream.writeUTF(this.f539a);
                if (this.f545g == null) {
                    dataOutputStream.writeShort(0);
                } else {
                    dataOutputStream.writeShort(this.f545g.size());
                    for (Entry entry : this.f545g.entrySet()) {
                        dataOutputStream.writeUTF(bj.m595a((String) entry.getKey()));
                        dataOutputStream.writeUTF(bj.m595a((String) entry.getValue()));
                    }
                }
                dataOutputStream.writeLong(this.f540b);
                dataOutputStream.writeLong(this.f543e);
                dataOutputStream.flush();
                toByteArray = byteArrayOutputStream.toByteArray();
                bj.m596a(dataOutputStream);
            } catch (IOException e) {
                closeable = dataOutputStream;
                try {
                    toByteArray = new byte[0];
                    bj.m596a(closeable);
                    return toByteArray;
                } catch (Throwable th2) {
                    th = th2;
                    dataOutputStream = closeable;
                    bj.m596a(dataOutputStream);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                bj.m596a(dataOutputStream);
                throw th;
            }
        } catch (IOException e2) {
            closeable = null;
            toByteArray = new byte[0];
            bj.m596a(closeable);
            return toByteArray;
        } catch (Throwable th4) {
            dataOutputStream = null;
            th = th4;
            bj.m596a(dataOutputStream);
            throw th;
        }
        return toByteArray;
    }
}
