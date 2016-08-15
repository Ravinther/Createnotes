package com.flurry.android.monolithic.sdk.impl;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* renamed from: com.flurry.android.monolithic.sdk.impl.i */
public final class C0124i {
    String f533a;
    private int f534b;
    private long f535c;
    private String f536d;
    private String f537e;
    private Throwable f538f;

    public C0124i(int i, long j, String str, String str2, String str3, Throwable th) {
        this.f534b = i;
        this.f535c = j;
        this.f533a = str;
        this.f536d = str2;
        this.f537e = str3;
        this.f538f = th;
    }

    public final byte[] m609a() {
        Closeable dataOutputStream;
        byte[] bytes;
        Throwable th;
        try {
            OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            dataOutputStream = new DataOutputStream(byteArrayOutputStream);
            try {
                dataOutputStream.writeShort(this.f534b);
                dataOutputStream.writeLong(this.f535c);
                dataOutputStream.writeUTF(this.f533a);
                dataOutputStream.writeUTF(this.f536d);
                dataOutputStream.writeUTF(this.f537e);
                if (this.f538f != null) {
                    if (this.f533a == "uncaught") {
                        dataOutputStream.writeByte(3);
                    } else {
                        dataOutputStream.writeByte(2);
                    }
                    dataOutputStream.writeByte(2);
                    StringBuilder stringBuilder = new StringBuilder("");
                    String property = System.getProperty("line.separator");
                    for (Object append : this.f538f.getStackTrace()) {
                        stringBuilder.append(append);
                        stringBuilder.append(property);
                    }
                    if (this.f538f.getCause() != null) {
                        stringBuilder.append(property);
                        stringBuilder.append("Caused by: ");
                        for (Object append2 : this.f538f.getCause().getStackTrace()) {
                            stringBuilder.append(append2);
                            stringBuilder.append(property);
                        }
                    }
                    bytes = stringBuilder.toString().getBytes();
                    dataOutputStream.writeInt(bytes.length);
                    dataOutputStream.write(bytes);
                } else {
                    dataOutputStream.writeByte(1);
                    dataOutputStream.writeByte(0);
                }
                dataOutputStream.flush();
                bytes = byteArrayOutputStream.toByteArray();
                bj.m596a(dataOutputStream);
            } catch (IOException e) {
                try {
                    bytes = new byte[0];
                    bj.m596a(dataOutputStream);
                    return bytes;
                } catch (Throwable th2) {
                    th = th2;
                    bj.m596a(dataOutputStream);
                    throw th;
                }
            }
        } catch (IOException e2) {
            dataOutputStream = null;
            bytes = new byte[0];
            bj.m596a(dataOutputStream);
            return bytes;
        } catch (Throwable th3) {
            Throwable th4 = th3;
            dataOutputStream = null;
            th = th4;
            bj.m596a(dataOutputStream);
            throw th;
        }
        return bytes;
    }
}
