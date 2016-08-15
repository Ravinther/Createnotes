package com.socialnmobile.colornote.sync;

import java.security.Key;
import java.security.SecureRandom;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;

public abstract class by extends bx {
    public abstract SecretKey m1927a(cq cqVar);

    public final bv m1926a(cq cqVar, byte[] bArr) {
        try {
            String a = m1924a();
            Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
            Key a2 = m1927a(cqVar);
            byte[] bArr2 = new byte[instance.getBlockSize()];
            new SecureRandom().nextBytes(bArr2);
            instance.init(1, a2, new IvParameterSpec(bArr2));
            return new bv(a, bArr2, instance.doFinal(bArr), bx.m1922a(bArr));
        } catch (Throwable e) {
            throw new RuntimeException(e);
        } catch (Throwable e2) {
            throw new RuntimeException(e2);
        } catch (Throwable e22) {
            throw new RuntimeException(e22);
        } catch (Throwable e222) {
            throw new RuntimeException(e222);
        } catch (Throwable e2222) {
            throw new bf(e2222);
        } catch (Throwable e22222) {
            throw new bf(e22222);
        }
    }

    public final byte[] m1928a(cq cqVar, bv bvVar) {
        try {
            Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
            instance.init(2, m1927a(cqVar), new IvParameterSpec(bvVar.f1585b));
            byte[] doFinal = instance.doFinal(bvVar.f1586c);
            byte[] a = bx.m1922a(doFinal);
            if (Arrays.equals(a, bvVar.f1587d)) {
                return doFinal;
            }
            throw new dh(bvVar.f1587d, a);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        } catch (Throwable e2) {
            throw new RuntimeException(e2);
        } catch (Throwable e22) {
            throw new IllegalArgumentException(e22);
        } catch (Throwable e222) {
            throw new RuntimeException(e222);
        } catch (Throwable e2222) {
            throw new bf(e2222);
        } catch (Throwable e22222) {
            throw new bf(e22222);
        }
    }
}
