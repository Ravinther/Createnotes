package android.support.v4.p001b;

import android.os.Build.VERSION;
import android.os.Parcelable.Creator;

/* renamed from: android.support.v4.b.a */
public final class C0041a {
    public static Creator m219a(C0043c c0043c) {
        if (VERSION.SDK_INT >= 13) {
            C0045e.m222a(c0043c);
        }
        return new C0042b(c0043c);
    }
}
