package com.socialnmobile.colornote.data;

import android.content.Context;
import com.socialnmobile.colornote.ColorNote;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

/* renamed from: com.socialnmobile.colornote.data.l */
public final class C0222l {
    Cipher f972a;
    public int f973b;
    private String f974c;
    private String f975d;
    private int f976e;
    private boolean f977f;
    private boolean f978g;
    private SecretKey f979h;
    private int f980i;
    private PBEKeySpec f981j;
    private SecretKeyFactory f982k;
    private byte[] f983l;

    public static C0222l m1006a(int i) {
        C0222l c0222l = null;
        switch (i) {
            case 1:
                c0222l = C0222l.m1009b(10);
                c0222l.m1016a("ColorNote Password");
                break;
            case 2:
                c0222l = C0222l.m1009b(10);
                break;
        }
        c0222l.f973b = i;
        return c0222l;
    }

    public static C0222l m1009b(int i) {
        try {
            byte[] bytes = "ColorNote Fixed Salt".getBytes("UTF-8");
            C0222l c0222l;
            switch (i) {
                case 10:
                    c0222l = new C0222l("PBEWithSHA256And256BitAES-CBC-BC", "BC");
                    c0222l.m1010b(bytes);
                    return c0222l;
                case 20:
                    c0222l = new C0222l("PBEWITHMD5AND128BITAES-CBC-OPENSSL", "BC");
                    c0222l.m1010b(bytes);
                    return c0222l;
                case 30:
                    c0222l = new C0222l("PBEWITHMD5AND128BITAES-CBC-OPENSSL", "BC");
                    c0222l.m1010b(bytes);
                    return c0222l;
                default:
                    throw new RuntimeException("No Crypto Set" + i);
            }
        } catch (UnsupportedEncodingException e) {
            return null;
        }
    }

    public static C0222l m1007a(Context context) {
        C0222l a;
        if (C0213c.m965d(context)) {
            a = C0222l.m1006a(2);
            a.m1017b(C0213c.m964c(context));
        } else {
            a = C0222l.m1006a(1);
            a.m1016a("ColorNote Password");
        }
        a.m1019c(1);
        return a;
    }

    private C0222l(String str, String str2) {
        this.f977f = false;
        this.f978g = false;
        this.f983l = null;
        this.f974c = str;
        this.f975d = str2;
        this.f976e = 20;
    }

    private void m1010b(byte[] bArr) {
        this.f983l = bArr;
        this.f978g = false;
    }

    public final boolean m1016a(String str) {
        boolean z = false;
        this.f977f = z;
        if (str == null) {
            throw new RuntimeException("no password");
        } else if (this.f983l == null) {
            throw new RuntimeException("no salt");
        } else {
            try {
                this.f982k = SecretKeyFactory.getInstance(this.f974c, this.f975d);
                this.f981j = new PBEKeySpec(str.toCharArray(), this.f983l, this.f976e);
                try {
                    this.f979h = new SecretKeySpec(this.f982k.generateSecret(this.f981j).getEncoded(), this.f974c);
                    return true;
                } catch (InvalidKeySpecException e) {
                    ColorNote.m651a("setPassword(): " + e.toString());
                    return z;
                }
            } catch (NoSuchAlgorithmException e2) {
                ColorNote.m651a("Crypto : " + e2.toString());
                return z;
            } catch (NoSuchProviderException e3) {
                ColorNote.m651a("Crypto : " + e3.toString());
                return z;
            }
        }
    }

    public final boolean m1017b(String str) {
        this.f977f = false;
        if (str == null) {
            throw new RuntimeException("no key");
        } else if (this.f983l == null) {
            throw new RuntimeException("no salt");
        } else {
            this.f979h = new SecretKeySpec(C0219i.m1000a(str), this.f974c);
            return true;
        }
    }

    public final boolean m1019c(int i) {
        if (i == 1) {
            return m1008a(true);
        }
        return m1008a(false);
    }

