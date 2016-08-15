package android.support.v4.app;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

/* renamed from: android.support.v4.app.v */
final class C0037v implements Parcelable {
    public static final Creator CREATOR;
    C0039x[] f214a;
    int[] f215b;
    C0020d[] f216c;

    public C0037v(Parcel parcel) {
        this.f214a = (C0039x[]) parcel.createTypedArray(C0039x.CREATOR);
        this.f215b = parcel.createIntArray();
        this.f216c = (C0020d[]) parcel.createTypedArray(C0020d.CREATOR);
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedArray(this.f214a, i);
        parcel.writeIntArray(this.f215b);
        parcel.writeTypedArray(this.f216c, i);
    }

    static {
        CREATOR = new C0038w();
    }
}
