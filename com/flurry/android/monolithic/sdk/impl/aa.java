package com.flurry.android.monolithic.sdk.impl;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class aa {
    private static final String f362b;
    byte[] f363a;

    static {
        f362b = aa.class.getSimpleName();
    }

    public aa(byte[] bArr) {
        this.f363a = bArr;
    }

    public aa(ab abVar) {
        Throwable e;
        Closeable closeable = null;
        Closeable dataOutputStream;
        try {
            OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            dataOutputStream = new DataOutputStream(byteArrayOutputStream);
            try {
                dataOutputStream.writeShort(1);
                dataOutputStream.writeUTF(abVar.f364a);
                dataOutputStream.writeLong(abVar.f365b);
                dataOutputStream.writeLong(abVar.f366c);
                dataOutputStream.writeLong(abVar.f367d);
                dataOutputStream.writeUTF(abVar.f368e);
                dataOutputStream.writeUTF(abVar.f369f);
                dataOutputStream.writeByte(abVar.f370g);
                dataOutputStream.writeUTF(abVar.f371h);
                if (abVar.f372i == null) {
                    dataOutputStream.writeBoolean(false);
                } else {
                    dataOutputStream.writeBoolean(true);
                    dataOutputStream.writeDouble(m518a(abVar.f372i.getLatitude()));
                    dataOutputStream.writeDouble(m518a(abVar.f372i.getLongitude()));
                    dataOutputStream.writeFloat(abVar.f372i.getAccuracy());
                }
                dataOutputStream.writeInt(abVar.f373j);
                dataOutputStream.writeByte(-1);
                dataOutputStream.writeByte(-1);
                dataOutputStream.writeByte(abVar.f374k);
                if (abVar.f375l == null) {
                    dataOutputStream.writeBoolean(false);
                } else {
                    dataOutputStream.writeBoolean(true);
                    dataOutputStream.writeLong(abVar.f375l.longValue());
                }
                Map map = abVar.f379p;
                dataOutputStream.writeShort(map.size());
                for (Entry entry : map.entrySet()) {
                    dataOutputStream.writeUTF((String) entry.getKey());
                    dataOutputStream.writeInt(((C0122g) entry.getValue()).f530a);
                }
                List<C0125j> list = abVar.f376m;
                dataOutputStream.writeShort(list.size());
                for (C0125j a : list) {
                    dataOutputStream.write(a.m610a());
                }
                dataOutputStream.writeBoolean(abVar.f380q);
                List list2 = abVar.f378o;
                int i = 0;
                int i2 = 0;
                int i3 = 0;
                while (i < list2.size()) {
                    i3 += ((C0124i) list2.get(i)).m609a().length;
                    if (i3 > 160000) {
                        bh.m584a(5, "Error Log size exceeded. No more event details logged.");
                        break;
                    } else {
                        i2++;
                        i++;
                    }
                }
                dataOutputStream.writeInt(abVar.f377n);
                dataOutputStream.writeShort(i2);
                for (i = 0; i < i2; i++) {
                    dataOutputStream.write(((C0124i) list2.get(i)).m609a());
                }
                dataOutputStream.writeShort(0);
                dataOutputStream.writeShort(0);
                this.f363a = byteArrayOutputStream.toByteArray();
                bj.m596a(dataOutputStream);
            } catch (IOException e2) {
                e = e2;
                closeable = dataOutputStream;
                try {
                    bh.m590b("", e);
                    throw e;
                } catch (Throwable th) {
                    e = th;
                    dataOutputStream = closeable;
                    bj.m596a(dataOutputStream);
                    throw e;
                }
            } catch (Throwable th2) {
                e = th2;
                bj.m596a(dataOutputStream);
                throw e;
            }
        } catch (IOException e3) {
            e = e3;
            bh.m590b("", e);
            throw e;
        } catch (Throwable th3) {
            e = th3;
            dataOutputStream = null;
            bj.m596a(dataOutputStream);
            throw e;
        }
    }

    private static double m518a(double d) {
        return ((double) Math.round(d * 1000.0d)) / 1000.0d;
    }
}
