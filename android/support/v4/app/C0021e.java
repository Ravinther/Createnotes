package android.support.v4.app;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* renamed from: android.support.v4.app.e */
final class C0021e implements Creator {
    C0021e() {
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new C0020d[i];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new C0020d(parcel);
    }
}
