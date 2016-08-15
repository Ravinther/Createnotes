package android.support.v4.p001b;

import android.os.Parcel;
import android.os.Parcelable.ClassLoaderCreator;

/* renamed from: android.support.v4.b.d */
final class C0044d implements ClassLoaderCreator {
    private final C0043c f229a;

    public C0044d(C0043c c0043c) {
        this.f229a = c0043c;
    }

    public final Object createFromParcel(Parcel parcel) {
        return this.f229a.m220a(parcel, null);
    }

    public final Object createFromParcel(Parcel parcel, ClassLoader classLoader) {
        return this.f229a.m220a(parcel, classLoader);
    }

    public final Object[] newArray(int i) {
        return this.f229a.m221a(i);
    }
}
