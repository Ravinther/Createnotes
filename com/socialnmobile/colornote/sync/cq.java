package com.socialnmobile.colornote.sync;

import com.socialnmobile.colornote.sync.p018b.C0361e;

public final class cq {
    final byte[] f1640a;
    final byte[] f1641b;

    public cq(byte[] bArr, byte[] bArr2) {
        int length = bArr.length;
        int length2 = bArr2.length;
        if (length != 16) {
            throw new IllegalArgumentException("size of key128 should be 16 bytes; given " + length + " bytes");
        } else if (length2 != 32) {
            throw new IllegalArgumentException("size of key256 should be 32 bytes; given " + length2 + " bytes");
        } else {
            this.f1640a = (byte[]) bArr.clone();
            this.f1641b = (byte[]) bArr2.clone();
        }
    }

    public final byte[] m1969a() {
        return (byte[]) this.f1640a.clone();
    }

    public final byte[] m1970b() {
        return (byte[]) this.f1641b.clone();
    }

    public final String toString() {
        return ((C0361e) new cr().m1782c(this)).toString();
    }
}