    private boolean m1008a(boolean z) {
        this.f972a = null;
        try {
            this.f972a = Cipher.getInstance(this.f974c, this.f975d);
        } catch (NoSuchAlgorithmException e) {
            ColorNote.m651a("initCipher(): " + e.toString());
        } catch (NoSuchPaddingException e2) {
            ColorNote.m651a("initCipher(): " + e2.toString());
        } catch (NoSuchProviderException e3) {
            ColorNote.m651a("initCipher(): " + e3.toString());
        }
        if (this.f972a == null) {
            return false;
        }
        if (z) {
            try {
                this.f972a.init(1, this.f979h);
                this.f980i = 1;
            } catch (InvalidKeyException e4) {
                ColorNote.m651a("encrypt(): " + e4.toString());
                return false;
            }
        }
        this.f972a.init(2, this.f979h);
        this.f980i = 2;
        this.f977f = true;
        return true;
    }

    private byte[] m1011e(String str) {
        byte[] bArr = null;
        if (str != null && this.f977f && this.f980i == 1) {
            try {
                bArr = this.f972a.doFinal(str.getBytes("UTF-8"));
            } catch (IllegalBlockSizeException e) {
                ColorNote.m651a("encrypt(): " + e.toString());
            } catch (BadPaddingException e2) {
                ColorNote.m651a("encrypt(): " + e2.toString());
            } catch (UnsupportedEncodingException e3) {
                ColorNote.m651a("encrypt(): " + e3.toString());
            }
        }
        return bArr;
    }

    public final String m1018c(String str) {
        byte[] e = m1011e(str);
        if (e == null) {
            return null;
        }
        return String.valueOf(C0219i.m1001a(e));
    }

    public final String m1013a(byte[] bArr) {
        if (bArr == null || !this.f977f || this.f980i != 2) {
            return null;
        }
        try {
            return new String(this.f972a.doFinal(bArr), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            return null;
        }
    }

    public final String m1020d(String str) {
        return m1013a(C0219i.m1000a(str));
    }

    public final String m1012a() {
        return String.valueOf(C0219i.m1001a(this.f979h.getEncoded()));
    }

    public final void m1014a(String str, int i, String str2) {
        Throwable th;
        CipherInputStream cipherInputStream;
        InputStream inputStream;
        FileInputStream fileInputStream;
        int i2 = 0;
        CipherInputStream cipherInputStream2 = null;
        byte[] bArr = new byte[10240];
        try {
            InputStream fileInputStream2 = new FileInputStream(str);
            while (i2 < i) {
                try {
                    fileInputStream2.read();
                    i2++;
                } catch (Throwable th2) {
                    th = th2;
                    cipherInputStream = null;
                    inputStream = fileInputStream2;
                }
            }
            FileOutputStream fileOutputStream = new FileOutputStream(str2);
            try {
                cipherInputStream = new CipherInputStream(fileInputStream2, this.f972a);
                while (true) {
                    try {
                        i2 = cipherInputStream.read(bArr);
                        if (i2 >= 0) {
                            fileOutputStream.write(bArr, 0, i2);
                        } else {
                            try {
                                fileInputStream2.close();
                                cipherInputStream.close();
                                return;
                            } catch (IOException e) {
                                return;
                            }
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        cipherInputStream2 = cipherInputStream;
                        cipherInputStream = fileOutputStream;
                        fileInputStream = fileInputStream2;
                    }
                }
            } catch (Throwable th4) {
                th = th4;
                Object obj = fileOutputStream;
                inputStream = fileInputStream2;
                if (cipherInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e2) {
                        throw th;
                    }
                }
                if (cipherInputStream2 != null) {
                    cipherInputStream2.close();
                }
                throw th;
            }
        } catch (Throwable th5) {
            th = th5;
            cipherInputStream = null;
            fileInputStream = null;
            if (cipherInputStream != null) {
                fileInputStream.close();
            }
            if (cipherInputStream2 != null) {
                cipherInputStream2.close();
            }
            throw th;
        }
    }

    public final void m1015a(String str, String str2) {
        m1014a(str, 0, str2);
    }
}
