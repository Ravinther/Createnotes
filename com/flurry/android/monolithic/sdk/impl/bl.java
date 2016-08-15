package com.flurry.android.monolithic.sdk.impl;

import android.text.TextUtils;
import java.util.List;

public final class bl {
    private static int f508a;
    private final int f509b;
    private final long f510c;
    private final String f511d;
    private List f512e;

    static {
        f508a = 1;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof bl)) {
            return false;
        }
        bl blVar = (bl) obj;
        if (this.f509b == blVar.f509b && this.f510c == blVar.f510c && TextUtils.equals(this.f511d, blVar.f511d)) {
            if (this.f512e == blVar.f512e) {
                return true;
            }
            if (this.f512e != null && this.f512e.equals(blVar.f512e)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i = (int) (((long) (this.f509b | 17)) | this.f510c);
        if (this.f511d != null) {
            i |= this.f511d.hashCode();
        }
        if (this.f512e != null) {
            return i | this.f512e.hashCode();
        }
        return i;
    }
}
