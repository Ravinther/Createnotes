package com.flurry.android.monolithic.sdk.impl;

import java.io.Closeable;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ai {
    private static final String f433d;
    boolean f434a;
    List f435b;
    long f436c;

    public ai() {
        this.f436c = -1;
    }

    static {
        f433d = ai.class.getSimpleName();
    }

    public final void m546a(DataOutputStream dataOutputStream, String str, String str2) {
        try {
            dataOutputStream.writeShort(46586);
            dataOutputStream.writeShort(2);
            dataOutputStream.writeUTF(str);
            dataOutputStream.writeUTF(str2);
            dataOutputStream.writeBoolean(this.f434a);
            dataOutputStream.writeLong(this.f436c);
            for (int size = this.f435b.size() - 1; size >= 0; size--) {
                byte[] bArr = ((aa) this.f435b.get(size)).f363a;
                int length = bArr.length;
                if ((length + 2) + dataOutputStream.size() > 50000) {
                    bh.m584a(6, "discarded sessions: " + size);
                    break;
                }
                dataOutputStream.writeShort(length);
                dataOutputStream.write(bArr);
            }
            dataOutputStream.writeShort(0);
            bj.m596a((Closeable) dataOutputStream);
        } catch (Throwable th) {
            bj.m596a((Closeable) dataOutputStream);
        }
    }

    public final boolean m547a(DataInputStream dataInputStream, String str) {
        boolean z = false;
        try {
            int readUnsignedShort = dataInputStream.readUnsignedShort();
            bh.m584a(4, "Magic: " + readUnsignedShort);
            if (readUnsignedShort == 46586) {
                z = m545a(str, dataInputStream);
            } else {
                bh.m584a(3, "Unexpected file type");
            }
            bj.m596a((Closeable) dataInputStream);
            return z;
        } catch (Throwable th) {
            bj.m596a((Closeable) dataInputStream);
        }
    }

    private boolean m545a(String str, DataInputStream dataInputStream) {
        int readUnsignedShort = dataInputStream.readUnsignedShort();
        bh.m584a(3, "File version: " + readUnsignedShort);
        if (readUnsignedShort > 2) {
            bh.m584a(6, "Unknown agent file version: " + readUnsignedShort);
            throw new IOException("Unknown agent file version: " + readUnsignedShort);
        } else if (readUnsignedShort >= 2) {
            String readUTF = dataInputStream.readUTF();
            bh.m584a(3, "Loading API key: " + m544a(str));
            if (readUTF.equals(str)) {
                List arrayList = new ArrayList();
                dataInputStream.readUTF();
                boolean readBoolean = dataInputStream.readBoolean();
                long readLong = dataInputStream.readLong();
                bh.m584a(3, "Loading session reports");
                readUnsignedShort = 0;
                while (true) {
                    int readUnsignedShort2 = dataInputStream.readUnsignedShort();
                    if (readUnsignedShort2 != 0) {
                        byte[] bArr = new byte[readUnsignedShort2];
                        dataInputStream.readFully(bArr);
                        arrayList.add(0, new aa(bArr));
                        readUnsignedShort++;
                        bh.m584a(3, "Session report added: " + readUnsignedShort);
                    } else {
                        bh.m584a(3, "Persistent file loaded");
                        this.f434a = readBoolean;
                        this.f436c = readLong;
                        this.f435b = arrayList;
                        return true;
                    }
                }
            }
            bh.m584a(3, "Api keys do not match, old: " + m544a(str) + ", new: " + m544a(readUTF));
            return false;
        } else {
            bh.m584a(5, "Deleting old file version: " + readUnsignedShort);
            return false;
        }
    }

    private static String m544a(String str) {
        if (str == null || str.length() <= 4) {
            return str;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < str.length() - 4; i++) {
            stringBuilder.append('*');
        }
        stringBuilder.append(str.substring(str.length() - 4));
        return stringBuilder.toString();
    }
}
