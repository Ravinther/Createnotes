package com.flurry.android.monolithic.sdk.impl;

import java.security.MessageDigest;
import java.util.zip.CRC32;

public final class bc extends MessageDigest {
    private CRC32 f498a;

    public bc() {
        super("CRC");
        this.f498a = new CRC32();
    }

    protected final void engineReset() {
        this.f498a.reset();
    }

    protected final void engineUpdate(byte b) {
        this.f498a.update(b);
    }

    protected final void engineUpdate(byte[] bArr, int i, int i2) {
        this.f498a.update(bArr, i, i2);
    }

    protected final byte[] engineDigest() {
        long value = this.f498a.getValue();
        return new byte[]{(byte) ((int) ((-16777216 & value) >> 24)), (byte) ((int) ((16711680 & value) >> 16)), (byte) ((int) ((65280 & value) >> 8)), (byte) ((int) ((value & 255) >> 0))};
    }

    public final byte[] m578a() {
        return engineDigest();
    }
}
