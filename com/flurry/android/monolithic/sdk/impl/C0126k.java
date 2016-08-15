package com.flurry.android.monolithic.sdk.impl;

import android.os.Build;
import android.os.Build.VERSION;
import com.flurry.android.C0115a;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.DataOutputStream;
import java.io.File;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.security.DigestOutputStream;
import java.security.MessageDigest;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/* renamed from: com.flurry.android.monolithic.sdk.impl.k */
public class C0126k {
    private static final String f550b;
    byte[] f551a;

    static {
        f550b = C0126k.class.getSimpleName();
    }

    public C0126k(String str, String str2, String str3, boolean z, long j, long j2, List list, File file, Map map, Map map2, Map map3) {
        byte[] array;
        Throwable th;
        this.f551a = null;
        Closeable closeable = null;
        Closeable dataOutputStream;
        try {
            MessageDigest bcVar = new bc();
            OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            OutputStream digestOutputStream = new DigestOutputStream(byteArrayOutputStream, bcVar);
            dataOutputStream = new DataOutputStream(digestOutputStream);
            try {
                dataOutputStream.writeShort(27);
                dataOutputStream.writeShort(0);
                dataOutputStream.writeLong(0);
                dataOutputStream.writeShort(0);
                dataOutputStream.writeShort(3);
                dataOutputStream.writeShort(C0115a.m510a());
                dataOutputStream.writeLong(System.currentTimeMillis());
                dataOutputStream.writeUTF(str);
                dataOutputStream.writeUTF(str2);
                dataOutputStream.writeShort(map.size() + 1);
                dataOutputStream.writeShort(C0121f.m601c());
                dataOutputStream.writeUTF(str3);
                if (!map.isEmpty()) {
                    for (Entry entry : map.entrySet()) {
                        dataOutputStream.writeShort(((as) entry.getKey()).f470c);
                        array = ((ByteBuffer) entry.getValue()).array();
                        dataOutputStream.writeShort(array.length);
                        dataOutputStream.write(array);
                    }
                }
                dataOutputStream.writeByte(0);
                dataOutputStream.writeBoolean(z);
                dataOutputStream.writeLong(j);
                dataOutputStream.writeLong(j2);
                dataOutputStream.writeShort(6);
                dataOutputStream.writeUTF("device.model");
                dataOutputStream.writeUTF(Build.MODEL);
                dataOutputStream.writeUTF("build.brand");
                dataOutputStream.writeUTF(Build.BRAND);
                dataOutputStream.writeUTF("build.id");
                dataOutputStream.writeUTF(Build.ID);
                dataOutputStream.writeUTF("version.release");
                dataOutputStream.writeUTF(VERSION.RELEASE);
                dataOutputStream.writeUTF("build.device");
                dataOutputStream.writeUTF(Build.DEVICE);
                dataOutputStream.writeUTF("build.product");
                dataOutputStream.writeUTF(Build.PRODUCT);
                int size = map2 != null ? map2.keySet().size() : 0;
                bh.m584a(3, "refMapSize is:  " + size);
                if (size == 0) {
                    map2 = new C0123h(file).m608a();
                    bh.m584a(3, "after loading referrer file:  ");
                }
                dataOutputStream.writeShort(size);
                if (map2 != null) {
                    bh.m584a(3, "sending referrer values because it exists");
                    for (Entry entry2 : map2.entrySet()) {
                        bh.m584a(3, "Referrer Entry:  " + ((String) entry2.getKey()) + "=" + entry2.getValue());
                        dataOutputStream.writeUTF((String) entry2.getKey());
                        bh.m584a(3, "referrer key is :" + ((String) entry2.getKey()));
                        dataOutputStream.writeShort(((List) entry2.getValue()).size());
                        for (String str4 : (List) entry2.getValue()) {
                            dataOutputStream.writeUTF(str4);
                            bh.m584a(3, "referrer value is :" + str4);
                        }
                    }
                }
                dataOutputStream.writeBoolean(false);
                size = map3 != null ? map3.keySet().size() : 0;
                bh.m584a(3, "optionsMapSize is:  " + size);
                dataOutputStream.writeShort(size);
                if (map3 != null) {
                    bh.m584a(3, "sending launch options");
                    for (Entry entry22 : map3.entrySet()) {
                        bh.m584a(3, "Launch Options Key:  " + ((String) entry22.getKey()));
                        dataOutputStream.writeUTF((String) entry22.getKey());
                        dataOutputStream.writeShort(((List) entry22.getValue()).size());
                        for (String str42 : (List) entry22.getValue()) {
                            dataOutputStream.writeUTF(str42);
                            bh.m584a(3, "Launch Options value is :" + str42);
                        }
                    }
                }
                int size2 = list.size();
                dataOutputStream.writeShort(size2);
                for (int i = 0; i < size2; i++) {
                    dataOutputStream.write(((aa) list.get(i)).f363a);
                }
                digestOutputStream.on(false);
                dataOutputStream.write(bcVar.m578a());
                dataOutputStream.close();
                array = byteArrayOutputStream.toByteArray();
                bj.m596a(dataOutputStream);
            } catch (Throwable th2) {
                th = th2;
                bj.m596a(dataOutputStream);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            dataOutputStream = null;
            bj.m596a(dataOutputStream);
            throw th;
        }
        this.f551a = array;
    }
}
