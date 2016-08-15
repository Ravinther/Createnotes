package android.support.v4.app;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

/* renamed from: android.support.v4.app.x */
final class C0039x implements Parcelable {
    public static final Creator CREATOR;
    final String f217a;
    final int f218b;
    final boolean f219c;
    final int f220d;
    final int f221e;
    final String f222f;
    final boolean f223g;
    final boolean f224h;
    final Bundle f225i;
    Bundle f226j;
    C0015f f227k;

    public C0039x(C0015f c0015f) {
        this.f217a = c0015f.getClass().getName();
        this.f218b = c0015f.f75o;
        this.f219c = c0015f.f84x;
        this.f220d = c0015f.f51F;
        this.f221e = c0015f.f52G;
        this.f222f = c0015f.f53H;
        this.f223g = c0015f.f56K;
        this.f224h = c0015f.f55J;
        this.f225i = c0015f.f77q;
    }

    public C0039x(Parcel parcel) {
        boolean z;
        boolean z2 = true;
        this.f217a = parcel.readString();
        this.f218b = parcel.readInt();
        this.f219c = parcel.readInt() != 0;
        this.f220d = parcel.readInt();
        this.f221e = parcel.readInt();
        this.f222f = parcel.readString();
        if (parcel.readInt() != 0) {
            z = true;
        } else {
            z = false;
        }
        this.f223g = z;
        if (parcel.readInt() == 0) {
            z2 = false;
        }
        this.f224h = z2;
        this.f225i = parcel.readBundle();
        this.f226j = parcel.readBundle();
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int i2;
        int i3 = 1;
        parcel.writeString(this.f217a);
        parcel.writeInt(this.f218b);
        parcel.writeInt(this.f219c ? 1 : 0);
        parcel.writeInt(this.f220d);
        parcel.writeInt(this.f221e);
        parcel.writeString(this.f222f);
        if (this.f223g) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeInt(i2);
        if (!this.f224h) {
            i3 = 0;
        }
        parcel.writeInt(i3);
        parcel.writeBundle(this.f225i);
        parcel.writeBundle(this.f226j);
    }

    static {
        CREATOR = new C0040y();
    }
}
