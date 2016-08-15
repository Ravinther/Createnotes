package android.support.v4.widget;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.view.View.BaseSavedState;

/* renamed from: android.support.v4.widget.b */
public final class C0087b extends BaseSavedState {
    public static final Creator CREATOR;
    int f301a;
    int f302b;
    int f303c;

    public C0087b(Parcel parcel) {
        super(parcel);
        this.f301a = 0;
        this.f302b = 0;
        this.f303c = 0;
        this.f301a = parcel.readInt();
    }

    public C0087b(Parcelable parcelable) {
        super(parcelable);
        this.f301a = 0;
        this.f302b = 0;
        this.f303c = 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.f301a);
    }

    static {
        CREATOR = new C0088c();
    }
}
