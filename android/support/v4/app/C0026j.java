package android.support.v4.app;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* renamed from: android.support.v4.app.j */
final class C0026j implements Creator {
    C0026j() {
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new C0025i[i];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new C0025i(parcel);
    }
}
