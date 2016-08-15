package com.socialnmobile.colornote.sync;

import java.security.NoSuchAlgorithmException;

public final class bv {
    final String f1584a;
    final byte[] f1585b;
    final byte[] f1586c;
    final byte[] f1587d;

    public bv(String str, byte[] bArr, byte[] bArr2, byte[] bArr3) {
        this.f1584a = str;
        this.f1585b = bArr;
        this.f1586c = bArr2;
        this.f1587d = bArr3;
    }

    public final byte[] m1918a(cq cqVar) {
        try {
            String str = this.f1584a;
            bx[] bxVarArr = new bx[]{bz.f1589a, ca.f1599a};
            for (int i = 0; i < 2; i++) {
                bx bxVar = bxVarArr[i];
                if (bxVar.m1924a().equals(str)) {
                    return bxVar.m1925a(cqVar, this);
                }
            }
            throw new NoSuchAlgorithmException(str);
        } catch (Throwable e) {
            throw new bf(e);
        }
    }
}
