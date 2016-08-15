package android.support.v4.p001b;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* renamed from: android.support.v4.b.b */
final class C0042b implements Creator {
    final C0043c f228a;

    public C0042b(C0043c c0043c) {
        this.f228a = c0043c;
    }

    public final Object createFromParcel(Parcel parcel) {
        return this.f228a.m220a(parcel, null);
    }

    public final Object[] newArray(int i) {
        return this.f228a.m221a(i);
    }
}
