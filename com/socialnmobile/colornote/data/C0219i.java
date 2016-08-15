package com.socialnmobile.colornote.data;

/* renamed from: com.socialnmobile.colornote.data.i */
public final class C0219i {
    private static char[] f962a;
    private static byte[] f963b;

    static {
        int i;
        int i2 = 0;
        f962a = new char[64];
        char c = 'A';
        int i3 = 0;
        while (c <= 'Z') {
            i = i3 + 1;
            f962a[i3] = c;
            c = (char) (c + 1);
            i3 = i;
        }
        c = 'a';
        while (c <= 'z') {
            i = i3 + 1;
            f962a[i3] = c;
            c = (char) (c + 1);
            i3 = i;
        }
        c = '0';
        while (c <= '9') {
            i = i3 + 1;
            f962a[i3] = c;
            c = (char) (c + 1);
            i3 = i;
        }
        i = i3 + 1;
        f962a[i3] = '+';
        f962a[i] = '/';
        f963b = new byte[128];
        for (int i4 = 0; i4 < f963b.length; i4++) {
            f963b[i4] = (byte) -1;
        }
        while (i2 < 64) {
            f963b[f962a[i2]] = (byte) i2;
            i2++;
        }
    }

    public static char[] m1001a(byte[] bArr) {
        int length = bArr.length;
        int i = ((length * 4) + 2) / 3;
        char[] cArr = new char[(((length + 2) / 3) * 4)];
        int i2 = 0;
        int i3 = 0;
        while (i3 < length) {
            int i4;
            char c;
            int i5 = i3 + 1;
            int i6 = bArr[i3] & 255;
            if (i5 < length) {
                i4 = bArr[i5] & 255;
                i5++;
            } else {
                i4 = 0;
            }
            if (i5 < length) {
                i3 = i5 + 1;
                i5 = bArr[i5] & 255;
            } else {
                i3 = i5;
                i5 = 0;
            }
            int i7 = i6 >>> 2;
            i6 = ((i6 & 3) << 4) | (i4 >>> 4);
            i4 = ((i4 & 15) << 2) | (i5 >>> 6);
            int i8 = i5 & 63;
            i5 = i2 + 1;
            cArr[i2] = f962a[i7];
            i2 = i5 + 1;
            cArr[i5] = f962a[i6];
            if (i2 < i) {
                c = f962a[i4];
            } else {
                c = '=';
            }
            cArr[i2] = c;
            i4 = i2 + 1;
            if (i4 < i) {
                c = f962a[i8];
            } else {
                c = '=';
            }
            cArr[i4] = c;
            i2 = i4 + 1;
        }
        return cArr;
    }

    public static byte[] m1000a(String str) {
        int i = 0;
        char[] toCharArray = str.toCharArray();
        int length = toCharArray.length;
        if (length % 4 != 0) {
            throw new IllegalArgumentException("Length of Base64 encoded input string is not a multiple of 4.");
        }
        int i2 = length;
        while (i2 > 0 && toCharArray[i2 - 1] == '=') {
            i2--;
        }
        int i3 = (i2 * 3) / 4;
        byte[] bArr = new byte[i3];
        int i4 = 0;
        while (i < i2) {
            int i5;
            int i6;
            length = i + 1;
            char c = toCharArray[i];
            i = length + 1;
            char c2 = toCharArray[length];
            if (i < i2) {
                length = i + 1;
                i5 = toCharArray[i];
                i = length;
            } else {
                i5 = 65;
            }
            if (i < i2) {
                length = i + 1;
                i = toCharArray[i];
                i6 = length;
            } else {
                i6 = i;
                i = 65;
            }
            if (c > '\u007f' || c2 > '\u007f' || i5 > 127 || i > 127) {
                throw new IllegalArgumentException("Illegal character in Base64 encoded data.");
            }
            byte b = f963b[c];
            byte b2 = f963b[c2];
            byte b3 = f963b[i5];
            byte b4 = f963b[i];
            if (b < null || b2 < null || b3 < null || b4 < null) {
                throw new IllegalArgumentException("Illegal character in Base64 encoded data.");
            }
            length = (b << 2) | (b2 >>> 4);
            int i7 = ((b2 & 15) << 4) | (b3 >>> 2);
            i5 = ((b3 & 3) << 6) | b4;
            i = i4 + 1;
            bArr[i4] = (byte) length;
            if (i < i3) {
                length = i + 1;
                bArr[i] = (byte) i7;
            } else {
                length = i;
            }
            if (length < i3) {
                i = length + 1;
                bArr[length] = (byte) i5;
            } else {
                i = length;
            }
            i4 = i;
            i = i6;
        }
        return bArr;
    }
}
