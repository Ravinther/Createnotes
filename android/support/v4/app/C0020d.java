package android.support.v4.app;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import android.util.Log;
import java.util.ArrayList;

/* renamed from: android.support.v4.app.d */
final class C0020d implements Parcelable {
    public static final Creator CREATOR;
    final int[] f160a;
    final int f161b;
    final int f162c;
    final String f163d;
    final int f164e;
    final int f165f;
    final CharSequence f166g;
    final int f167h;
    final CharSequence f168i;

    public C0020d(C0018b c0018b) {
        int i = 0;
        for (C0019c c0019c = c0018b.f133b; c0019c != null; c0019c = c0019c.f151a) {
            if (c0019c.f159i != null) {
                i += c0019c.f159i.size();
            }
        }
        this.f160a = new int[(i + (c0018b.f135d * 7))];
        if (c0018b.f142k) {
            i = 0;
            for (C0019c c0019c2 = c0018b.f133b; c0019c2 != null; c0019c2 = c0019c2.f151a) {
                int i2 = i + 1;
                this.f160a[i] = c0019c2.f153c;
                int i3 = i2 + 1;
                this.f160a[i2] = c0019c2.f154d != null ? c0019c2.f154d.f75o : -1;
                int i4 = i3 + 1;
                this.f160a[i3] = c0019c2.f155e;
                i2 = i4 + 1;
                this.f160a[i4] = c0019c2.f156f;
                i4 = i2 + 1;
                this.f160a[i2] = c0019c2.f157g;
                i2 = i4 + 1;
                this.f160a[i4] = c0019c2.f158h;
                if (c0019c2.f159i != null) {
                    int size = c0019c2.f159i.size();
                    i4 = i2 + 1;
                    this.f160a[i2] = size;
                    i2 = 0;
                    while (i2 < size) {
                        i3 = i4 + 1;
                        this.f160a[i4] = ((C0015f) c0019c2.f159i.get(i2)).f75o;
                        i2++;
                        i4 = i3;
                    }
                    i = i4;
                } else {
                    i = i2 + 1;
                    this.f160a[i2] = 0;
                }
            }
            this.f161b = c0018b.f140i;
            this.f162c = c0018b.f141j;
            this.f163d = c0018b.f144m;
            this.f164e = c0018b.f146o;
            this.f165f = c0018b.f147p;
            this.f166g = c0018b.f148q;
            this.f167h = c0018b.f149r;
            this.f168i = c0018b.f150s;
            return;
        }
        throw new IllegalStateException("Not on back stack");
    }

    public C0020d(Parcel parcel) {
        this.f160a = parcel.createIntArray();
        this.f161b = parcel.readInt();
        this.f162c = parcel.readInt();
        this.f163d = parcel.readString();
        this.f164e = parcel.readInt();
        this.f165f = parcel.readInt();
        this.f166g = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f167h = parcel.readInt();
        this.f168i = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
    }

    public final C0018b m150a(C0033r c0033r) {
        C0018b c0018b = new C0018b(c0033r);
        int i = 0;
        int i2 = 0;
        while (i2 < this.f160a.length) {
            C0019c c0019c = new C0019c();
            int i3 = i2 + 1;
            c0019c.f153c = this.f160a[i2];
            if (C0033r.f182a) {
                Log.v("FragmentManager", "Instantiate " + c0018b + " op #" + i + " base fragment #" + this.f160a[i3]);
            }
            int i4 = i3 + 1;
            i2 = this.f160a[i3];
            if (i2 >= 0) {
                c0019c.f154d = (C0015f) c0033r.f188f.get(i2);
            } else {
                c0019c.f154d = null;
            }
            i3 = i4 + 1;
            c0019c.f155e = this.f160a[i4];
            i4 = i3 + 1;
            c0019c.f156f = this.f160a[i3];
            i3 = i4 + 1;
            c0019c.f157g = this.f160a[i4];
            int i5 = i3 + 1;
            c0019c.f158h = this.f160a[i3];
            i4 = i5 + 1;
            int i6 = this.f160a[i5];
            if (i6 > 0) {
                c0019c.f159i = new ArrayList(i6);
                i3 = 0;
                while (i3 < i6) {
                    if (C0033r.f182a) {
                        Log.v("FragmentManager", "Instantiate " + c0018b + " set remove fragment #" + this.f160a[i4]);
                    }
                    i5 = i4 + 1;
                    c0019c.f159i.add((C0015f) c0033r.f188f.get(this.f160a[i4]));
                    i3++;
                    i4 = i5;
                }
            }
            c0018b.m142a(c0019c);
            i++;
            i2 = i4;
        }
        c0018b.f140i = this.f161b;
        c0018b.f141j = this.f162c;
        c0018b.f144m = this.f163d;
        c0018b.f146o = this.f164e;
        c0018b.f142k = true;
        c0018b.f147p = this.f165f;
        c0018b.f148q = this.f166g;
        c0018b.f149r = this.f167h;
        c0018b.f150s = this.f168i;
        c0018b.m148b(1);
        return c0018b;
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeIntArray(this.f160a);
        parcel.writeInt(this.f161b);
        parcel.writeInt(this.f162c);
        parcel.writeString(this.f163d);
        parcel.writeInt(this.f164e);
        parcel.writeInt(this.f165f);
        TextUtils.writeToParcel(this.f166g, parcel, 0);
        parcel.writeInt(this.f167h);
        TextUtils.writeToParcel(this.f168i, parcel, 0);
    }

    static {
        CREATOR = new C0021e();
    }
}
