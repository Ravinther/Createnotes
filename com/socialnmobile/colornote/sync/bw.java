package com.socialnmobile.colornote.sync;

import com.socialnmobile.colornote.data.NoteColumns.NoteMajorColumns;
import com.socialnmobile.colornote.sync.p018b.C0361e;
import com.socialnmobile.util.p011b.p016c.C0354c;
import com.socialnmobile.util.p011b.p017b.C0461c;
import com.socialnmobile.util.p011b.p017b.C0462e;
import java.util.zip.CRC32;

public final class bw extends C0354c {
    public static final bw f1588a;

    public final /* synthetic */ Object m1920a(Object obj) {
        C0361e c0361e = (C0361e) obj;
        String d = c0361e.m1838d("algorithm");
        String d2 = c0361e.m1838d("iv");
        String d3 = c0361e.m1838d(NoteMajorColumns.ENCRYPTION);
        String d4 = c0361e.m1838d("sha1");
        Number g = c0361e.m1841g("crc32");
        byte[] bArr = (byte[]) C0462e.f2255b.m1783d(d2);
        byte[] bArr2 = (byte[]) C0461c.f2253a.m1783d(d3);
        byte[] bArr3 = (byte[]) C0462e.f2255b.m1783d(d4);
        if (g != null) {
            long a = m1919a(bArr2);
            if (a != g.longValue()) {
                throw new bc(g.longValue(), a);
            }
        }
        return new bv(d, bArr, bArr2, bArr3);
    }

    public final /* synthetic */ void m1921a(Object obj, Object obj2) {
        bv bvVar = (bv) obj;
        C0361e c0361e = (C0361e) obj2;
        c0361e.m1833a("algorithm", bvVar.f1584a);
        c0361e.m1834a("iv", bvVar.f1585b, C0462e.f2255b);
        c0361e.m1834a(NoteMajorColumns.ENCRYPTION, bvVar.f1586c, C0461c.f2253a);
        c0361e.m1834a("sha1", bvVar.f1587d, C0462e.f2255b);
        c0361e.m1833a("crc32", Long.valueOf(m1919a(bvVar.f1586c)));
    }

    static {
        f1588a = new bw();
    }

    private static long m1919a(byte[] bArr) {
        CRC32 crc32 = new CRC32();
        crc32.update(bArr);
        return crc32.getValue();
    }
}
