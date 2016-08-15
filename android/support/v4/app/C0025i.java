package android.support.v4.app;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

/* renamed from: android.support.v4.app.i */
public final class C0025i implements Parcelable {
    public static final Creator CREATOR;
    public final Bundle f170a;

    C0025i(Bundle bundle) {
        this.f170a = bundle;
    }

    C0025i(Parcel parcel) {
        this.f170a = parcel.readBundle();
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeBundle(this.f170a);
    }

    static {
        CREATOR = new C0026j();
    }
}
